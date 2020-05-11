package DAOS;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import Entities.*;

public class UserDao {


    private static EntityManager em = Persistence.createEntityManagerFactory("Marktplaats").createEntityManager();

    public void insertUser(User x) {
        // start transaction.
        em.getTransaction().begin();
        // add gebruiker to DB.
        em.persist(x);
        // finalize transaction.
        em.getTransaction().commit();
    }



}
