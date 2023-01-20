package HibernateSorusu.repository;

import HibernateSorusu.entity.Musteri;
import HibernateSorusu.entity.Siparis;
import HibernateSorusu.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class MusteriDao {
    public void save(Siparis siparis) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(siparis);
            session.getTransaction().commit();
            System.out.println("Siparis is added");
            session.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    } public List<Musteri> getAll() {

        List<Musteri> list = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            list = session.createQuery("select musteri from Musteri musteri").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
