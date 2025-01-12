public class Pelanggan extends Manusia{
    private String alamat;
    private String email;

    public Pelanggan(String nik, String nama, String nohp, String alamat, String email) {
        super(nik, nama, nohp);
        this.alamat = alamat;
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void DisplayInfo() {
        System.out.println("Nama: " + getNama());
        System.out.println("Alamat: " + getAlamat());
        System.out.println("Email: " + getEmail());

    }
}
