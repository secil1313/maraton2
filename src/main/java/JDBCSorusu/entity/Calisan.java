package JDBCSorusu.entity;

public class Calisan {
    private int id;
    private String calisanIsmi;
    private int yasi;
    private int maasi;
    private String departman;
    private String calistigiSirket;
    private Sirket sirket;

    public Calisan(int id) {
        this.id = id;
    }

    public Calisan(String calisanIsmi, int yasi, int maasi, String departman, String calistigiSirket, Sirket sirket) {
        this.calisanIsmi = calisanIsmi;
        this.yasi = yasi;
        this.maasi = maasi;
        this.departman = departman;
        this.calistigiSirket = calistigiSirket;
        this.sirket = sirket;
    }

    public Calisan(String calisanIsmi, int yasi, int maasi, String departman, String calistigiSirket) {
        this.calisanIsmi = calisanIsmi;
        this.yasi = yasi;
        this.maasi = maasi;
        this.departman = departman;
        this.calistigiSirket = calistigiSirket;
    }

    public Calisan(String calisanIsmi, int yasi, int maasi, String departman, String calistigiSirket,int id) {
        this.id = id;
        this.calisanIsmi = calisanIsmi;
        this.yasi = yasi;
        this.maasi = maasi;
        this.departman = departman;
        this.calistigiSirket = calistigiSirket;
    }

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalisanIsmi() {
        return calisanIsmi;
    }

    public void setCalisanIsmi(String calisanIsmi) {
        this.calisanIsmi = calisanIsmi;
    }

    public int getYasi() {
        return yasi;
    }

    public void setYasi(int yasi) {
        this.yasi = yasi;
    }

    public int getMaasi() {
        return maasi;
    }

    public void setMaasi(int maasi) {
        this.maasi = maasi;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public String getCalistigiSirket() {
        return calistigiSirket;
    }

    public void setCalistigiSirket(String calistigiSirket) {
        this.calistigiSirket = calistigiSirket;
    }

    @Override
    public String toString() {
        return "Calisan{" +
                "id=" + id +
                ", calisanIsmi='" + calisanIsmi + '\'' +
                ", yasi=" + yasi +
                ", maasi=" + maasi +
                ", departman='" + departman + '\'' +
                ", calistigiSirket='" + calistigiSirket + '\'' +
                ", sirket=" + sirket +
                '}';
    }
}
