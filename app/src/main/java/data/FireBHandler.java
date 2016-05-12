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

    public String uploadDinner(Banquet banquet, Firebase firebase) {

        Firebase postRef = firebase.child("dinners");
        Firebase newPostRef = postRef.push();

        newPostRef.setValue(banquet);
        String postId = newPostRef.getKey();
        banquet.setDinnerId(postId);

        return postId;
    }

    public List<Banquet> downloadAllDinnersFrom(String facebookId, Firebase firebase) {
        final List<Banquet> banquetList = new ArrayList<>();
        Log.i("FireBHandler", "downloadAllDinnersFrom '" + facebookId + "' has started");
        Firebase ref = firebase.child("dinners");
        Query queryRef = ref.orderByChild("hostId").equalTo(facebookId);

        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataSnapshot.getChildrenCount();
                dataSnapshot.getChildren().iterator().next();
                while (dataSnapshot.getChildren().iterator().hasNext()){
                    Banquet mBanquet = new Banquet();
                    mBanquet.setDinnerId(dataSnapshot.getKey());
                    mBanquet.setTitle((String) dataSnapshot.child("title").getValue());
                    mBanquet.setDescription((String) dataSnapshot.child("description").getValue());
                    Log.i("FireBHandler", (String) dataSnapshot.child("pricetag").getValue());
                    mBanquet.setPricetag(Integer.parseInt(dataSnapshot.child("pricetag").getValue().toString()));
                    mBanquet.setMaxGuest((int) dataSnapshot.child("maxGuest").getValue());
                    mBanquet.setHostId((String) dataSnapshot.child("hostId").getValue());
                    mBanquet.setStartDate(new Date((long)dataSnapshot.child("startDate").getValue()));
                    mBanquet.setDeadlineDate(new Date((long)dataSnapshot.child("deadlineDate").getValue()));

                    DataSnapshot guestRef = dataSnapshot.child("guests");
                    while(guestRef.getChildren().iterator().hasNext()) {
                        mBanquet.addGuest((String) guestRef.getValue());
                        guestRef.getChildren().iterator().next();
                    }
                    banquetList.add(mBanquet);
                    Log.i("FireBHandler", mBanquet.toString());
                    dataSnapshot.getChildren().iterator().next();
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
