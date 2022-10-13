package br.edu.ifnmg.web.grupostrabalho.grupo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dayany
 */
@Stateless
public class GrupoBean implements GrupoBeanLocal {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void save(Grupo grupo) {
        entityManager.persist(grupo);
    }

    @Override
    public List<Object[]> findLiderENomeGrupoByQuery() {
       Query q = entityManager.createQuery("SELECT g.nome, l.nome FROM Grupo g JOIN g.lider l");
        return (List<Object[]>) q.getResultList();
    }

 
    
    
    
    
    
}
