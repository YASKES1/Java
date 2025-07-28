package simple.eclipse.web.program;
import java.util.Properties;

import  org.hibernate.SessionFactory;
//Rejestr usług to baza danych używana do śledzenia dostępnych instancji
import  org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//służy do zbudowania niezmiennej formy tabeli
import  org.hibernate.cfg.Configuration;

import  org.hibernate.cfg.Environment;
import  org.hibernate.service.ServiceRegistry;
import 	simple.eclipse.web.program.linear_fun;
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
         if (sessionFactory == null) {
            try {
                 Configuration configuration = new Configuration();

                 // Hibernate settings equivalent to hibernate.cfg.xml's properties
                 Properties settings = new Properties();
                 settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                 settings.put(Environment.URL, "jdbc:mysql://localhost:3306/maths?useSSL=false");
                 settings.put(Environment.USER, "root");
                 settings.put(Environment.PASS, "");
                 settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                 //zapisanie wszystkich instrukcji SQL do konsoli
                 settings.put(Environment.SHOW_SQL, "true");
                 //rodzaj implementacji klasy sesji
                 settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                 //sprawdza lub eksportuje schemat DDL do bazy danych po utworzeniu SessionFactory
                 settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                 configuration.setProperties(settings);
                 configuration.addAnnotatedClass(linear_fun.class);

                 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                 .applySettings(configuration.getProperties()).build();
                 System.out.println("Hibernate Java Config serviceRegistry created");
                 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                 return sessionFactory;

              } catch (Exception e) {
                 e.printStackTrace();
              }
          }
        return sessionFactory;
    }
}


