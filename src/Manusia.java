public abstract class Manusia {
    private String nik;
    private String nama;
    private String no_hp;

    public Manusia(String nik, String nama, String no_hp) {
        this.nik = nik;
        this.nama = nama;
        this.no_hp = no_hp;
    }


    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return no_hp;
    }

    public void setNoHp(String no_hp) {
        this.no_hp = no_hp;
    }


    public abstract void tampilkanInfo();
}