class Pelanggan extends Manusia{
    String alamat;
    String email;

    public Pelanggan(String nik, String nama, String no_hp, String alamat, String email) {
        super(nik, nama, no_hp);
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
    public void tampilkanInfo() {
        System.out.println("NIK: " + getNik());
        System.out.println("Nama: " + getNama());
        System.out.println("No HP: " + getNoHp());
        System.out.println("Alamat: " + getAlamat());
        System.out.println("Email: " + getEmail());
    }
}
