package HibernateSorusu.utils;


import HibernateSorusu.entity.Musteri;
import HibernateSorusu.entity.Siparis;
import HibernateSorusu.entity.SiparisKalemi;
import HibernateSorusu.entity.Urun;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                configuration.addAnnotatedClass(Musteri.class);
                configuration.addAnnotatedClass(Siparis.class);
                configuration.addAnnotatedClass(SiparisKalemi.class);
                configuration.addAnnotatedClass(Urun.class);
                sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return sessionFactory;
    }

}
