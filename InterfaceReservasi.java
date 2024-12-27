interface InterfaceReservasi {
    Reservasi buatReservasi(String nama, String alamat, String email, Kamar kamar);

    void buatReservasi();
    void batalkanReservasi(String nama);
}