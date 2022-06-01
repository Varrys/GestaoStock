package com.example.backend;

import com.example.backend.BLL.*;
import com.example.backend.entity.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            /*Query q1 = entityManager.createNamedQuery("TipoUtilizador.findAllByCodTipo");
            q1.setParameter("codtipo", BigInteger.valueOf(1));
            Tipoutilizador obj = (Tipoutilizador)  q1.getSingleResult();
            System.out.println(obj);*/
//            Query q1 = entityManager.createNamedQuery("Codpostal.findAllbyCodpostal");
//            q1.setParameter("codpostal", "4925-574");
//            Codpostal obj = (Codpostal)  q1.getSingleResult();
//            System.out.println(obj);
//
////            Codpostal cod = new Codpostal();
////            cod.setCodpostal("4925-574");
//            Fornecedor forn = new Fornecedor();
//            forn.setNome("Valdir");
//            forn.setEmail("valdir@gmail.com");
//            forn.setRua("caminho do alho");
//            forn.setTelefone(914404289L);
//            forn.setNif(3404003L);
//            forn.setCodpostalByCodpostal(obj);
//            FornecedorBLL.create(forn);



            //entityManager.persist(uti);
//            CodpostalBLL.create(cod);
            //ou
            //ClienteJpaController cliBll = new ClienteJpaController(factory);
            //cliBll.create(cli);

//            System.out.println("ID criado: " + uti.getIdutilizador());
//            Utilizador ut2 = UtilizadorBLL.read(uti.getUsername());
//            if (uti.equals(ut2)) System.out.println("É o mesmo cliente!!!");
//            else System.out.println("Pois!");


//            List<Codpostal> lista = CodpostalBLL.readAll();
//            for(Codpostal cod1 : lista) {
////                if(Objects.equals(cod1.getCodpostal(), "4925-547")) {
////                    cod1.setDescricao("Outeiro");
////                    CodpostalBLL.update(cod1);
////                    CategoriaBLL.delete(cat1);
////                }
//                System.out.println("ID " + cod1.getCodpostal() + " chama-se " + cod1.getLocalidade());
//            }
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
