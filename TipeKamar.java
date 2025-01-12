public class TipeKamar {
    private String namatipekamar;
    private String fasilitas;
    private String Harga;
    private Kamar kamar;

    public TipeKamar(String namatipekamar, String fasilitas, String harga, Kamar kamar) {
        this.namatipekamar = namatipekamar;
        this.fasilitas = fasilitas;
        Harga = harga;
        this.kamar = kamar;
    }

    public TipeKamar(String namatipekamar, String fasilitas, String Harga){
        this.namatipekamar = namatipekamar;
        this.Harga = Harga;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getNamatipekamar() {
        return namatipekamar;
    }

    public void setNamatipekamar(String namatipekamar) {
        this.namatipekamar = namatipekamar;
    }

    public void DisplayFasilitas() {
        System.out.println("Tipe Kamar: " + getNamatipekamar()+" Fasilitas: " + getFasilitas()+" Harga: " + getHarga());
    }
}
