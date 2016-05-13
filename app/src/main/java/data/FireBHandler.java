package data;

import android.util.Log;

import com.facebook.Profile;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by anders on 12-05-2016.
 */
public class FireBHandler {

    private static FireBHandler ourInstance = new FireBHandler();

    public static FireBHandler getInstance() {
        return ourInstance;
    }

    private FireBHandler() {
    }

    /**
     * Upload Dinner
     * udload a newly made dinner to the DB, it will also set the unique dinnerId for the dinner.
     * @param banquet - the dinner to be uploaded
     * @return The Unique dinnerId given to the dinner uploaded
     */
    public String uploadDinner(Banquet banquet) {
        /* Set the rightful owner to the Dinner,
        *  only the Authenticated user is allowed to make dinners for themself */
        banquet.setHostId(Profile.getCurrentProfile().getId());
        /* Set the direction for the database reference and
        *  do .push() to add it as a new unique dinner */
        Firebase postRef = Data.getInstance().mFirebase.child("dinners");
        Firebase newPostRef = postRef.push();
        newPostRef.setValue(banquet);
        /* Get the unique key created for the dinner and
        *  add it to the given dinner object */
        String postId = newPostRef.getKey();
        banquet.setDinnerId(postId);

        /* return the unique key created for the dinner,
        *  if someone wants to use it asap for some reason? */
        return postId;
    }

    /**
     * Update Dinner
     * Update a already existing dinner to the database
     * @param banquet - the dinner to be updated
     * @return True
     */
    public boolean updateDinner(Banquet banquet) {
        /* Save and Remove the unique key from the Banquet
        *  to save space in the database by not saving the key twice */
        String id = banquet.getDinnerId();
        banquet.setDinnerId(null);

        /* Set the direction for the database reference and
        *  add the value to the right id index */
        Firebase postRef = Data.getInstance().mFirebase.child("dinners");
        postRef.child(id).setValue(banquet);

        /* Save the unique key to the Banquet again
        *  and finish the method */
        banquet.setDinnerId(id);

        /* The return value doesn't have a purpose yet,
        *  no planes for it either */
        return true;
    }

    /**
     * Download All Dinners From
     * will download all the dinners associated with the given userId
     * @param facebookId - The userId of the dinners
     * @return a List of all the dinners the given user has
     */
    public List<Banquet> downloadAllDinnersFrom(String facebookId) {
        /* The List of dinners to be returned in the end of the method*/
        final List<Banquet> banquetList = new ArrayList<>();
        Log.i("FireBHandler", "downloadAllDinnersFrom '" + facebookId + "' has started");
        /* Set the database reference to dinners */
        Firebase ref = Data.getInstance().mFirebase.child("dinners");
        /* Set the query reference to only get HostID equal to the given userId */
        Query queryRef = ref.orderByChild("hostId").equalTo(facebookId);

        /* Set up the listener to handle a single query call*/
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int childrenCount = (int) dataSnapshot.getChildrenCount();
                Log.i("FireBHandler", "ChildrenCount: " + childrenCount);

                /* get all the children(dinners) in the dinners database, and
                *  get the next iterator (goto the first dinner) */
                Iterable<DataSnapshot> dataSnapshotChildren = dataSnapshot.getChildren();
                DataSnapshot newDataSnapshot;

                /* Run for all the children */
                for (int i = 0; i < childrenCount; i++) {
                //while (dataSnapshotChildren.iterator().hasNext()){
                    newDataSnapshot = dataSnapshotChildren.iterator().next();
                    Banquet mBanquet = new Banquet();
                    /* Set the unique key */
                    mBanquet.setDinnerId(newDataSnapshot.getKey());

                    /* Get and set all the dinner data */
                    mBanquet.setTitle(newDataSnapshot.child("title").getValue(String.class));
                    mBanquet.setDescription(newDataSnapshot.child("description").getValue(String.class));
                    mBanquet.setPricetag((newDataSnapshot.child("pricetag").getValue(int.class)));
                    mBanquet.setMaxGuest(newDataSnapshot.child("maxGuest").getValue(int.class));
                    mBanquet.setHostId(newDataSnapshot.child("hostId").getValue(String.class));
                    mBanquet.setStartDate(new Date(newDataSnapshot.child("startDate").getValue(long.class)));
                    mBanquet.setDeadlineDate(new Date((newDataSnapshot.child("deadlineDate").getValue(long.class))));

                    /* Set database reference to */
                    Iterable<DataSnapshot> dataSnapshotChildrenGuest = newDataSnapshot.child("guests").getChildren();
                    DataSnapshot guestRef;
                    int childrenCountGuest = (int) newDataSnapshot.child("guests").getChildrenCount();
                    //while(guestRef.getChildren().iterator().hasNext()) {
                    for (int j = 0; j < childrenCountGuest; j++) {
                        guestRef = dataSnapshotChildrenGuest.iterator().next();
                        mBanquet.addGuest(guestRef.getValue(String.class));
                        //if(dataSnapshotChildrenGuest.iterator().hasNext()) {guestRef = dataSnapshotChildrenGuest.iterator().next(); }
                    }
                    banquetList.add(mBanquet);
                    Log.i("FireBHandler", mBanquet.toString());
                    /* yes only set next if has next, no while with .hasNext() doesn't work ... dunno why !!*/
                    //if(dataSnapshotChildren.iterator().hasNext()) {newDataSnapshot = dataSnapshotChildren.iterator().next();}
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Log.i("FireBHandler", "downloadAllDinnersFrom has ended");
        return banquetList;
    }

    /**
     * Download All Dinners Except From
     * will download all dinners except from the userId given
     * @param facebookId - The given userId
     * @return a List of all the dinners from everyone else then @facebookId
     */
    public List<Banquet> downloadAllDinnersExceptFrom(String facebookId) {
        return new ArrayList<>();
    }
}
