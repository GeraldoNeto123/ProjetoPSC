package DataAccess;
import DomainModel.Mercadoria;
import java.util.*;
import javax.persistence.*;

public class MercadoriaDAO {
private static MercadoriaDAO instance;
protected EntityManager entityManager;

    public static MercadoriaDAO getInstance(){
    if (instance == null){
        instance = new MercadoriaDAO();
    }
    return instance;
    }

    public MercadoriaDAO(){
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PadariaPU");
        if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Mercadoria getById(final int id){
        return entityManager.find(Mercadoria.class, id);
    }
   
    @SuppressWarnings("unchecked")
    public List<Mercadoria> findAll(){
        return entityManager.createQuery("FROM " + Mercadoria.class.getName()+" m").getResultList();
    }

    public void persist(Mercadoria mercadoria){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(mercadoria);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }  
    }

    public void merge(Mercadoria mercadoria){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(mercadoria);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Mercadoria mercadoria){
        try{
            entityManager.getTransaction().begin();
            mercadoria = entityManager.find(Mercadoria.class, mercadoria.getCodigo());
            entityManager.remove(mercadoria);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id){
        try{
            Mercadoria mercadoria = getById(id);
            remove(mercadoria);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

