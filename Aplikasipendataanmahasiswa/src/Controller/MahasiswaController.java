/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataMasuk.DataMahasiswa;
import DataMasuk.DataJurusan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class MahasiswaController {
    int indexLogin;
    public DataMahasiswa getDataMahasiswa(int index) {
        return AllObjectModel.mahasiswa.getProfileMahasiswa(index);
    }
    
    public int login(String npm, String password) {
        return AllObjectModel.mahasiswa.cekMahasiswa(npm, password);
    }
    
    public DataMahasiswa mahasiswaEntity(int index) {
        return AllObjectModel.mahasiswa.getProfileMahasiswa(index);
    }
    
    public void insertDataMahasiswa(String npm, String nama, Date tanggal_lahir, int index_jurusan, String no_telp, String password) {
        DataMahasiswa mahasiswa = new DataMahasiswa();
        mahasiswa.setNpm(npm);
        mahasiswa.setNama(nama);
        mahasiswa.setTglLahir(tanggal_lahir);
        mahasiswa.setIndex_jurusan(index_jurusan);
        mahasiswa.setNo_telp(no_telp);
        mahasiswa.setPassword(password);
        AllObjectModel.mahasiswa.insertMahasiswaModel(mahasiswa);
    }
    
    public void deleteDataMahasiswa(int index) {
        AllObjectModel.mahasiswa.hapusMahasiswaModel(index);
    }
    
    public ArrayList<DataMahasiswa> getDataMahasiswa() {
        return AllObjectModel.mahasiswa.getAllMahasiswa();
    }
    
    public void updateDataMahasiswa(int index, String data, String ubah, String tipe) throws ParseException {
        switch(tipe) {
            case "string" :
                switch(ubah) {
                    case "npm":
                        AllObjectModel.mahasiswa.editNpmMahasiswaModel(index, data);
                        break;
                    case "nama":
                        AllObjectModel.mahasiswa.editNamaMahasiswaModel(index, data);
                        break;
                    case "noTelp":
                        AllObjectModel.mahasiswa.editNoTelpMahasiswaModel(index, data);
                        break;
                    case "password":
                        AllObjectModel.mahasiswa.editPasswordMahasiswaModel(index, data);
                        break;
                }
                break;
            case "date" :
                AllObjectModel.mahasiswa.editMahasiswaModel(index, new SimpleDateFormat("dd/MM/yyyy").parse(data));
                break;
            case "int":
                AllObjectModel.mahasiswa.editMahasiswaModel(index, Integer.parseInt(data));
                break;
        }
    }
    
    public DefaultTableModel dataTabelMhs(){
        DefaultTableModel dtmMhs = new DefaultTableModel();
        Object[] kolom = {"index", "NPM", "Nama", "Jurusan"};
        dtmMhs.setColumnIdentifiers(kolom);
        int size = AllObjectModel.mahasiswa.getAllMahasiswa().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[4];
            data[0] = String.valueOf(i);
            data[1] = AllObjectModel.mahasiswa.getAllMahasiswa().get(i).getNpm();
            data[2] = AllObjectModel.mahasiswa.getAllMahasiswa().get(i).getNama();
            data[3] = DataJurusan.jurusan[AllObjectModel.mahasiswa.getAllMahasiswa().get(i).getIndex_jurusan()];
            dtmMhs.addRow(data);
        }
        return dtmMhs;
    }
}
