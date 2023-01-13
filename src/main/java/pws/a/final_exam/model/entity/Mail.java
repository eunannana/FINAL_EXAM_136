/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.a.final_exam.model.entity;

import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author eunannana
 */
public class Mail {
    private String id_surat;
    private int nomor_surat;
    private String judul_surat;
    private String tembusan;
    private MultipartFile file;
    private String timestamp;

    public String getId_surat() {
        return id_surat;
    }

    public void setId_surat(String id_surat) {
        this.id_surat = id_surat;
    }

    public int getNomor_surat() {
        return nomor_surat;
    }

    public void setNomor_surat(int nomor_surat) {
        this.nomor_surat = nomor_surat;
    }

    public String getJudul_surat() {
        return judul_surat;
    }

    public void setJudul_surat(String judul_surat) {
        this.judul_surat = judul_surat;
    }

    public String getTembusan() {
        return tembusan;
    }

    public void setTembusan(String tembusan) {
        this.tembusan = tembusan;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = now.format(formatter);
        return timestamp;
    }

    public void setTimestamp(String timestamp) {     
                this.timestamp = timestamp;
    }

}