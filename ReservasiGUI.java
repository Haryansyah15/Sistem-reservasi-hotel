import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservasiGUI {
    private JFrame frame;
    private JTextField namaField, nikField, noHpField, alamatField, emailField;
    private JComboBox<String> tipeKamarBox;
    private JButton buatReservasiButton, lihatKamarButton, laporanButton, batalButton;

    public ReservasiGUI() {
        frame = new JFrame("Sistem Reservasi Hotel");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(9, 2));

        frame.add(new JLabel("Nama:"));
        namaField = new JTextField();
        frame.add(namaField);

        frame.add(new JLabel("NIK:"));
        nikField = new JTextField();
        frame.add(nikField);

        frame.add(new JLabel("No HP:"));
        noHpField = new JTextField();
        frame.add(noHpField);

        frame.add(new JLabel("Alamat:"));
        alamatField = new JTextField();
        frame.add(alamatField);

        frame.add(new JLabel("Email:"));
        emailField = new JTextField();
        frame.add(emailField);

        frame.add(new JLabel("Tipe Kamar:"));
        tipeKamarBox = new JComboBox<>(new String[]{"Standard", "Deluxe", "Suite"});
        frame.add(tipeKamarBox);

        buatReservasiButton = new JButton("Buat Reservasi");
        frame.add(buatReservasiButton);

        lihatKamarButton = new JButton("Lihat Kamar Tersedia");
        frame.add(lihatKamarButton);

        laporanButton = new JButton("Laporan Reservasi");
        frame.add(laporanButton);

        batalButton = new JButton("Batalkan Reservasi");
        frame.add(batalButton);

        frame.setVisible(true);

        // Event handling
        buatReservasiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = namaField.getText();
                String nik = nikField.getText();
                String noHp = noHpField.getText();
                String alamat = alamatField.getText();
                String email = emailField.getText();
                String tipeKamar = (String) tipeKamarBox.getSelectedItem();

                // Simulate creating a reservation
                String reservasi = "Nama: " + nama + ", NIK: " + nik + ", No HP: " + noHp + ", Alamat: " + alamat + ", Email: " + email + ", Tipe Kamar: " + tipeKamar;
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("reservasi_output.txt", true))) {
                    writer.write(reservasi);
                    writer.newLine();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Gagal menyimpan reservasi: " + ex.getMessage());
                }
                JOptionPane.showMessageDialog(frame, "Reservasi untuk " + nama + " berhasil dibuat!");
            }
        });

        lihatKamarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame kamarFrame = new JFrame("Kamar Tersedia");
                kamarFrame.setSize(300, 300);
                kamarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JTextArea kamarArea = new JTextArea();
                kamarArea.setEditable(false);
                kamarArea.setText("Daftar Kamar Tersedia:\n");

                // Simulasi data kamar yang tersedia
                kamarArea.append("Kamar 101 - Standard\n");
                kamarArea.append("Kamar 102 - Deluxe\n");
                kamarArea.append("Kamar 103 - Suite\n");
                kamarArea.append("Kamar 104 - Family Room\n");

                kamarFrame.add(new JScrollPane(kamarArea));
                kamarFrame.setVisible(true);
            }
        });

        laporanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame laporanFrame = new JFrame("Laporan Reservasi");
                laporanFrame.setSize(300, 300);
                laporanFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JTextArea laporanArea = new JTextArea();
                laporanArea.setEditable(false);
                laporanArea.setText("Laporan Reservasi:\n");

                // Membaca data dari file "reservasi_output.txt"
                try (BufferedReader reader = new BufferedReader(new FileReader("reservasi_output.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        laporanArea.append(line + "\n");
                    }
                } catch (IOException ex) {
                    laporanArea.append("Gagal membaca file reservasi.\n");
                }

                laporanFrame.add(new JScrollPane(laporanArea));
                laporanFrame.setVisible(true);
            }
        });

        batalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame batalFrame = new JFrame("Batalkan Reservasi");
                batalFrame.setSize(400, 200);
                batalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                batalFrame.setLayout(new GridLayout(2, 1));

                JTextField namaField = new JTextField();
                JButton batalkanButton = new JButton("Batalkan Reservasi");

                batalFrame.add(new JLabel("Masukkan Nama Pelanggan:"));
                batalFrame.add(namaField);
                batalFrame.add(batalkanButton);

                batalkanButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ev) {
                        String nama = namaField.getText();
                        if (nama != null && !nama.isEmpty()) {
                            // Logika pembatalan reservasi
                            try {
                                List<String> updatedData = new ArrayList<>();
                                try (BufferedReader reader = new BufferedReader(new FileReader("reservasi_output.txt"))) {
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        if (!line.contains("Nama: " + nama)) {
                                            updatedData.add(line);
                                        }
                                    }
                                }

                                try (BufferedWriter writer = new BufferedWriter(new FileWriter("reservasi_output.txt"))) {
                                    for (String reservasi : updatedData) {
                                        writer.write(reservasi + "\n");
                                    }
                                }
                                JOptionPane.showMessageDialog(batalFrame, "Reservasi untuk " + nama + " berhasil dibatalkan.");
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(batalFrame, "Terjadi kesalahan: " + ex.getMessage());
                            }
                        } else {
                            JOptionPane.showMessageDialog(batalFrame, "Nama tidak boleh kosong.");
                        }
                    }
                });

                batalFrame.setVisible(true);
            }
        });
    }


}