package com.example.backend.BLL;

import com.example.backend.entity.Produtoencomenda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProdutoencomendaBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Produtoencomenda prodenc){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(prodenc);
        em.getTransaction().commit();
    }


    public static List<Produtoencomenda> readAll(){
        List<Produtoencomenda> listaprodenc = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Produtoencomenda.findAll");
        List<Object> result = q1.getResultList();

        for(Object prodenc : result){
            listaprodenc.add((Produtoencomenda) prodenc);
        }

        return listaprodenc;
    }

    public static void update(Produtoencomenda prodenc){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(prodenc);
        em.getTransaction().commit();
    }

    public static void delete(Produtoencomenda prodenc){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(prodenc);
        em.getTransaction().commit();
    }
}
