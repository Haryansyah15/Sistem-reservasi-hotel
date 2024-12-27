import java.time.LocalDate;

class Reservasi {
    Pelanggan pelanggan;
    Kamar kamar;
    LocalDate tanggalCheckin;
    LocalDate tanggalCheckout;
    double totalBiaya;
    String statusReservasi;

    public Reservasi(Pelanggan pelanggan, Kamar kamar, LocalDate tanggalCheckin, LocalDate tanggalCheckout) {
        this.pelanggan = pelanggan;
        this.kamar = kamar;
        this.tanggalCheckin = tanggalCheckin;
        this.tanggalCheckout = tanggalCheckout;
        this.statusReservasi = "Dipesan";
        hitungBiaya();
    }

    public void hitungBiaya() {
        long lamaMenginap = tanggalCheckout.toEpochDay() - tanggalCheckin.toEpochDay();
        totalBiaya = lamaMenginap * kamar.hargaPerMalam;
    }

    public boolean validasiReservasi() {
        return !tanggalCheckin.isAfter(tanggalCheckout);
    }


    public String getDetails() {
        return "Nama: " + pelanggan.getNama() + "\n" +
                "Alamat: " + pelanggan.alamat + "\n" +
                "Email: " + pelanggan.email + "\n" +
                "Kamar: " + kamar.tipeKamar + "\n" +
                "Tanggal Check-in: " + tanggalCheckin + "\n" +
                "Tanggal Check-out: " + tanggalCheckout + "\n" +
                "Total Biaya: " + totalBiaya + "\n" +
                "Status: " + statusReservasi + "\n";
    }
}
