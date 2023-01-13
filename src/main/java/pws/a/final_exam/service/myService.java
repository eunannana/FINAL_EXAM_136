/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package pws.a.final_exam.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Service;
import pws.a.final_exam.model.entity.Mail;

/**
 *
 * @author eunannana
 */
@Service
public class myService {
    
    private static final String COLLECTION_NAME = "mail";
    
    
    public String save(Mail mail) throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture= dbfirestore.collection(COLLECTION_NAME).document(mail.getId_surat()).set(mail);

        return collectionApiFuture.get().getUpdateTime().toString() ;
    }

    public Mail getMail(String id_surat) throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference=dbfirestore.collection(COLLECTION_NAME).document(id_surat);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot doc = future.get();

        Mail mail = null;
        
        if(doc.exists()){
            mail = doc.toObject(Mail.class);
        }

        return mail;
    }

    public String update(Mail mail) throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture= dbfirestore.collection(COLLECTION_NAME).document(mail.getId_surat()).set(mail);

        return collectionApiFuture.get().getUpdateTime().toString() ;
    }

    public String delete(String id_surat) throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture= dbfirestore.collection(COLLECTION_NAME).document(id_surat).delete();

        return "This data with ID : " + id_surat + " Has been Deleted";
    }

    public List<Mail> getMailAll() throws InterruptedException, ExecutionException{
        Firestore dbfirestore = FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference=dbfirestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<Mail> MailList=new ArrayList<>();
       Mail mail = null;

        while(iterator.hasNext()){
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future=documentReference1.get();
            DocumentSnapshot doc = future.get();
           mail = doc.toObject(Mail.class);
           MailList.add(mail);
        }
        return MailList;
    }

}
    

