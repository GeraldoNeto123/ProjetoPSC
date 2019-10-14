package DataAccess;
import DomainModel.Usuario;
import java.util.*;
import javax.persistence.*;

public class UsuarioDAO {
private static UsuarioDAO instance;
protected EntityManager entityManager;

    public static UsuarioDAO getInstance(){
    if (instance == null){
        instance = new UsuarioDAO();
    }
    return instance;
    }

    public UsuarioDAO(){
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PadariaPU");
        if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Usuario getById(final int id){
        return entityManager.find(Usuario.class, id);
    }
   
    @SuppressWarnings("unchecked")
    public List<Usuario> findAll(){
        return entityManager.createQuery("FROM " + Usuario.class.getName()+" u").getResultList();
    }

    public void persist(Usuario usuario){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }  
    }

    public void merge(Usuario usuario){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Usuario usuario){
        try{
            entityManager.getTransaction().begin();
            usuario = entityManager.find(Usuario.class, usuario.getCodigo());
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id){
        try{
            Usuario usuario = getById(id);
            remove(usuario);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
