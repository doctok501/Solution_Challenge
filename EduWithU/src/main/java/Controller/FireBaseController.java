package Controller;

import Service.FirebaseService1;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FireBaseController {

    @PostMapping("/files")
    public String uploadFile (@RequestParam("file") MultipartFile file, String nameFile)
        throws IOException, FirebaseAuthException{
        if (file.isEmpty()){
            return "is empty";
        }
        return FirebaseService1.uploadFiles(file, nameFile);
    }
}
