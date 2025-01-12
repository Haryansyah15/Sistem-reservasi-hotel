import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IReservasi implements InterfaceReservasi {
    private List<Pelanggan> pelangganList;
    private List<Kamar> kamarList;
    private List<String> laporanReservasi;

    public IReservasi() {
        pelangganList = new ArrayList<>();
        kamarList = new ArrayList<>();
        laporanReservasi = new ArrayList<>();
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        pelangganList.add(pelanggan);
    }

    public void tambahKamar(Kamar kamar) {
        kamarList.add(kamar);
    }

    @Override
    public void buatReservasi(Pelanggan pelanggan, Kamar kamar, LocalDate tglCekin, LocalDate tglCekout) {
        if (kamar.getStatus().equalsIgnoreCase("tersedia")) {
            kamar.setStatus("dipesan");
            String reservasi = "Pelanggan: " + pelanggan.getNama() + ", Kamar: " + kamar.getNokamar() + ", Check-in: " + tglCekin + ", Check-out: " + tglCekout;
            laporanReservasi.add(reservasi);

            try (FileWriter writer = new FileWriter("reservasi.txt", true)) {
                writer.write(reservasi + "\n");
            } catch (IOException e) {
                System.out.println("Terjadi kesalahan saat menulis file: " + e.getMessage());
            }

            System.out.println("Reservasi berhasil dibuat!");
        } else {
            System.out.println("Kamar tidak tersedia.");
        }
    }

    @Override
    public void batalkanReservasi(String namaPelanggan) {
        laporanReservasi.removeIf(reservasi -> reservasi.contains("Pelanggan: " + namaPelanggan));

        try (FileWriter writer = new FileWriter("reservasi.txt")) {
            for (String reservasi : laporanReservasi) {
                writer.write(reservasi + "\n");
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis file: " + e.getMessage());
        }

        System.out.println("Reservasi untuk " + namaPelanggan + " telah dibatalkan.");
    }

    @Override
    public void tampilkanKamarTersedia() {
        for (Kamar kamar : kamarList) {
            if (kamar.getStatus().equalsIgnoreCase("tersedia")) {
                System.out.println("Kamar: " + kamar.getNokamar() + ", Tipe: " + kamar.getTipeKamar().getNamatipekamar());
            }
        }
    }

    @Override
    public void tampilkanLaporanReservasi() {
        for (String reservasi : laporanReservasi) {
            System.out.println(reservasi);
        }
    }
}