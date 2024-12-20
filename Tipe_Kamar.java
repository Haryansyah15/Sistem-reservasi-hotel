import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tipe_Kamar {
    private String namaTipe;
    private List<String> fasilitas;
    private int kapasitas;

    // Constructor
    public Tipe_Kamar(String namaTipe, List<String> fasilitas, int kapasitas) {
        this.namaTipe = namaTipe;
        this.fasilitas = fasilitas;
        this.kapasitas = kapasitas;
    }

    // Getter dan Setter
    public String getNamaTipe() {
        return namaTipe;
    }

    public void setNamaTipe(String namaTipe) {
        this.namaTipe = namaTipe;
    }

    public List<String> getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(List<String> fasilitas) {
        this.fasilitas = fasilitas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    // Method untuk mendapatkan fasilitas sebagai String
    public String getFasilitasString() {
        return String.join(", ", fasilitas);
    }

    // Menampilkan informasi tipe kamar
    public void displayInfoTipeKamar() {
        System.out.println("Tipe Kamar: " + namaTipe);
        System.out.println("Kapasitas: " + kapasitas + " orang");
        System.out.println("Fasilitas: " + getFasilitasString());
    }

    // Static method untuk membuat daftar tipe kamar beserta fasilitasnya
    public static List<Tipe_Kamar> generateTipeKamar() {
        List<Tipe_Kamar> daftarTipeKamar = new ArrayList<>();

        daftarTipeKamar.add(new Tipe_Kamar(
                "Deluxe",
                Arrays.asList("AC", "WiFi", "TV LED", "Mini Bar", "Breakfast"),
                2
        ));

        daftarTipeKamar.add(new Tipe_Kamar(
                "Suite",
                Arrays.asList("AC", "WiFi", "TV LED", "Mini Bar", "Breakfast", "Jacuzzi", "Living Room"),
                4
        ));

        daftarTipeKamar.add(new Tipe_Kamar(
                "Standard",
                Arrays.asList("AC", "WiFi", "TV LED"),
                2
        ));

        daftarTipeKamar.add(new Tipe_Kamar(
                "Family Room",
                Arrays.asList("AC", "WiFi", "TV LED", "Kitchenette", "Breakfast"),
                6
        ));

        return daftarTipeKamar;
    }

    public static void main(String[] args) {
        // Generate daftar tipe kamar
        List<Tipe_Kamar> tipeKamars = Tipe_Kamar.generateTipeKamar();

        // Menampilkan informasi semua tipe kamar
        for (Tipe_Kamar tipeKamar : tipeKamars) {
            tipeKamar.displayInfoTipeKamar();
            System.out.println("-----------------------------");
        }
    }
}
