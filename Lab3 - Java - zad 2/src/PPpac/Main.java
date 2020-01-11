package PPpac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;


public class Main {

    private static void find() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "NewPersistenceUnit" );              // otwiera EM
        EntityManager em = emf.createEntityManager();
        CoffeesEntity coffee = em.find( CoffeesEntity.class, "Colombian" );                                                     //szuka w bazie rekordu o danym kluczu głównym

        System.out.println();
        System.out.println("Coffee name = " + coffee.getCofName( ));
        System.out.println("Coffee Price = " + coffee.getPrice( ));
        System.out.println("Coffee Sales = " + coffee.getSales( ));
        System.out.println("Coffee Total = " + coffee.getTotal( ));
        System.out.println();
    }

    private static void update() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "NewPersistenceUnit" );

        EntityManager em = emf.createEntityManager( );
        em.getTransaction( ).begin( );
        CoffeesEntity coffee = em.find( CoffeesEntity.class, "Colombian" );

        System.out.println();
        System.out.println( coffee );                                                         // dane przed update
        coffee.setSales( coffee.getSales() + 1);
        em.getTransaction( ).commit( );                                                       // umieszcza to w bazie

        System.out.println( coffee );                                                         // dane po update
        System.out.println();
        em.close();
        emf.close();
    }

    private static void add() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "NewPersistenceUnit" );

        EntityManager em = emf.createEntityManager( );
        em.getTransaction( ).begin( );

        CoffeesEntity coffee = new CoffeesEntity( );
        coffee.setCofName( "Cappuccino" );
        coffee.setSuppId( em.find(SuppliersEntity.class,101));                                  // musi być przypisane do już istniejącego
        coffee.setPrice( BigDecimal.valueOf(8.50) );
        coffee.setSales( 0 );
        coffee.setTotal( 0 );

        em.persist( coffee );
        em.getTransaction( ).commit( );

        em.close( );
        emf.close( );
    }

    public static void main(String[] args) {
        find();
        update();
        find();
        add();
    }
}