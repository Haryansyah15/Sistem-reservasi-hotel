import java.util.ArrayList; import java.util.List;

class ReservasiHotel {
    List<Kamar> daftarKamar = new ArrayList<>();
    List<Pelanggan> daftarPelanggan = new ArrayList<>();
    List<Reservasi> daftarReservasi = new ArrayList<>();
    public void tambahKamar(Kamar kamar) {
        daftarKamar.add(kamar);
    }
    public Kamar cariKamar(int nomorKamar) {
        for (Kamar kamar : daftarKamar) {
            if (kamar.nomorKamar == nomorKamar) {
                return kamar;
            }
        }
        return null;
    }
    public void batalkanReservasi(Reservasi reservasi) {
        reservasi.statusReservasi = "Dibatalkan";
    }
}