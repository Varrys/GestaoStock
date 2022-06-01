package com.example.backend.BLL;
import com.example.backend.entity.Utilizador;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

public class UtilizadorBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static void create(Utilizador uti){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(uti);
        em.getTransaction().commit();
    }

    public static Utilizador read(String username){
        Utilizador uti = null;
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Utilizador.findByUsername");
        q1.setParameter("username", username);
        Object obj = q1.getSingleResult();

        if(obj != null){
            uti = ((Utilizador)obj);
        }
        else
            return null;


        return uti;
    }

    public static List<Utilizador> readAll(){
        List<Utilizador> listaUti = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Utilizador.findAll");
        List<Object> result = q1.getResultList();

        for(Object uti : result){
            listaUti.add((Utilizador) uti);
        }

        return listaUti;
    }

    public static List<Utilizador> readAll(String nome){
        List<Utilizador> listaUti = new ArrayList<>();
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Utilizador.findByUsername");
        q1.setParameter("username", "%"+nome+"%");
        List<Object> result = q1.getResultList();

        for(Object uti : result){
            listaUti.add((Utilizador) uti);
        }

        return listaUti;
    }

    public static void update(Utilizador uti){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(uti);
        em.getTransaction().commit();
    }

    public static void delete(Utilizador uti){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        if (em == null) em = factory.createEntityManager();

        em.getTransaction().begin();
        em.remove(uti);
        em.getTransaction().commit();
    }
}
