package org.example.entry;


import org.example.query.Query;
import org.example.tshirt.Tshirt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class CreateEntry {
    private static SessionFactory sessionFactory;

    public CreateEntry(){

    }
    public boolean insert(Tshirt shirt){
        createSession();
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.persist(shirt);
            session.getTransaction().commit();
            closeSession();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Tshirt> check(Query query){
        List<Tshirt> ls = null;
        createSession();
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            ls = session.createQuery(query.getQuery(), Tshirt.class).list();
            session.getTransaction().commit();
            closeSession();
        } catch (Exception e){
            e.printStackTrace();
        }
        return ls;
    }

    public boolean dropTable(){
        createSession();
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.createQuery("delete Tshirt").executeUpdate();
            session.getTransaction().commit();
            closeSession();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    protected void createSession() {
        final StandardServiceRegistry reg = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try{
            sessionFactory = new MetadataSources(reg)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void closeSession(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }

}
