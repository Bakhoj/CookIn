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
        /* Set the dinners' id to null, making sure the dinner will be a new one in the database */
        banquet.setDinnerId(null);
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
        Data.getInstance().hostBanquets.add(banquet);
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

        /* returns False if the dinner haven't been uploaded before */
        if(id == null) {
            return false;
        }

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
     * Remove Dinner
     * Will remove the dinner if it exists, if you need the dinner again,
     * then bad luck, it's gone when you call this one.
     * @param banquet - the dinner you wish to remove
     * @return if the dinner existed or not
     */
    public boolean removeDinner(Banquet banquet) {
        String id = banquet.getDinnerId();

        if(id == null) {
            return false;
        }

        Firebase postRef = Data.getInstance().mFirebase.child("dinners");
        postRef.child(id).removeValue();
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
            public void onDataChange(DataSnapshot snapshot) {
                int childrenCount = (int) snapshot.getChildrenCount();
                Log.i("FireBHandler", "ChildrenCount: " + childrenCount);

                /* get all the children(dinners) in the dinners database*/
                Iterable<DataSnapshot> snapshotChildren = snapshot.getChildren();
                DataSnapshot newDataSnapshot;

                /* Run for all the children */
                for (int i = 0; i < childrenCount; i++) {
                    /* Get the next child (starts from nothing) of dinners */
                    newDataSnapshot = snapshotChildren.iterator().next();
                    /* Create the dinner to be added to the dinner list */
                    Banquet mBanquet = new Banquet();
                    /* Set the unique key */
                    mBanquet.setDinnerId(newDataSnapshot.getKey());

                    /* Get and set all the dinner data */
                    mBanquet.setHostId(newDataSnapshot.child("hostId").getValue(String.class));
                    mBanquet.setTitle(newDataSnapshot.child("title").getValue(String.class));
                    mBanquet.setDescription(newDataSnapshot.child("description").getValue(String.class));
                    mBanquet.setPricetag((newDataSnapshot.child("pricetag").getValue(int.class)));
                    mBanquet.setMaxGuest(newDataSnapshot.child("maxGuest").getValue(int.class));
                    mBanquet.setStartDate(new Date(newDataSnapshot.child("startDate").getValue(long.class)));
                    mBanquet.setDeadlineDate(new Date((newDataSnapshot.child("deadlineDate").getValue(long.class))));

                    /* Get all the guest children */
                    Iterable<DataSnapshot> dataSnapshotChildrenGuest = newDataSnapshot.child("guests").getChildren();
                    DataSnapshot guestRef;
                    int childrenCountGuest = (int) newDataSnapshot.child("guests").getChildrenCount();

                    for (int j = 0; j < childrenCountGuest; j++) {
                        guestRef = dataSnapshotChildrenGuest.iterator().next();
                        mBanquet.addGuest(guestRef.getValue(String.class));
                    }
                    banquetList.add(mBanquet);
                    Log.i("FireBHandler", mBanquet.toString());
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
     * will download all dinners except from the userId given,
     * the dinners will be sorted by startDate of the dinners
     * @param facebookId - The given userId
     * @return a List of all the dinners from everyone else then @facebookId
     */
    public List<Banquet> downloadAllDinnersExceptFrom(final String facebookId) {
        /* The List of dinners to be returned in the end of the method*/
        final List<Banquet> banquetList = new ArrayList<>();
        Log.i("FireBHandler", "downloadAllDinnersFrom '" + facebookId + "' has started");
        /* Set the database reference to dinners */
        Firebase ref = Data.getInstance().mFirebase.child("dinners");
        /* Set the query reference to order by hostId */
        Query queryRef = ref.orderByChild("startDate");

        /* Set up the listener to handle a single query call*/
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                int childrenCount = (int) snapshot.getChildrenCount();
                Log.i("FireBHandler", "Total ChildrenCount: " + childrenCount);

                /* get all the children(dinners) in the dinners database*/
                Iterable<DataSnapshot> snapshotChildren = snapshot.getChildren();
                DataSnapshot newDataSnapshot;

                /* Run for all the children */
                for (int i = 0; i < childrenCount; i++) {
                    /* Get the next child (starts from nothing) of dinners */
                    newDataSnapshot = snapshotChildren.iterator().next();
                    /* Create the dinner to be added to the dinner list */
                    Banquet mBanquet = new Banquet();
                    /* Set the unique key */
                    mBanquet.setDinnerId(newDataSnapshot.getKey());

                    /* get and set the hostId,
                    *  if the hostId matches the excluded Id then skip */
                    mBanquet.setHostId(newDataSnapshot.child("hostId").getValue(String.class));
                    if(!mBanquet.getHostId().equals(facebookId)) {
                        /* Get and set all the dinner data */
                        mBanquet.setTitle(newDataSnapshot.child("title").getValue(String.class));
                        mBanquet.setDescription(newDataSnapshot.child("description").getValue(String.class));
                        mBanquet.setPricetag((newDataSnapshot.child("pricetag").getValue(int.class)));
                        mBanquet.setMaxGuest(newDataSnapshot.child("maxGuest").getValue(int.class));
                        mBanquet.setStartDate(new Date(newDataSnapshot.child("startDate").getValue(long.class)));
                        mBanquet.setDeadlineDate(new Date((newDataSnapshot.child("deadlineDate").getValue(long.class))));

                    /* Get all the guest children */
                        Iterable<DataSnapshot> dataSnapshotChildrenGuest = newDataSnapshot.child("guests").getChildren();
                        DataSnapshot guestRef;
                        int childrenCountGuest = (int) newDataSnapshot.child("guests").getChildrenCount();

                        for (int j = 0; j < childrenCountGuest; j++) {
                            guestRef = dataSnapshotChildrenGuest.iterator().next();
                            mBanquet.addGuest(guestRef.getValue(String.class));
                        }
                        banquetList.add(mBanquet);
                        Log.i("FireBHandler", mBanquet.toString());
                    }
                }
                Log.i("FireBHandler", "ChildrenCount without exception: " + banquetList.size());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Log.i("FireBHandler", "downloadAllDinnersFrom has ended");
        return banquetList;
    }
}
