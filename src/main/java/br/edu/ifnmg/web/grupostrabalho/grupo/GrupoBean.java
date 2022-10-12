package br.edu.ifnmg.web.grupostrabalho.grupo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    
}
