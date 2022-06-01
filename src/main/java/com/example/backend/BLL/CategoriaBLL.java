package com.example.backend.BLL;

import com.example.backend.entity.Categoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CategoriaBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Categoria cat){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }

    public static Categoria read(String estado){
        Categoria cat = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Categoria.findByEstado");
        q1.setParameter("estado", estado);
        Object obj = q1.getSingleResult();

        if(obj != null){
            cat = ((Categoria)obj);
        }
        else
            return null;


        return cat;
    }

    public static List<Categoria> readAll(){
        List<Categoria> listaCat = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Categoria.findAll");
        List<Object> result = q1.getResultList();

        for(Object cat : result){
            listaCat.add((Categoria) cat);
        }

        return listaCat;
    }

    public static List<Categoria> readAll(String estado){
        List<Categoria> listaCat = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Categoria.findByEstado");
        q1.setParameter("estado", "%"+estado+"%");
        List<Object> result = q1.getResultList();

        for(Object cat : result){
            listaCat.add((Categoria) cat);
        }

        return listaCat;
    }

    public static void update(Categoria cat){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();
    }

    public static void delete(Categoria cat){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();
    }
}
