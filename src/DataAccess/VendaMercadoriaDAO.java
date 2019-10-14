package DataAccess;

import DomainModel.VendaMercadoria;
import java.util.*;
import javax.persistence.*;

public class VendaMercadoriaDAO {

    private static VendaMercadoriaDAO instance;
    protected EntityManager entityManager;

    public static VendaMercadoriaDAO getInstance() {
        if (instance == null) {
            instance = new VendaMercadoriaDAO();
        }
        return instance;
    }

    public VendaMercadoriaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PadariaPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public VendaMercadoria getById(final int id) {
        return entityManager.find(VendaMercadoria.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<VendaMercadoria> findAll() {
        return entityManager.createQuery("FROM " + VendaMercadoria.class.getName() + " vm").getResultList();
    }

    public void persist(VendaMercadoria vendaMercadoria) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vendaMercadoria);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(VendaMercadoria vendaMercadoria) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(vendaMercadoria);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(VendaMercadoria vendaMercadoria) {
        try {
            entityManager.getTransaction().begin();
            vendaMercadoria = entityManager.find(VendaMercadoria.class, vendaMercadoria.getIdVenda());
            entityManager.remove(vendaMercadoria);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            VendaMercadoria vendaMercadoria = getById(id);
            remove(vendaMercadoria);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
