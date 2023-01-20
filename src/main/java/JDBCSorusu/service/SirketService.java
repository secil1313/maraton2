package JDBCSorusu.service;

import JDBCSorusu.db_connection.DB;
import JDBCSorusu.entity.Calisan;
import JDBCSorusu.entity.Sirket;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class SirketService implements ICrud<Sirket> {

    DB db = new DB();
    List<Sirket> list = new ArrayList<>();
    Sirket sirket;
    @Override
    public void read() {

    }



    @Override
    public void save(Sirket sirket) {
        try {
            String sql = "insert into sirket(sirketAdi,sirketSahibi,unvani,faaliyetAlani,kurulusYili,calisanid)  values(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, sirket.getSirketadi());
            preparedStatement.setString(2, sirket.getSirketSahibi());
            preparedStatement.setString(3, sirket.getUnvani());
            preparedStatement.setString(4, sirket.getFaaliyetAlani());
            preparedStatement.setInt(5, sirket.getKurulusYili());
            preparedStatement.setInt(6, sirket.getCalisan().getId());
            preparedStatement.executeUpdate();
            System.out.println("Customer added");
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(Sirket sirket) {

    }

    @Override
    public void delete(int id) {

    }
}
