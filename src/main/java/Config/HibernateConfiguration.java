package Config;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import entities.Car;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
    public static SessionFactory sessionFactory;

    private HibernateConfiguration() {
    }

    public static void prepareHibernate() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/jdbc");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "88322");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");

        configuration.setProperty("hibernate.show_sql=", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.setProperty("hibernate.format_sql", "true");

        configuration.addAnnotatedClass(Car.class);

        EntityScanner.scanPackages("entities").addTo(configuration);
        sessionFactory = configuration.buildSessionFactory();
    }


}
