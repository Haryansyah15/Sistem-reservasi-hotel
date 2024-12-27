import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public abstract class ReservasiGUI implements InterfaceReservasi {
    private ReservasiHotel sistemReservasi;
    private JFrame frame;
    private JTextField namaField;
    private JTextField alamatField;
    private JTextField emailField;
    private JComboBox<Kamar> kamarComboBox; // ComboBox for room selection
    private JButton buatReservasiButton;
    private JButton batalkanReservasiButton;
    private JButton lihatFasilitasButton; // Button to view room facilities

    public ReservasiGUI(ReservasiHotel sistemReservasi) {
        this.sistemReservasi = sistemReservasi;
        initialize();
    }

    private void initialize() {
        // Create the main frame
        frame = new JFrame("Reservasi Hotel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create a panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2)); // Update grid layout to accommodate room selection

        // Create labels and text fields
        inputPanel.add(new JLabel("Nama:"));
        namaField = new JTextField();
        inputPanel.add(namaField);

        inputPanel.add(new JLabel("Alamat:"));
        alamatField = new JTextField();
        inputPanel.add(alamatField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        // Create a label and combo box for selecting a room
        inputPanel.add(new JLabel("Pilih Kamar:"));
        kamarComboBox = new JComboBox<>(getKamarTersedia()); // Populate with available rooms
        inputPanel.add(kamarComboBox);

        // Create buttons
        buatReservasiButton = new JButton("Buat Reservasi");
        batalkanReservasiButton = new JButton("Batalkan Reservasi");
        lihatFasilitasButton = new JButton("Lihat Fasilitas Kamar"); // Button to view room facilities

        // Add action listeners to buttons
        buatReservasiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = namaField.getText().trim();
                String alamat = alamatField.getText().trim();
                String email = emailField.getText().trim();
                Kamar kamarDipilih = (Kamar) kamarComboBox.getSelectedItem(); // Get selected room

                if (!nama.isEmpty() && !alamat.isEmpty() && !email.isEmpty() && kamarDipilih != null) {
                    Reservasi reservasi = buatReservasi(nama, alamat, email, kamarDipilih);
                    if (reservasi != null) {
                        // Write reservation details to a text file
                        writeReservationToFile(reservasi);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Silakan isi semua field.");
                }
            }
        });

        batalkanReservasiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = JOptionPane.showInputDialog(frame, "Masukkan nama untuk membatalkan reservasi:");
                if (nama != null && !nama.trim().isEmpty()) {
                    batalkanReservasi(nama.trim());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nama tidak boleh kosong.");
                }
            }
        });

        lihatFasilitasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kamar kamarDipilih = (Kamar) kamarComboBox.getSelectedItem(); // Get selected room
                if (kamarDipilih != null) {
                    String tipeKamar = kamarDipilih.tipeKamar; // Get room type
                    Tipe_Kamar tipe = null;
                    for (Tipe_Kamar t : Tipe_Kamar.generateTipeKamar()) {
                        if (t.getNamaTipe().equalsIgnoreCase(tipeKamar)) {
                            tipe = t;
                            break;
                        }
                    }
                    if (tipe != null) {
                        JOptionPane.showMessageDialog(frame, "Fasilitas untuk " + tipeKamar + ":\n" + tipe.getFasilitasString());
                    } else {
                        JOptionPane.showMessageDialog(frame, "Fasilitas untuk tipe kamar ini tidak ditemukan.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Silakan pilih kamar terlebih dahulu.");
                }
            }
        });

        // Add components to the frame
        frame.add(inputPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buatReservasiButton);
        buttonPanel.add(batalkanReservasiButton);
        buttonPanel.add(lihatFasilitasButton); // Add the facilities button to the panel
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Set frame visibility
        frame.setVisible(true);
    }

    private Kamar[] getKamarTersedia() {
        List<Kamar> kamarList = sistemReservasi.getDaftarKamarTersedia(); // Method to get available rooms
        return kamarList.toArray(new Kamar[0]); // Convert list to array
    }

    @Override
    public Reservasi buatReservasi(String nama, String alamat, String email, Kamar kamar) {
        sistemReservasi.buatReservasi(nama, alamat, email, kamar);
        JOptionPane.showMessageDialog(frame, "Reservasi berhasil dibuat untuk " + nama);
        return new Reservasi(new Pelanggan("123", nama, "0123", alamat, email), kamar, LocalDate.now(), LocalDate.now().plusDays(1)); // Example check-in and check-out
    }

    @Override
    public void batalkanReservasi(String nama) {
        sistemReservasi.batalkanReservasi(nama);
    }

    private void writeReservationToFile(Reservasi reservasi) {
        String fileName = "reservasi.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(reservasi.getDetails());
            writer.write("====================================\n");
            JOptionPane.showMessageDialog(frame, "Detail reservasi telah disimpan ke " + fileName);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saat menyimpan detail reservasi: " + e.getMessage());
        }
    }
}
