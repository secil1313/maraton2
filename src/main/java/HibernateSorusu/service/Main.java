package HibernateSorusu.service;

import HibernateSorusu.entity.Musteri;
import HibernateSorusu.entity.Siparis;
import HibernateSorusu.entity.SiparisKalemi;
import HibernateSorusu.entity.Urun;
import HibernateSorusu.repository.MusteriDao;
import HibernateSorusu.repository.SiparisDao;

import java.util.Arrays;
import java.util.List;

public class Main {
    static SiparisDao siparisDao = new SiparisDao();
    static MusteriDao musteriDao=new MusteriDao();

    public static void main(String[] args) {
        //save();

        //delete();
        //update();
        //soru2a();
        //soru2b();
        soru2c();
        //soru2d();
    }

    public static void save() {
        Musteri musteri1 = new Musteri("Secil", "Cakir");
        Urun urun1 = new Urun("Asus", 15000);
        SiparisKalemi siparisKalemi1 = new SiparisKalemi(urun1, 2);
        Siparis siparis1 = new Siparis(musteri1,
                Arrays.asList(siparisKalemi1));
        Musteri musteri2 = new Musteri("Omer", "Cakir");
        Urun urun2 = new Urun("Iphone14", 40000);
        SiparisKalemi siparisKalemi2 = new SiparisKalemi(urun2, 1);
        Siparis siparis2 = new Siparis(musteri2,
                Arrays.asList(siparisKalemi2));
        siparisDao.save(siparis1);
    }

    public static void soru2a() {

        List<Siparis> siparisList = siparisDao.getAll();

        for (Siparis item : siparisList) {
            System.out.println("Siparis id:" + item.getId() + " Musteri:" + item.getMusteri().getFirstName() +item.getMusteri().getLastName() + " MusteriId:"+ item.getMusteri().getId());

            int siparisToplam = 0;
            int urunFiyat = 0;
            for (SiparisKalemi item2 : item.getSiparisKalemi()) {
                System.out.println("Urun:" + item2.getUrun().getUrunAdi() + " Fiyat:" + item2.getUrun().getUrunFiyati() +" Alınan Urun Adedi:"+ item2.getAlinanUrunAdedi());
                urunFiyat = item2.getUrun().getUrunFiyati();
                siparisToplam = siparisToplam + urunFiyat* item2.getAlinanUrunAdedi();
            }

            System.out.println("Siparis Toplam:"+siparisToplam);
        }
    }
    public static void soru2b(){
        List<Musteri> musteriList = musteriDao.getAll();
        for (Musteri item : musteriList) {
            System.out.println("Musteri id:" + item.getId() + " Musteri ad:" + item.getFirstName() + " Soyadi:"+item.getLastName() );
            for (Siparis item2 : item.getSiparis()) {
                System.out.println("Siparis Id:" + item2.getId());

            int siparisToplam = 0;
            int urunFiyat = 0;
            for (SiparisKalemi item3 :  item2.getSiparisKalemi()) {
                System.out.println("Urun:" + item3.getUrun().getUrunAdi() + " Fiyat:" + item3.getUrun().getUrunFiyati() +" Alınan Urun Adedi:"+ item3.getAlinanUrunAdedi());
                urunFiyat = item3.getUrun().getUrunFiyati();
                siparisToplam = siparisToplam + urunFiyat* item3.getAlinanUrunAdedi();
            }

            System.out.println("Toplam Harcama:"+siparisToplam);
        }
    }}

    public static void update() {
        Musteri musteri2 = new Musteri("Berke", "Cakir");
        Urun urun2 = new Urun("Iphone15", 60000);
        SiparisKalemi siparisKalemi2 = new SiparisKalemi(urun2, 1);
        Siparis siparis2 = new Siparis(musteri2,
                Arrays.asList(siparisKalemi2));
        siparisDao.update(siparis2);
    }

    public static void delete() {
        siparisDao.deleteById(1);

    }
    public static void soru2c() {
        siparisDao.soru2c();

    }
    public static void soru2d() {
        siparisDao.soru2d();

    }

}



