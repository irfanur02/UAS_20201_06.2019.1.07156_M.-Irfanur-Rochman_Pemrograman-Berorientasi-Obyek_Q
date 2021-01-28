/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.MahasiswaController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;



public class GUI extends JFrame{

    MahasiswaController mahasiswa = new MahasiswaController();
    JButton DaftarMhs, HapusMhs, EditMhs;
    JTextField textUbahData;
    JLabel labelNamaAplikasi, labelUbahData;
    JTable tabelMhs = new JTable();
    JScrollPane scrollTabelMhs = new JScrollPane(tabelMhs);

    public GUI() {
        setSize(800, 380);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#7CF51D"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        labelNamaAplikasi = new JLabel("Aplikasi Pendataan Mahasiswa");
        labelNamaAplikasi.setBounds(40, 15, 1000, 50);
        labelNamaAplikasi.setFont(new Font("AlGERIAN", Font.BOLD, 36));
        add(labelNamaAplikasi);
        
        DaftarMhs = new JButton("Daftar Mahasiswa");
        DaftarMhs.setBounds(30, 70, 140, 30);
        DaftarMhs.setBackground(Color.decode("#E8F923"));
        add(DaftarMhs);

        scrollTabelMhs.setBounds(30, 110, 570, 200);
        tabelMhs.setModel(mahasiswa.dataTabelMhs());
        add(scrollTabelMhs);

        labelUbahData = new JLabel("Ubah Data Mahasiswa");
        labelUbahData.setBounds(620, 105, 130, 30);
        add(labelUbahData);

        textUbahData = new JTextField("Index");
        textUbahData.setBounds(620, 135, 100, 30);
        add(textUbahData);

        EditMhs = new JButton("Edit");
        EditMhs.setBounds(620, 175, 55, 30);
        EditMhs.setBackground(Color.decode("#E8F923"));
        add(EditMhs);

        HapusMhs = new JButton("Hapus");
        HapusMhs.setBounds(685, 175, 70, 30);
        HapusMhs.setBackground(Color.decode("#E8F923"));
        add(HapusMhs);
        
        DaftarMhs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                DaftarMahasiswa daftarMahasiswa = new DaftarMahasiswa();
            }
        });

        textUbahData.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textUbahData.setText(null);
            }

            @Override
            public void focusLost(FocusEvent fe) {
            }
        });

        EditMhs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (Allobjctrl.mahasiswa.getDataMahasiswa().size() == 0) {
                    JOptionPane.showMessageDialog(null, "Data Masih Kosong", "Information",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        if (!"Index".equals(textUbahData.getText()) && !"".equals(textUbahData.getText())) {
                            int index_mhs = Integer.parseInt(textUbahData.getText());
                            Allobjctrl.mahasiswa.getDataMahasiswa(index_mhs);
                            dispose();
                            UpdateMahasiswa updateMahasiswa = new UpdateMahasiswa(index_mhs);
                        } else {
                            JOptionPane.showMessageDialog(null, "Pilih Data Mahasiswa\n\tatau\nMasukkan Index Data Mahasiswa",
                                    "Information", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Data tidak Ada",
                                "Information", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        GUI menuUtama = new GUI();
                    }
                }
            }
        });

        HapusMhs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (Allobjctrl.mahasiswa.getDataMahasiswa().size() == 0) {
                    JOptionPane.showMessageDialog(null, "Data Masih Kosong", "Information",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        if (!"Index".equals(textUbahData.getText()) && !"".equals(textUbahData.getText())) {
                            int index_mhs = Integer.parseInt(textUbahData.getText());
                            Allobjctrl.mahasiswa.getDataMahasiswa(index_mhs);
                            int result = JOptionPane.showConfirmDialog(null, "apakah anda yakin untuk menghapus ?",
                                    "Swing Tester",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE);
                            if (result == JOptionPane.YES_OPTION) {
                                Allobjctrl.mahasiswa.deleteDataMahasiswa(index_mhs);
                                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Information",
                                        JOptionPane.INFORMATION_MESSAGE);
                                tabelMhs.setModel(Allobjctrl.mahasiswa.dataTabelMhs());
                                textUbahData.setText("Index");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Pilih Data Mahasiswa\n\tatau\nMasukkan Index Data Mahasiswa",
                                    "Information", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Data tidak Ada",
                                "Information", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        GUI menuUtama = new GUI();
                    }
                }

            }
        });

        tabelMhs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelMhs.getSelectedRow();
                textUbahData.setText(Allobjctrl.mahasiswa.dataTabelMhs().getValueAt(i, 0).toString());
            }
        });
    }
}
