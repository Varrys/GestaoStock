package com.example.backend.BLL;

import com.example.backend.entity.Tipoutilizador;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class TipoutilizadorBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Tipoutilizador tipouti){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(tipouti);
        em.getTransaction().commit();
    }

    public static Tipoutilizador read(String descricao){
        Tipoutilizador tipouti = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("TipoUtilizador.findByDescricao");
        q1.setParameter("descricao", descricao);
        Object obj = q1.getSingleResult();

        if(obj != null){
            tipouti = ((Tipoutilizador)obj);
        }
        else
            return null;


        return tipouti;
    }

    public static List<Tipoutilizador> readAll(){
        List<Tipoutilizador> listaTipouti = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("TipoUtilizador.findAll");
        List<Object> result = q1.getResultList();

        for(Object tipouti : result){
            listaTipouti.add((Tipoutilizador) tipouti);
        }

        return listaTipouti;
    }

    public static List<Tipoutilizador> readAll(String descricao){
        List<Tipoutilizador> listaTipouti = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Tipoutilizador.findByDescricao");
        q1.setParameter("descricao", "%"+descricao+"%");
        List<Object> result = q1.getResultList();

        for(Object tipouti : result){
            listaTipouti.add((Tipoutilizador) tipouti);
        }

        return listaTipouti;
    }

    public static void update(Tipoutilizador tipouti){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(tipouti);
        em.getTransaction().commit();
    }

    public static void delete(Tipoutilizador tipouti){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(tipouti);
        em.getTransaction().commit();
    }
}
