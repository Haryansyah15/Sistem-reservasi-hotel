public class Main {
    public static void main(String[] args) {
        ReservasiHotel reservasiHotel = new ReservasiHotel();

        // Add some rooms to the hotel for testing
        reservasiHotel.tambahKamar(new Kamar(101, "Deluxe", 200000));
        reservasiHotel.tambahKamar(new Kamar(102, "Suite", 350000));
        reservasiHotel.tambahKamar(new Kamar(103, "Standart", 500000));
        reservasiHotel.tambahKamar(new Kamar(104, "Family Room", 850000));

        // Create the GUI
        new ReservasiGUI(reservasiHotel) {
            @Override
            public void buatReservasi() {

            }

            @Override
            public void batalkanReservasi(String nama) {

            }
        };
    }
}