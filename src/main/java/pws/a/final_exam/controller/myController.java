/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package pws.a.final_exam.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pws.a.final_exam.model.entity.Mail;
import pws.a.final_exam.service.myService;
/**
 *
 * @author eunannana
 * Nama : Annisa Divayu Andriyani
 * NIM : 20200140136
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class myController {
     @Autowired
    private myService myService;

    @GetMapping("/check")
    @ResponseBody
    public String checkAPI(){
        return "hello";
    }

    @PostMapping("/mail")
    public String saveMail(@RequestBody Mail mail) throws InterruptedException, ExecutionException{
        
        return myService.save(mail);
        
    }

    @GetMapping("/mailall")
    public List<Mail> viewMailAll() throws InterruptedException, ExecutionException{
        
        return myService.getMailAll();
        
    }

    @GetMapping("/mail/{id_surat}")
    public Mail viewMail(@PathVariable String id_surat) throws InterruptedException, ExecutionException{
        
        return myService.getMail(id_surat);
        
    }

    @PutMapping("/mail")
    public String updateMail(@RequestBody Mail mail) throws InterruptedException, ExecutionException{
        
        return myService.update(mail);
        
    }

    @DeleteMapping("/mail/{nomor_surat}")
    public String deleteMail(@PathVariable String id_surat) throws InterruptedException, ExecutionException{
        
        return myService.delete(id_surat);
        
    }

}
