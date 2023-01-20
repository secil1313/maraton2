package JDBCSorusu.entity;

public class Sirket {
    private int id;
    private String sirketadi;
    private String sirketSahibi;
    private String unvani;
    private String faaliyetAlani;
    private int kurulusYili;
private Calisan calisan;

    public Sirket(String sirketSahibi, String unvani, String faaliyetAlani, int kurulusYili) {
        this.sirketSahibi = sirketSahibi;
        this.unvani = unvani;
        this.faaliyetAlani = faaliyetAlani;
        this.kurulusYili = kurulusYili;

    }

    public Sirket(String sirketadi, String sirketSahibi, String unvani, String faaliyetAlani, int kurulusYili, Calisan calisan) {
        this.sirketadi = sirketadi;
        this.sirketSahibi = sirketSahibi;
        this.unvani = unvani;
        this.faaliyetAlani = faaliyetAlani;
        this.kurulusYili = kurulusYili;
        this.calisan = calisan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSirketadi() {
        return sirketadi;
    }

    public void setSirketadi(String sirketadi) {
        this.sirketadi = sirketadi;
    }

    public String getSirketSahibi() {
        return sirketSahibi;
    }

    public void setSirketSahibi(String sirketSahibi) {
        this.sirketSahibi = sirketSahibi;
    }

    public String getUnvani() {
        return unvani;
    }

    public void setUnvani(String unvani) {
        this.unvani = unvani;
    }

    public String getFaaliyetAlani() {
        return faaliyetAlani;
    }

    public void setFaaliyetAlani(String faaliyetAlani) {
        this.faaliyetAlani = faaliyetAlani;
    }

    public int getKurulusYili() {
        return kurulusYili;
    }

    public void setKurulusYili(int kurulusYili) {
        this.kurulusYili = kurulusYili;
    }

    public Calisan getCalisan() {
        return calisan;
    }

    public void setCalisan(Calisan calisan) {
        this.calisan = calisan;
    }

    @Override
    public String toString() {
        return "Sirket{" +
                "id=" + id +
                ", sirketadi='" + sirketadi + '\'' +
                ", sirketSahibi='" + sirketSahibi + '\'' +
                ", unvani='" + unvani + '\'' +
                ", faaliyetAlani='" + faaliyetAlani + '\'' +
                ", kurulusYili=" + kurulusYili +
                ", calisan=" + calisan +
                '}';
    }
}
