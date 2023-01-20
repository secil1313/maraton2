package JDBCSorusu.service;

import JDBCSorusu.db_connection.DB;
import JDBCSorusu.entity.Calisan;
import JDBCSorusu.entity.Sirket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalisanService implements ICrud<Calisan> {
    DB db = new DB();
    List<Calisan> list = new ArrayList<>();
    Calisan calisan;

    @Override
    public void read() {
        try{
            String sql = "select c.calisanIsmi,c.yasi,c.maasi,c.departman,c.calistigiSirket,s.sirketSahibi,s.unvani,s.faaliyetAlani,s.kurulusYili from calisan as c\n" +
                    "inner join sirket as s on s.calisanid=c.id";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("calisanIsmi");
                int yasi = rs.getInt("yasi");
                int maasi = rs.getInt("maasi");
                String departman = rs.getString("departman");
                String calistigiSirket = rs.getString("calistigiSirket");
                String sirketSahibi = rs.getString("sirketSahibi");
                String unvani = rs.getString("unvani");
                String faaliyetAlani = rs.getString("faaliyetAlani");
                int kurulusYili = rs.getInt("kurulusYili");

                calisan = new Calisan(name, yasi,maasi,departman,calistigiSirket,new Sirket(sirketSahibi,unvani,faaliyetAlani,kurulusYili));
                list.add(calisan);
            }
            if (list.isEmpty()){
                System.out.println("Boş");
            }else {
                list.forEach(System.out::println);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void save(Calisan calisan) {
        try {
            String sql = "insert into calisan(calisanIsmi,yasi,maasi,departman,calistigiSirket)  values(?,?,?,?,?)";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, calisan.getCalisanIsmi());
            preparedStatement.setInt(2, calisan.getYasi());
            preparedStatement.setInt(3, calisan.getMaasi());
            preparedStatement.setString(4, calisan.getDepartman());
            preparedStatement.setString(5, calisan.getCalistigiSirket());

            preparedStatement.executeUpdate();
            System.out.println("Calisan kaydedildi.");
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(Calisan calisan) {
        String sql="update calisan set calisanIsmi=?,yasi=?,maasi=?,departman=?,calistigiSirket=? where id=?";
        try {
            PreparedStatement preparedStatement=db.connection.prepareStatement(sql);
            preparedStatement.setString(1, calisan.getCalisanIsmi());
            preparedStatement.setInt(2, calisan.getYasi());
            preparedStatement.setInt(3, calisan.getMaasi());
            preparedStatement.setString(4, calisan.getDepartman());
            preparedStatement.setString(5, calisan.getCalistigiSirket());
            preparedStatement.setInt(6, calisan.getId());
            preparedStatement.executeUpdate();
            System.out.println("Calisan güncellendi.");
            preparedStatement.close();
            read();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try{
            if(calisan.getCalistigiSirket()==null){
            String sql="delete from calisan where id=?";
            PreparedStatement preparedStatement=db.connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Calisan silindi.");}
            read();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
