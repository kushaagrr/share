package com.nagarro.dao;


import com.nagarro.model.Tshirt;
import com.nagarro.utils.SortTshirtPrice;
import com.nagarro.utils.SortTshirtRating;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

public class TshirtDaoImpl implements TshirtDao {
    @Autowired
    private SessionFactory sf;
    @Override
    @Transactional
    public List<Tshirt> getShirt(String color, String size, String gender) {
        try(Session session = sf.getCurrentSession()){
            session.beginTransaction();
            String query = "select t from Tshirt t where t.color=:color and t.size=:size and t.gender=:gender";
            List<Tshirt> res = session.createQuery(query, Tshirt.class).setParameter("color", color)
                    .setParameter("size", size)
                    .setParameter("gender", gender)
                    .list();
            System.out.println(res);
            session.getTransaction().commit();
            return res;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Tshirt> getShirtByPreference(List<Tshirt> shirts, String preference) {
        if(preference.equalsIgnoreCase("price")) {
            Collections.sort(shirts, new SortTshirtPrice());
        } else if (preference.equalsIgnoreCase("rating")) {
            Collections.sort(shirts, new SortTshirtRating());
        }
        return shirts;
    }
}
