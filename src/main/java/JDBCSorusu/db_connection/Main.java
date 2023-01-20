package JDBCSorusu.db_connection;

import JDBCSorusu.entity.Calisan;
import JDBCSorusu.entity.Sirket;
import JDBCSorusu.service.CalisanService;
import JDBCSorusu.service.SirketService;

public class Main {
    static CalisanService calisanService=new CalisanService();
    static SirketService sirketService=new SirketService();
    public static void main(String[] args) {
    //saveC();
        //updateC();
       // deleteC();
        //saveS();
        readC();
    }

    //CALİSAN
    public static void saveC(){
        Calisan calisan1=new Calisan("Deniz",28,30000,"Finans","Vakıfbank");
        calisanService.save(calisan1);

    }
    public static void updateC(){
        Calisan calisan1=new Calisan("Emre",30,30000,"Finans","Updatebank",1);
        calisanService.update(calisan1);
    }
    public static void deleteC(){
        calisanService.delete(2);
    }
    public static void readC(){
        calisanService.read();
    }

    //SİRKET
    public static void saveS(){
        Calisan calisan1=new Calisan(1);
        Sirket sirket=new Sirket("Tesla","Elon Musk","Unvan1","Otomotiv",2003,calisan1);
sirketService.save(sirket);

    }
}
