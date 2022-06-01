package com.example.backend.BLL;

import com.example.backend.entity.Produto;
import com.example.backend.entity.Saidaproduto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class SaidaProdutoBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Saidaproduto saidaprod){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(saidaprod);
        em.getTransaction().commit();
    }

        public static List<Saidaproduto> readAll(){
        List<Saidaproduto> listaSaidaProd = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("SaidaProduto.findAll");
        List<Object> result = q1.getResultList();

        for(Object saidaprod : result){
            listaSaidaProd.add((Saidaproduto) saidaprod);
        }

        return listaSaidaProd;
    }

    public static void update(Saidaproduto saidaprod){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(saidaprod);
        em.getTransaction().commit();
    }

    public static void delete(Saidaproduto saidaprod){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(saidaprod);
        em.getTransaction().commit();
    }
}
