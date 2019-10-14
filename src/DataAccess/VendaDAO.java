package DataAccess;

import DomainModel.Venda;
import java.util.*;
import javax.persistence.*;

public class VendaDAO {

    private static VendaDAO instance;
    protected EntityManager entityManager;

    public static VendaDAO getInstance() {
        if (instance == null) {
            instance = new VendaDAO();
        }
        return instance;
    }

    public VendaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PadariaPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Venda getById(final long id) {
        return entityManager.find(Venda.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Venda> findAll() {
        return entityManager.createQuery("FROM " + Venda.class.getName() + " c").getResultList();
    }

    public void persist(Venda venda) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(venda);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public long merge(Venda venda) {
        Venda v = null;
        
        try {
            entityManager.getTransaction().begin();
            v = entityManager.merge(venda);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        
        return v.getCodigo();
    }

    public void remove(Venda venda) {
        try {
            entityManager.getTransaction().begin();
            venda = entityManager.find(Venda.class, venda.getCodigo());
            entityManager.remove(venda);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Venda venda = getById(id);
            remove(venda);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
