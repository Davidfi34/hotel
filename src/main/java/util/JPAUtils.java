package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

    private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("hotel");

    public static EntityManager getEntityManger(){
        return FACTORY.createEntityManager();
    }
}
