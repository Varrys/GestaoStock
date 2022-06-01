package com.example.backend.BLL;

import com.example.backend.entity.Encomenda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EncomendaBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Encomenda enc){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(enc);
        em.getTransaction().commit();
    }

    public static Encomenda read(Integer id){
        Encomenda enc = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Encomenda.findAllByIdEncomenda");
        q1.setParameter("id", id);
        Object obj = q1.getSingleResult();

        if(obj != null){
            enc = ((Encomenda)obj);
        }
        else
            return null;

        return enc;
    }

    public static List<Encomenda> readAll(){
        List<Encomenda> listaEnc = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Encomenda.findAll");
        List<Object> result = q1.getResultList();

        for(Object enc : result){
            listaEnc.add((Encomenda) enc);
        }

        return listaEnc;
    }

    public static void update(Encomenda enc){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(enc);
        em.getTransaction().commit();
    }

    public static void delete(Encomenda enc){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(enc);
        em.getTransaction().commit();
    }
}
