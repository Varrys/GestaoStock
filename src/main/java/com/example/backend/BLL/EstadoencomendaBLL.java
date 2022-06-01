package com.example.backend.BLL;

import com.example.backend.entity.Estadoencomenda;
import com.example.backend.entity.Tipoutilizador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EstadoencomendaBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Estadoencomenda estadoenc){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(estadoenc);
        em.getTransaction().commit();
    }

    public static Estadoencomenda read(String estado){
        Estadoencomenda estadoenc = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Estadoencomenda.findByEstado");
        q1.setParameter("estado", estado);
        Object obj = q1.getSingleResult();

        if(obj != null){
            estadoenc = ((Estadoencomenda)obj);
        }
        else
            return null;


        return estadoenc;
    }

    public static List<Estadoencomenda> readAll(){
        List<Estadoencomenda> listaEstadoEnc = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Estadoencomenda.findAll");
        List<Object> result = q1.getResultList();

        for(Object estadoenc : result){
            listaEstadoEnc.add((Estadoencomenda) estadoenc);
        }

        return listaEstadoEnc;
    }

    public static List<Estadoencomenda> readAll(String estado){
        List<Estadoencomenda> listaEstadoEnc = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Estadoencomenda.findByEstado");
        q1.setParameter("estado", "%"+estado+"%");
        List<Object> result = q1.getResultList();

        for(Object estadoenc : result){
            listaEstadoEnc.add((Estadoencomenda) estadoenc);
        }

        return listaEstadoEnc;
    }

    public static void update(Estadoencomenda estadoenc){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(estadoenc);
        em.getTransaction().commit();
    }

    public static void delete(Estadoencomenda estadoenc){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(estadoenc);
        em.getTransaction().commit();
    }
}
