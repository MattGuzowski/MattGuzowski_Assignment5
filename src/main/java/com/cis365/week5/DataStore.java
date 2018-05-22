package com.cis365.week5;

import java.util.List;

import com.cis365.week5.models.Planet;
import com.cis365.week5.models.PlanetVisit;
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

            String dbName = System.getenv("RDS_DB_NAME");
            String userName = System.getenv("RDS_USERNAME");
            String password = System.getenv("RDS_PASSWORD");
            String hostName = System.getenv("RDS_HOSTNAME");
            String port = System.getenv("RDS_PORT");
            String jdbcUrl = "jdbc:oracle:thin:@" + hostName + ":" + port + ":" + dbName;
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration cfg = new Configuration();
            
            cfg.setProperty("connection.driver_class", "oracle.jdbc.driver.OracleDriver");
            cfg.setProperty("hibernate.connection.url", jdbcUrl);
            cfg.setProperty("hibernate.connection.username", userName);
            cfg.setProperty("hibernate.connection.password", password);
            cfg.setProperty("hibernate.hbm2ddl.auto", "update");
            cfg.setProperty("dialect", "org.hibernatge.dialect.Oracle10gDialect");
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

    public static Planet findPlanetById(int planetId) {

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

//    public static Planet updateVisit(String planetId, PlanetVisit visitToUpdate) {
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

    public static void addPlanet(int planetId, Planet planetIn) {

        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Planet existing = findPlanetById(planetId);
            if (existing == null) {
                session.save(planetIn);
            }
            tx.commit();

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
    }

    public static void deletePlanet(int planetId) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Planet existing = findPlanetById(planetId);
            if (existing != null) {
                session.createQuery("DELETE FROM Planet WHERE planetId =" + planetId);
            }

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
    }

    public static Planet updatePlanet(int planetId, Planet planetToUpdate) {
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
