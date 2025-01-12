public class Karyawan extends Manusia{
    private String posisi;
    private String gaji;

    public Karyawan(String nik, String nama, String nohp, String posisi, String gaji) {
        super(nik, nama, nohp);
        this.posisi = posisi;
        this.gaji = gaji;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    @Override
    public void DisplayInfo() {
        System.out.println("Nama: " + getNama());
        System.out.println("Posisi: " + getPosisi());
        System.out.println("Gaji: " + getGaji());
    }
}
