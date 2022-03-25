package com;

import com.entities.City;
import com.entities.Country;
import com.entities.State;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {


        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(State.class)
                .addAnnotatedClass(City.class);

        try (Session session = configuration.buildSessionFactory().openSession()) {
            State state = session.find(State.class,1l);
            City c = new City();
            c.setState(state);
            c.setCityName("Indore");
            session.save(c);
            City city = session.find(City.class,1l);
            session.beginTransaction().commit();
            System.out.println(city);
        }

    }




}
