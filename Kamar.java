public class Kamar {
    private String nokamar;
    private TipeKamar tipeKamar;
    private String status;

    public Kamar(String nokamar, TipeKamar tipeKamar, String status) {
        this.nokamar = nokamar;
        this.tipeKamar = tipeKamar;
        this.status = status;
    }

    public Kamar (String nokamar, String status){
        this.nokamar = nokamar;
        this.status = status;
    }

    public String getNokamar() {
        return nokamar;
    }

    public void setNokamar(String nokamar) {
        this.nokamar = nokamar;
    }

    public TipeKamar getTipeKamar() {
        return tipeKamar;
    }

    public void setTipeKamar(TipeKamar tipeKamar) {
        this.tipeKamar = tipeKamar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
