class Karyawan extends Manusia {
    private double gaji;
    private String posisi;

    public Karyawan(String nik, String nama, String no_hp, double gaji, String posisi) {
        super(nik, nama, no_hp);
        this.gaji = gaji;
        this.posisi = posisi;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("NIK: " + getNik());
        System.out.println("Nama: " + getNama());
        System.out.println("No HP: " + getNoHp());
        System.out.println("Gaji: " + getGaji());
        System.out.println("Posisi: " + getPosisi());
    }
}
