import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    private static final String CONFIG_FILE = "hibernate.cfg.xml";

    public static SessionFactory createSessionFactory() {
        return new Configuration().configure(CONFIG_FILE).buildSessionFactory();
    }
}