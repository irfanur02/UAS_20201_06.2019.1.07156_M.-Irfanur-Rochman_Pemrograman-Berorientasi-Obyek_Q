/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import DataMasuk.DataJurusan;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;


public class DaftarMahasiswa extends JFrame{
    JLabel labelNpm, labelNama, labelPassword, labelNotelp, labelTglLahir, labelJurusan, labelNamaMenu;
    JTextField textNpm, textNama, textNotelp, textTglLahir;
    JButton Daftar, Back;
    JPasswordField textPassword;
    JComboBox cbPilJurusan = new JComboBox(DataJurusan.jurusan);
    public DaftarMahasiswa() {
        setSize(1038, 737);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#99FFAF"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        labelNamaMenu = new JLabel("Pendaftaran Mahasiswa");
        labelNamaMenu.setBounds(300, 10, 600, 50);
        labelNamaMenu.setFont(new Font("AlGERIAN", Font.BOLD, 35));
        add(labelNamaMenu);
        
        labelNpm = new JLabel("NPM");
        labelNpm.setBounds(450, 80, 150, 30);
        add(labelNpm);
        
        textNpm = new JTextField();
        textNpm.setBounds(450, 110, 150, 30);
        add(textNpm);
        
        labelNama = new JLabel("Nama");
        labelNama.setBounds(450, 140, 150, 30);
        add(labelNama);
        
        textNama = new JTextField();
        textNama.setBounds(450, 170, 150, 30);
        add(textNama);
        
        labelTglLahir = new JLabel("Tanggal Lahir (dd/MM/yyy)");
        labelTglLahir.setBounds(450, 200, 150, 30);
        add(labelTglLahir);
        
        textTglLahir = new JTextField();
        textTglLahir.setBounds(450, 230, 150, 30);
        add(textTglLahir);
        
        labelNotelp = new JLabel("No Telepon");
        labelNotelp.setBounds(450, 260, 150, 30);
        add(labelNotelp);
        
        textNotelp = new JTextField();
        textNotelp.setBounds(450, 290, 150, 30);
        add(textNotelp);
        
        labelPassword = new JLabel("Password");
        labelPassword.setBounds(450, 320, 150, 30);
        add(labelPassword);
        
        textPassword = new JPasswordField();
        textPassword.setBounds(450, 350, 150, 30);
        add(textPassword);
        
        labelJurusan = new JLabel("Jurusan");
        labelJurusan.setBounds(450, 380, 150, 30);
        add(labelJurusan);
        
        cbPilJurusan.setBounds(450, 410, 150, 30);
        add(cbPilJurusan);
        
        Daftar = new JButton("Daftar");
        Daftar.setBounds(450, 460, 150, 30);
        Daftar.setBackground(Color.decode("#E8F923"));
        add(Daftar);
        
        Back = new JButton("Kembali");
        Back.setBounds(30, 650, 150, 30);
        Back.setBackground(Color.decode("#E8F923"));
        add(Back);
        
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                GUI menuUtama = new GUI();
            }
        });
        
        Daftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String npm = textNpm.getText();
                    String nama = textNama.getText();
                    Date tgllahir = new Date(textTglLahir.getText());
                    String notelp = textNotelp.getText();
                    String pass = textPassword.getText();
                    int indexJurusan = cbPilJurusan.getSelectedIndex();
                    Allobjctrl.mahasiswa.insertDataMahasiswa(npm, nama, tgllahir, indexJurusan, notelp, pass);
                    JOptionPane.showMessageDialog(null, "Registrasi Berhasil", "Information", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    GUI menuUtama = new GUI();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }
            }
        });
    }
    
    void kosong() {
        textNpm.setText(null);
        textNama.setText(null);
        textNotelp.setText(null);
        textTglLahir.setText(null);
        textPassword.setText(null);
        cbPilJurusan.setSelectedIndex(0);
    }
}