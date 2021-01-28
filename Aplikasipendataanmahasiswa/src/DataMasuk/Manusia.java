/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataMasuk;

import java.util.Date;


public class Manusia {
    protected String nama;
    protected Date tglLahir;

    public Manusia(String nama, Date tgl_lahir) {
        this.nama = nama;
        this.tglLahir = tgl_lahir;
    }
    
    public Manusia() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }
}
