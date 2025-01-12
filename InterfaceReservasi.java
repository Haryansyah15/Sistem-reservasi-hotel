import java.time.LocalDate;

public interface InterfaceReservasi {
    void buatReservasi(Pelanggan pelanggan, Kamar kamar, LocalDate tglCekin, LocalDate tglCekout);
    void batalkanReservasi(String namaPelanggan);
    void tampilkanKamarTersedia();
    void tampilkanLaporanReservasi();
}