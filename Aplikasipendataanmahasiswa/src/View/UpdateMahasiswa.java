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
import java.text.SimpleDateFormat;
import javax.swing.*;


public class UpdateMahasiswa extends JFrame {
    JLabel labelNpm, labelNama, labelPassword, labelNotelp, labelTglLahir, labelJurusan, labelNamaMenu;
    JTextField textNpm, textNama, textNotelp, textTglLahir;
    JButton Update, Back, EditNpm, EditNama, EditTglLahir, EditNotelp, EditPassword, EditJurusan;
    JPasswordField textPassword;
    JComboBox cbPilJurusan = new JComboBox(DataJurusan.jurusan);

    public UpdateMahasiswa(int index_mhs) {
        setSize(1038, 737);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#A9FC82"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        labelNamaMenu = new JLabel("Edit Data Mahasiswa");
        labelNamaMenu.setBounds(300, 10, 600, 50);
        labelNamaMenu.setFont(new Font("ALGERIAN", Font.BOLD, 35));
        add(labelNamaMenu);

        labelNpm = new JLabel("NPM");
        labelNpm.setBounds(400, 80, 150, 30);
        add(labelNpm);

        textNpm = new JTextField();
        textNpm.setBounds(400, 110, 150, 30);
        add(textNpm);

        EditNpm = new JButton("Edit");
        EditNpm.setBounds(560, 110, 55, 30);
        EditNpm.setBackground(Color.decode("#E5E5E5"));
        add(EditNpm);

        labelNama = new JLabel("Nama");
        labelNama.setBounds(400, 140, 150, 30);
        add(labelNama);

        textNama = new JTextField();
        textNama.setBounds(400, 170, 150, 30);
        add(textNama);

        EditNama = new JButton("Edit");
        EditNama.setBounds(560, 170, 55, 30);
        EditNama.setBackground(Color.decode("#E5E5E5"));
        add(EditNama);

        labelTglLahir = new JLabel("Tanggal Lahir (dd/MM/yyy)");
        labelTglLahir.setBounds(400, 200, 150, 30);
        add(labelTglLahir);

        textTglLahir = new JTextField();
        textTglLahir.setBounds(400, 230, 150, 30);
        add(textTglLahir);

        EditTglLahir = new JButton("Edit");
        EditTglLahir.setBounds(560, 230, 55, 30);
        EditTglLahir.setBackground(Color.decode("#E5E5E5"));
        add(EditTglLahir);

        labelNotelp = new JLabel("No Telepon");
        labelNotelp.setBounds(400, 260, 150, 30);
        add(labelNotelp);

        textNotelp = new JTextField();
        textNotelp.setBounds(400, 290, 150, 30);
        add(textNotelp);

        EditNotelp = new JButton("Edit");
        EditNotelp.setBounds(560, 290, 55, 30);
        EditNotelp.setBackground(Color.decode("#E5E5E5"));
        add(EditNotelp);

        labelPassword = new JLabel("Password");
        labelPassword.setBounds(400, 320, 150, 30);
        add(labelPassword);

        textPassword = new JPasswordField();
        textPassword.setBounds(400, 350, 150, 30);
        add(textPassword);

        EditPassword = new JButton("Edit");
        EditPassword.setBounds(560, 350, 55, 30);
        EditPassword.setBackground(Color.decode("#E5E5E5"));
        add(EditPassword);

        labelJurusan = new JLabel("Jurusan");
        labelJurusan.setBounds(400, 380, 150, 30);
        add(labelJurusan);

        cbPilJurusan.setBounds(400, 410, 150, 30);
        add(cbPilJurusan);

        EditJurusan = new JButton("Edit");
        EditJurusan.setBounds(560, 410, 55, 30);
        EditJurusan.setBackground(Color.decode("#E5E5E5"));
        add(EditJurusan);

        Update = new JButton("Update");
        Update.setBounds(450, 460, 100, 30);
        Update.setBackground(Color.decode("#E8F923"));
        add(Update);
        
        Back = new JButton("Kembali");
        Back.setBounds(30, 650, 150, 30);
        Back.setBackground(Color.decode("#E8F923"));
        add(Back);

        textNpm.setEnabled(false);
        textNama.setEnabled(false);
        textTglLahir.setEnabled(false);
        textNotelp.setEnabled(false);
        textPassword.setEnabled(false);
        cbPilJurusan.setEnabled(false);

        textNpm.setText(Allobjctrl.mahasiswa.getDataMahasiswa(index_mhs).getNpm());
        textNama.setText(Allobjctrl.mahasiswa.getDataMahasiswa(index_mhs).getNama());
        textTglLahir.setText(new SimpleDateFormat("dd/MM/yyy").format(Allobjctrl.mahasiswa.getDataMahasiswa(index_mhs).getTglLahir()));
        textNotelp.setText(Allobjctrl.mahasiswa.getDataMahasiswa(index_mhs).getNo_telp());
        textPassword.setText(Allobjctrl.mahasiswa.getDataMahasiswa(index_mhs).getPassword());
        cbPilJurusan.setSelectedIndex(Allobjctrl.mahasiswa.getDataMahasiswa(index_mhs).getIndex_jurusan());

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                GUI menuUtama = new GUI();
            }
        });
        
       EditNpm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textNpm.setEnabled(true);
            }
        });

        EditNama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textNama.setEnabled(true);
            }
        });

        EditTglLahir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textTglLahir.setEnabled(true);
            }
        });
        
       EditPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textPassword.setEnabled(true);
            }
        });
        
        EditJurusan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cbPilJurusan.setEnabled(true);
            }
        });

        EditNotelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textNotelp.setEnabled(true);
            }
        });
        
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if(textNpm.isEnabled()) {
                        Allobjctrl.mahasiswa.updateDataMahasiswa(index_mhs, textNpm.getText(), "npm", "string");
                    }
                    if(textNama.isEnabled()) {
                        Allobjctrl.mahasiswa.updateDataMahasiswa(index_mhs, textNama.getText(), "nama", "string");
                    }
                    if(textNotelp.isEnabled()) {
                        Allobjctrl.mahasiswa.updateDataMahasiswa(index_mhs, textNotelp.getText(), "notelp", "string");
                    }
                    if(textPassword.isEnabled()) {
                        Allobjctrl.mahasiswa.updateDataMahasiswa(index_mhs, textPassword.getText(), "password", "string");
                    }
                    if(textTglLahir.isEnabled()) {
                        Allobjctrl.mahasiswa.updateDataMahasiswa(index_mhs, textTglLahir.getText(), "tgllahir", "date");
                    }
                    if(cbPilJurusan.isEnabled()) {
                        Allobjctrl.mahasiswa.updateDataMahasiswa(index_mhs, String.valueOf(cbPilJurusan.getSelectedIndex()), "jurusan", "int");
                    }
                    JOptionPane.showMessageDialog(null, "Update Berhasil", "Information", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    GUI menuUtama = new GUI();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
