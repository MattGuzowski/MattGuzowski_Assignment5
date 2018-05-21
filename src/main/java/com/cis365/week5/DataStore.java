package com.cis365.week5;

import java.util.List;

import com.cis365.week5.models.Customer;
import com.cis365.week5.models.Planet;
import com.cis365.week5.models.PlanetVisit;
import com.cis365.week5.models.Rep;
import com.cis365.week5.models.Starship;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;

public class DataStore {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {

//            String dbName = System.getenv("RDS_DB_NAME");
//            String userName = System.getenv("RDS_USERNAME");
//            String password = System.getenv("RDS_PASSWORD");
//            String hostname = System.getenv("RDS_HOSTNAME");
//            String port = System.getenv("RDS_PORT");
//            String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + dbName;

            // Create the SessionFactory from hibernate.cfg.xml
            Configuration cfg = new Configuration();



            cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file
            return cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

//    public static List<Customer> listCustomers( ) {
//        Session session = getSessionFactory().openSession();
//
//        try {
//            return session.createQuery("FROM Customer").list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
    public static List<Starship> listStarships() {

        Session session = getSessionFactory().openSession();
        try {
            return session.createQuery("FROM Starship").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static List<PlanetVisit> listVisits() {
        Session session = getSessionFactory().openSession();

        try {
            return session.createQuery("FROM PlanetVisit").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public static List<Planet> listPlanets() {
        Session session = getSessionFactory().openSession();

        try {
            return session.createQuery("FROM Planet").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
//    public static List<Rep> listReps() {
//        Session session = getSessionFactory().openSession();
//
//        try {
//            return session.createQuery("FROM Rep").list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }

    public static Planet findPlanetById(String planetId) {
        Session session = getSessionFactory().openSession();

        try {
            return (Planet) session.get(Planet.class, planetId);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
//    public static Rep findRepById(String repNum) {
//        Session session = getSessionFactory().openSession();
//
//        try {
//            return (Rep) session.get(Rep.class, repNum);
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//public static Planet updateVisit(String planetId, PlanetVisit visitToUpdate) {
//        Session session = getSessionFactory().openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            PlanetVisit existing = findVisit(planetId);
//            if (existing != null && planetId == planetToUpdate.getPlanetId())
//                existing = planetToUpdate;
//            tx.commit();
//            return planetToUpdate;
//        }  catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//    

//    public static Rep updateRep(String repNum, Rep repToUpdate) {
//        Session session = getSessionFactory().openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            Rep existing = findRepById(repNum);
//            if (existing != null && repNum == repToUpdate.getId())
//                existing = repToUpdate;
//            tx.commit();
//            return repToUpdate;
//        }  catch (HibernateException e) {
//            if (tx != null)
//                tx.rollback();
//            e.printStackTrace();
//        }catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
    public static Planet updatePlanet(String planetId, Planet planetToUpdate) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Planet existing = findPlanetById(planetId);
            if (existing != null && planetId == planetToUpdate.getPlanetId()) {
                existing = planetToUpdate;
            }
            tx.commit();
            return planetToUpdate;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
