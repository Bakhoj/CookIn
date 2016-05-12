package data;

import android.util.Log;

import com.firebase.client.ChildEventListener;
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

    public String uploadDinner(Banquet banquet) {

        Firebase postRef = Data.getInstance().mFirebase.child("dinners");
        Firebase newPostRef = postRef.push();

        newPostRef.setValue(banquet);
        String postId = newPostRef.getKey();
        banquet.setDinnerId(postId);

        return postId;
    }

    public List<Banquet> downloadAllDinnersFrom(String facebookId) {
        final List<Banquet> banquetList = new ArrayList<>();
        Log.i("FireBHandler", "downloadAllDinnersFrom '" + facebookId + "' has started");
        Firebase ref = Data.getInstance().mFirebase.child("dinners");
        Query queryRef = ref.orderByChild("hostId").equalTo(facebookId);

        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int childrenCount = (int) dataSnapshot.getChildrenCount();
                Log.i("FireBHandler", "ChildrenCount: " + childrenCount);
                Iterable<DataSnapshot> dataSnapshotChildren = dataSnapshot.getChildren();
                DataSnapshot newDataSnapshot = dataSnapshotChildren.iterator().next();
                for (int i = 0; i < childrenCount; i++) {
                //while (dataSnapshotChildren.iterator().hasNext()){
                    Banquet mBanquet = new Banquet();
                    mBanquet.setDinnerId(newDataSnapshot.getKey());

                    mBanquet.setTitle(newDataSnapshot.child("title").getValue(String.class));
                    mBanquet.setDescription(newDataSnapshot.child("description").getValue(String.class));
                    mBanquet.setPricetag((newDataSnapshot.child("pricetag").getValue(int.class)));
                    mBanquet.setMaxGuest(newDataSnapshot.child("maxGuest").getValue(int.class));
                    mBanquet.setHostId(newDataSnapshot.child("hostId").getValue(String.class));
                    mBanquet.setStartDate(new Date(newDataSnapshot.child("startDate").getValue(long.class)));
                    mBanquet.setDeadlineDate(new Date((newDataSnapshot.child("deadlineDate").getValue(long.class))));

                    DataSnapshot guestRef = dataSnapshot.child("guests");
                    while(guestRef.getChildren().iterator().hasNext()) {
                        mBanquet.addGuest((String) guestRef.getValue());
                        guestRef.getChildren().iterator().next();
                    }
                    banquetList.add(mBanquet);
                    Log.i("FireBHandler", mBanquet.toString());
                    if(dataSnapshotChildren.iterator().hasNext()) {newDataSnapshot = dataSnapshotChildren.iterator().next();}
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        Log.i("FireBHandler", "downloadAllDinnersFrom has ended");
        return banquetList;
    }

    public List<Banquet> downloadAllDinnersExceptFrom(String facebookId) {
        return new ArrayList<>();
    }
}
