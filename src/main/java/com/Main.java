package com;

import com.entities.*;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {


        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(State.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(City.class);

        try (Session session = configuration.buildSessionFactory().openSession()) {
            State state = session.find(State.class, 1L);
            City c = new City();
            c.setState(state);
            c.setCityName("Indore");
            session.save(c);
            session.beginTransaction().commit();
        }

    }




}
