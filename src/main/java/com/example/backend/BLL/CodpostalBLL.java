package com.example.backend.BLL;

import com.example.backend.entity.Codpostal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CodpostalBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Codpostal cod){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(cod);
        em.getTransaction().commit();
    }

    public static Codpostal read(String localidade){
        Codpostal cod = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Codpostal.findByLocalidade");
        q1.setParameter("localidade", localidade);
        Object obj = q1.getSingleResult();

        if(obj != null){
            cod = ((Codpostal)obj);
        }
        else
            return null;


        return cod;
    }

    public static List<Codpostal> readAll(){
        List<Codpostal> listaCod = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Codpostal.findAll");
        List<Object> result = q1.getResultList();

        for(Object cod : result){
            listaCod.add((Codpostal) cod);
        }

        return listaCod;
    }

    public static List<Codpostal> readAll(String localidade){
        List<Codpostal> listaCod = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Codpostal.findByLocalidade");
        q1.setParameter("localidade", "%"+localidade+"%");
        List<Object> result = q1.getResultList();

        for(Object cod : result){
            listaCod.add((Codpostal) cod);
        }

        return listaCod;
    }

    public static void update(Codpostal cod){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(cod);
        em.getTransaction().commit();
    }

    public static void delete(Codpostal cod){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(cod);
        em.getTransaction().commit();
    }
}
