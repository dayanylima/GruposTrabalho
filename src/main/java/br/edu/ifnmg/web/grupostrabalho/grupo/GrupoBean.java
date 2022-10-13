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

    @Override
    public List<Grupo> findGruposNaoAtivosByQuery() {
        Query q = entityManager.createQuery("SELECT g FROM Grupo g WHERE g.ativo=false");
        return (List<Grupo>) q.getResultList();
    }

    @Override
    public List<Grupo> consuta14ByQuery(String nomeLider) {
        Query q = entityManager.createQuery("SELECT g FROM Grupo g JOIN g.lider l WHERE l.nome=: nomeLider").setParameter("nomeLider", nomeLider);
        return (List<Grupo>) q.getResultList();
    }

    @Override
    public List<Object[]> consulta15ByQuery(String nomeMembro) {
        Query q = entityManager.createQuery("SELECT g.nome,a.inicio,a.termino FROM Grupo g JOIN g.atuacoes a  WHERE a.pessoa.nome=:nomeMembro").setParameter("nomeMembro", nomeMembro);
        return (List<Object[]>) q.getResultList();
    }

    @Override
    public List<Grupo> consulta16ByQuery(String str) {
        Query q = entityManager.createQuery("SELECT g FROM Grupo g WHERE g.nome LIKE :str ").setParameter("str", '%'+str+'%');
        return (List<Grupo>) q.getResultList();
    }

    @Override
    public List<Object[]> consulta17ByQuery() {
             Query q = entityManager.createQuery("SELECT g.nome,count(DISTINCT a.pessoa) FROM Grupo g JOIN g.atuacoes a GROUP BY g");
        return (List<Object[]>) q.getResultList();
    }

    @Override
    public List<Object[]> consulta18ByQuery(long qtd) {
        Query q = entityManager.createQuery("SELECT g.nome, COUNT(a.id) FROM Grupo g JOIN g.atuacoes a GROUP BY g HAVING COUNT(a.id) >= :qtd").setParameter("qtd", qtd);
        return (List<Object[]>) q.getResultList();
    }
    
    
    
    

}
