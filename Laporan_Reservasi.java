import java.util.List;

public class Laporan_Reservasi {
    private List<Reservasi> listReservasi;

    // Constructor
    public Laporan_Reservasi(List<Laporan_Reservasi> listReservasi) {
        this.listReservasi = listReservasi;
    }

    // Method untuk menghasilkan laporan berdasarkan periode tertentu
    public void generateLaporanPeriode(String periode) {
        System.out.println("Laporan Reservasi untuk Periode: " + periode);
        for (Laporan_Reservasi reservasi : listReservasi) {
            System.out.println("---------------------------------");
            System.out.println("Tanggal Check-In: " + reservasi.getTglCheckIn());
            System.out.println("Tanggal Check-Out: " + reservasi.getTglCheckOut());
            System.out.println("Total Bayar: " + reservasi.getTotalBayar());
            System.out.println("Status Reservasi: " + reservasi.getStatusReservasi());
        }
    }

    // Filter laporan dan menampilkan reservasi valid
    public void filterLaporan() {
        System.out.println("Laporan Reservasi Valid:");
        for (Laporan_Reservasi reservasi : listReservasi) {
            if (reservasi.validasiReservasi()) {
                System.out.println("---------------------------------");
                System.out.println("Tanggal Check-In: " + reservasi.getTglCheckIn());
                System.out.println("Tanggal Check-Out: " + reservasi.getTglCheckOut());
                System.out.println("Total Bayar: " + reservasi.getTotalBayar());
                System.out.println("Status Reservasi: " + reservasi.getStatusReservasi());
            }
        }
    }
}
