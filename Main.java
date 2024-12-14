import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static LocalDate validDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd")); } catch (DateTimeParseException e) {
            return null;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservasiHotel hotel = new ReservasiHotel();
        // Menambahkan beberapa kamar hotel.
        tambahKamar(new Kamar(101, "Single", 500000));
        hotel.tambahKamar(new Kamar(102, "Double", 700000));
        hotel.tambahKamar(new Kamar(103, "Suite", 1500000));
        // Input data pelanggan
        System.out.print("Masukkan nama pelanggan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan alamat pelanggan: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan email pelanggan: ");
        String email = scanner.nextLine();
        Pelanggan pelanggan = new Pelanggan(nama, alamat, email);
        // Input data reservasi
        LocalDate checkinDate = null; while (checkinDate == null) {
            System.out.print("Masukkan tanggal check-in (YYYY-MM-DD): ");
            checkinDate = validDate(scanner.nextLine());
            if (checkinDate == null) {
                System.out.println("Format tanggal tidak valid. Coba lagi.");
            }
        }
        LocalDate checkoutDate = null;
        while (checkoutDate == null || !checkoutDate.isAfter(checkinDate)) {
            System.out.print("Masukkan tanggal check-out (YYYY-MM-DD): ");
            checkoutDate = validDate(scanner.nextLine());
            if (checkoutDate == null) {
                System.out.println("Format tanggal tidak valid. Coba lagi.");
            } else if (!checkoutDate.isAfter(checkinDate)) {
                System.out.println("Tanggal check-out harus setelah tanggal check-in. Coba lagi.");
            }
        }
        System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
        int nomorKamar = scanner.nextInt();
        Kamar kamar = hotel.cariKamar(nomorKamar);
        if (kamar != null && kamar.cekKetersediaan()) {
            Reservasi reservasi = new Reservasi(pelanggan, kamar, checkinDate, checkoutDate);
            if (reservasi.validasiReservasi()) {
                kamar.updateStatus("Dipesan");
                hotel.daftarReservasi.add(reservasi);
                System.out.println("Reservasi berhasil. Total biaya: " + reservasi.totalBiaya);
            } else {
                System.out.println("Tanggal reservasi tidak valid.");
            }
        } else { System.out.println("Kamar tidak tersedia.");
        }
        scanner.close();
    }
}