class Kamar {
    int nomorKamar;
    String tipeKamar;
    double hargaPerMalam;
    String status;
    public Kamar(int nomorKamar, String tipeKamar, double hargaPerMalam) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.hargaPerMalam = hargaPerMalam;
        this.status = "Tersedia";
    }
    public boolean cekKetersediaan() {
        return status.equals("Tersedia");
    }
    public void updateStatus(String statusBaru) {
        status = statusBaru;
    }
}