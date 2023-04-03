package Service;

import User.User;
import com.google.api.client.util.Value;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
/*
@Service
public class FireBaseService {
    @Value("${app.firebase-bucket}")
    private static String firebaseBucket;

    public static String uploadFiles(MultipartFile file, String nameFile)
        throws IOException, FirebaseAuthException{
        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        InputStream content = new ByteArrayInputStream(file.getBytes());
        Blob blob = bucket.create(nameFile.toString(), content, file.getContentType());
        return blob.getMediaLink();
    }
}
*/
@Slf4j
@Service
public class FirebaseService1 {

    public static final String Member = "user";

    public void insertUser() throws Exception {

        Firestore db = FirestoreClient.getFirestore();
        User user = new User();
        user.setId("4444");
        user.setName("4444");
        ApiFuture<WriteResult> apiFuture = db.collection(Member).document("user_4").set(user);

        log.info(apiFuture.get().getUpdateTime().toString());
    }


    public void selectUser() throws Exception {

        Firestore db = FirestoreClient.getFirestore();
        User user = new User();
        ApiFuture<DocumentSnapshot> apiFuture = db.collection(Member).document("user_4").get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
        if(documentSnapshot != null) {
            user = documentSnapshot.toObject(User.class);
            assert user != null;
            log.info(user.toString());
        }else {
            log.error("error");
        }
    }
    @Value("${app.firebase-bucket}")
    private static String firebaseBucket;

    public static String uploadFiles(MultipartFile file, String nameFile)
            throws IOException, FirebaseAuthException{
        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        InputStream content = new ByteArrayInputStream(file.getBytes());
        Blob blob = bucket.create(nameFile.toString(), content, file.getContentType());
        return blob.getMediaLink();
    }
}