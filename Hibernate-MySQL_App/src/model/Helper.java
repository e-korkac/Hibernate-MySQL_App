package model;

import entities.Staff;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Helper {
    
    static org.hibernate.Session session;
       
    public static void addStaff(String name, int age, String address, int income) {
        session = (Session) MySession.createSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            Staff staff = new Staff(name, age, address, income);
            session.persist(staff);
            tr.commit();
        } 
        catch (HibernateException e) {tr.rollback(); e.printStackTrace();} 
        finally {session.close();}
    }
    
    public static List<Staff> showAll() {
        session = (Session) MySession.createSession();
        try
        {
        org.hibernate.Query query = session.createQuery("select s from Staff s");
        return query.list();
        } 
        catch(HibernateException e) {e.printStackTrace();}
        finally {/*session.close();*/}
        return null;
    }
    
    public static Staff showByIncome(int income) {
        session = (Session) MySession.createSession();
        try{
        org.hibernate.Query q = session.createQuery("select s from Staff as s where s.income = :u");
        q.setParameter("u", income);
        return (Staff)(q.list().get(0));
        }
        catch(HibernateException e) {e.printStackTrace();}
        finally {/*session.close();*/}
        return null;
    }
    
    public static void delete(int id) {
     session = (Session) MySession.createSession();
     Transaction tr = null; 
     try{
            tr = session.beginTransaction();
            Staff s = (Staff) session.get(Staff.class, id);
            session.delete(s); 
            tr.commit();
     }   
     catch (HibernateException e) {tr.rollback(); e.printStackTrace();}
     finally {session.close();}
    }
    
    public static void update(int id) {
    session = (Session) MySession.createSession();
    Transaction tr = null; 
     try{
         tr = session.beginTransaction();
         Staff s = (Staff) session.get(Staff.class, id);
         s.setIncome(s.getIncome() + 1000);
         tr.commit();
     }   
     catch (HibernateException e) {tr.rollback(); e.printStackTrace();}
     finally {session.close();}
    }
    
}
