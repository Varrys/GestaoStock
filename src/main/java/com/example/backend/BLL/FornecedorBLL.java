package com.example.backend.BLL;

import com.example.backend.entity.Fornecedor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class FornecedorBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Fornecedor forn){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(forn);
        em.getTransaction().commit();
    }

    public static Fornecedor read(String nome){
        Fornecedor forn = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Fornecedor.findByNome");
        q1.setParameter("nome", nome);
        Object obj = q1.getSingleResult();

        if(obj != null){
            forn = ((Fornecedor)obj);
        }
        else
            return null;


        return forn;
    }

    public static List<Fornecedor> readAll(){
        List<Fornecedor> listaForn = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Fornecedor.findAll");
        List<Object> result = q1.getResultList();

        for(Object forn : result){
            listaForn.add((Fornecedor) forn);
        }

        return listaForn;
    }

    public static List<Fornecedor> readAll(String nome){
        List<Fornecedor> listaForn = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Fornecedor.findByNome");
        q1.setParameter("nome", "%"+nome+"%");
        List<Object> result = q1.getResultList();

        for(Object forn : result){
            listaForn.add((Fornecedor) forn);
        }

        return listaForn;
    }

    public static void update(Fornecedor forn){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(forn);
        em.getTransaction().commit();
    }

    public static void delete(Fornecedor forn){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(forn);
        em.getTransaction().commit();
    }
}
