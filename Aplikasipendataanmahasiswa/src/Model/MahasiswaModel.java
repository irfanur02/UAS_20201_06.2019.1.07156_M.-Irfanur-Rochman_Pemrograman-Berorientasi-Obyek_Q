/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DataMasuk.DataJurusan;
import DataMasuk.DataMahasiswa;
import java.util.ArrayList;
import java.util.Date;


public class MahasiswaModel{
    private ArrayList<DataMahasiswa> mahasiswaEntityArrayList;
    
    public MahasiswaModel() {
        mahasiswaEntityArrayList = new ArrayList<DataMahasiswa>();
    }
    
    public DataMahasiswa getProfileMahasiswa(int index) {
        return mahasiswaEntityArrayList.get(index);
    }
    
    public ArrayList<DataMahasiswa> getAllMahasiswa() {
        return mahasiswaEntityArrayList;
    }
    
    public int cekMahasiswa(String npm, String password) {
        int loop = 0;
        if (mahasiswaEntityArrayList.size() == 0) {
            loop = -1; // data kosong
        } else {
            for (int i = 0; i < mahasiswaEntityArrayList.size(); i++) {
                if (mahasiswaEntityArrayList.get(i).getNpm().equals(npm) &&
                        mahasiswaEntityArrayList.get(i).getPassword().equals(password)) {
                    loop = i;
                    break;
                } else if(!mahasiswaEntityArrayList.get(i).getNpm().equals(npm) &&
                            !mahasiswaEntityArrayList.get(i).getPassword().equals(password) &&
                                i < mahasiswaEntityArrayList.size()-1) {
                    continue;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }
    
    public void insertMahasiswaModel(DataMahasiswa mahasiswa) {
        mahasiswaEntityArrayList.add(mahasiswa);
    }
    
    public void editNpmMahasiswaModel(int index, String data) {
        mahasiswaEntityArrayList.get(index).setNpm(data);
    }
    
    public void editNamaMahasiswaModel(int index, String data) {
        mahasiswaEntityArrayList.get(index).setNama(data);
    }
    
    public void editNoTelpMahasiswaModel(int index, String data) {
        mahasiswaEntityArrayList.get(index).setNo_telp(data);
    }
    
    public void editPasswordMahasiswaModel(int index, String data) {
        mahasiswaEntityArrayList.get(index).setPassword(data);
    }
    
    public void editMahasiswaModel(int index, Date data) {
        mahasiswaEntityArrayList.get(index).setTglLahir(data);
    }
    
    public void editMahasiswaModel(int index, int data) {
        mahasiswaEntityArrayList.get(index).setIndex_jurusan(data);
    }
    
    public void hapusMahasiswaModel(int index) {
        mahasiswaEntityArrayList.remove(mahasiswaEntityArrayList.get(index));
    }
}
