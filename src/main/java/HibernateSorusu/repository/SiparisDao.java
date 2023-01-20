package HibernateSorusu.repository;

import HibernateSorusu.entity.Siparis;
import HibernateSorusu.entity.SiparisKalemi;
import HibernateSorusu.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SiparisDao implements  ICrud<Siparis>{
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

    }

    @Override
    public void update(Siparis siparis) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(siparis);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }}

    @Override
    public void deleteById(int id) {
        Session session = null;
        Siparis siparis = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            siparis = session.load(Siparis.class, id);
            session.delete(siparis);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
    @Override
    public List<Siparis> getAll() {

        List<Siparis> list = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            list = session.createQuery("select siparis from Siparis siparis").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void soru2c() {
        List<Object[]> siparisList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "SELECT m.id, SUM(musteri_id) FROM siparis as s\n" +
                    "inner join musteri as m on s.musteri_id=m.id\n" +
                    "GROUP BY m.id";
            siparisList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : siparisList) {

                    System.out.println("MusteriId: " + item[0] + " --"
                            + " SiparisSayisi: " + item[1]

                    );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void soru2d() {
        List<Object[]> siparisList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "SELECT m.firstName, m.lastName, s.id FROM musteri as m\n" +
                    "Inner join siparis as s ON m.id = s.musteri_id;";
            siparisList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : siparisList) {

                System.out.println(" Müşteri Ad: " + item[0] + " --"
                        + " Müşteri Soyad: " + item[1] + " --"
                        + " Sipariş ID: " + item[2]

                );

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

