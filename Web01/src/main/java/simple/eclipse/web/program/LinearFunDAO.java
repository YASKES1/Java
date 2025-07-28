package simple.eclipse.web.program;
import java.util.List;
//metody save,update,delete
import org.hibernate.Session;
import org.hibernate.Transaction;

import simple.eclipse.web.program.linear_fun;
import simple.eclipse.web.program.HibernateUtil;
public class LinearFunDAO {
	public void saveLinearFun(linear_fun lf) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(lf);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
            	//czyszczenie modyfikacji
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    
    public void updateLinearFun(linear_fun lf) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(lf);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    
    public void deleteLinearFun(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a linear fun object
            linear_fun lf = session.get(linear_fun.class, id);
            if (lf != null) {
                session.delete(lf);
                System.out.println("linear is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    
    public linear_fun getLinearFun(int id) {

        Transaction transaction = null;
        linear_fun lf = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an linear object
            lf = session.get(linear_fun.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return lf;
    }

    
    @SuppressWarnings("unchecked")
    public List < linear_fun > getAllLinearFuns() {

        Transaction transaction = null;
        List < linear_fun > listOfLF = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an linear object

            listOfLF = session.createQuery("from linear_fun").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfLF;
    }
}
