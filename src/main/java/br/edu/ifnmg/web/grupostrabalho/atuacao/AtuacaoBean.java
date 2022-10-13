package br.edu.ifnmg.web.grupostrabalho.atuacao;

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
public class AtuacaoBean implements AtuacaoBeanLocal {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void save(Atuacao atuacao) {        
        entityManager.persist(atuacao);
    }

 
    
}
