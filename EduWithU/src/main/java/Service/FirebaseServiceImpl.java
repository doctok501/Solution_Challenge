package Service;

import User.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

public class FirebaseServiceImpl {

    public static final String Member = "member";


    public String insertMember (User user) throws Exception {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture =
                firestore.collection(String.valueOf(user)).document(user.getId()).set(user);
        return apiFuture.get().getUpdateTime().toString();
    }
}
