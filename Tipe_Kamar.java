import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Tipe_Kamar {
    private String namaTipe;
    private static List<String> fasilitas;
    private int kapasitas;

    public Tipe_Kamar(String namaTipe, List<String> fasilitas, int kapasitas) {
        this.namaTipe = namaTipe;
        this.fasilitas = fasilitas;
        this.kapasitas = kapasitas;
    }

    public String getNamaTipe() {
        return namaTipe;
    }

    public List<String> getFasilitas() {
        return fasilitas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public static String getFasilitasString() {
        return String.join(", ", fasilitas);
    }

    public void displayInfoTipeKamar() {
        System.out.println("Tipe Kamar: " + namaTipe);
        System.out.println("Kapasitas: " + kapasitas + " orang");
        System.out.println("Fasilitas: " + getFasilitasString());
    }

    public static List<Tipe_Kamar> generateTipeKamar() {
        List<Tipe_Kamar> daftarTipeKamar = new ArrayList<>();

        daftarTipeKamar.add(new Tipe_Kamar("Deluxe", Arrays.asList("AC", "WiFi", "TV LED", "Mini Bar", "Breakfast"), 2));
        daftarTipeKamar.add(new Tipe_Kamar("Suite", Arrays.asList("AC", "WiFi", "TV LED", "Mini Bar", "Breakfast", "Jacuzzi", "Living Room"), 4));
        daftarTipeKamar.add(new Tipe_Kamar("Standard", Arrays.asList("AC", "WiFi", "TV LED"), 2));
        daftarTipeKamar.add(new Tipe_Kamar("Family Room", Arrays.asList("AC", "WiFi", "TV LED", "Kitchenette", "Breakfast"), 6));

        return daftarTipeKamar;
    }
}
