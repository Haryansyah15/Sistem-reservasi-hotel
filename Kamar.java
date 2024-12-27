class Kamar {
    public int nomorKamar;
    public String tipeKamar;
    public double hargaPerMalam;
    public String status;
    public String getFasilitas;

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

    public String getTipeKamar() {
        return tipeKamar; // Return the type of the room
    }

    @Override
    public String toString() {
        return tipeKamar + " (Kamar " + nomorKamar + ")"; // Display room type and number
    }
}
