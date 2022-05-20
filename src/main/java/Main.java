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
//            Codpostal cod = new Codpostal();
//            cod.setCodpostal("4925-574");
//            uti.setTipoutilizadorByCodtipo(obj);


            //entityManager.persist(uti);
//            CodpostalBLL.create(cod);
            //ou
            //ClienteJpaController cliBll = new ClienteJpaController(factory);
            //cliBll.create(cli);

//            System.out.println("ID criado: " + uti.getIdutilizador());
//            Utilizador ut2 = UtilizadorBLL.read(uti.getUsername());
//            if (uti.equals(ut2)) System.out.println("É o mesmo cliente!!!");
//            else System.out.println("Pois!");


            List<Codpostal> lista = CodpostalBLL.readAll();
            for(Codpostal cod1 : lista) {
//                if(Objects.equals(cod1.getCodpostal(), "4925-547")) {
//                    cod1.setDescricao("Outeiro");
//                    CodpostalBLL.update(cod1);
//                    CategoriaBLL.delete(cat1);

//                }
                System.out.println("ID " + cod1.getCodpostal() + " chama-se " + cod1.getLocalidade());
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
