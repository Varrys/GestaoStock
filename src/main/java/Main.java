import BLL.*;
import entity.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Objects;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
              transaction.begin();
//            Query q1 = entityManager.createNamedQuery("TipoUtilizador.findAllByCodTipo");
//            q1.setParameter("codtipo", BigInteger.valueOf(1));
//            Tipoutilizador obj = (Tipoutilizador)  q1.getSingleResult();
//            System.out.println(obj);
//
//            Utilizador uti = new Utilizador();
//            uti.setUsername("Varrys6");
//            uti.setPassword("12345");
//            uti.setTelefone(BigInteger.valueOf(914404299));
//            uti.setTipoutilizadorByCodtipo(obj);



            //entityManager.persist(uti);
            //UtilizadorBLL.create(uti);
            //o
            //ClienteJpaController cliBll = new ClienteJpaController(factory);
            //cliBll.create(cli);
            //
            //
//            System.out.println("ID criado: " + uti.getIdutilizador());
//
//            Utilizador ut2 = UtilizadorBLL.read(uti.getUsername());
//
//            if (uti.equals(ut2)) System.out.println("É o mesmo cliente!!!");
//            else System.out.println("Pois!");


            List<Categoria> lista = CategoriaBLL.readAll();
            for(Categoria cat1 : lista) {
//                if(Objects.equals(cat1.getIdcategoria(), BigInteger.valueOf(4))) {
//                    cat1.setEstado("Feijão Branco");
//                    CategoriaBLL.update(cat1);
//                    CategoriaBLL.delete(cat1);

//                }
                System.out.println("ID " + cat1.getIdcategoria() + " chama-se " + cat1.getEstado());
            }
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
