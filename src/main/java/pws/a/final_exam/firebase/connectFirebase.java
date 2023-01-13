/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package pws.a.final_exam.firebase;
import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

/**
 *
 * @author eunannana
 */
@Service
public class connectFirebase {
    @PostConstruct
    public void check() {
        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("./serviceAccountKey.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
  .build();


    FirebaseApp.initializeApp(options);
        } catch (Exception e) {
           
            e.printStackTrace();
        }

       

    }
}

