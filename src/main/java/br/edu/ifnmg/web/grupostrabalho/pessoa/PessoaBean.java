package br.edu.ifnmg.web.grupostrabalho.pessoa;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author dayany
 */
@Stateless
public class PessoaBean implements PessoaBeanLocal {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    //<editor-fold defaultstate="collapsed" desc="Consulta 1">
    @Override
    public List<Pessoa> findAllPessoaQuerry() {
        Query q = entityManager.createQuery("SELECT p FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoaTypedQuery() {
        return entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoaNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findAll", Pessoa.class).getResultList();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Consulta 2">
    @Override
    public List<Object[]> findNomeQuery() {
        Query q = entityManager.createQuery("SELECT p.nome FROM Pessoa p");
        return (List<Object[]>) q.getResultList();
    }

    @Override
    public List<Object[]> findNomeTypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome FROM Pessoa p", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> findNomeNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findNome", Object[].class).getResultList();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Consulta 3">
    @Override
    public List<Pessoa> fiindNomeEnderecoQuery() {
        Query q = entityManager.createQuery("SELECT p.nome, p.endereco FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Object[]> fiindNomeEnderecoTypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome, p.endereco FROM Pessoa p", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> fiindNomeEnderecoNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findNomeEndereco", Object[].class).getResultList();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Consulta 4">
    @Override
    public List<Pessoa> findPessoaQueMoramEmAvenidaQuery() {

        Query q = entityManager.createQuery("SELECT p from Pessoa p "
                + "WHERE p.endereco.tipoLogradouro = 1");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findPessoaQueMoramEmAvenidaTypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p from Pessoa p "
                + "WHERE p.endereco.tipoLogradouro = 1", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findPessoaQueMoramEmAvenidaNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findPessoaQueMoramEmAvenida", Pessoa.class).getResultList();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Consulta 5">
    @Override
    public List<Pessoa> findPessoasQueNaoMoramEmPracaQuery() {
        Query q = entityManager.createQuery("SELECT p from Pessoa p "
                + "WHERE NOT p.endereco.tipoLogradouro = 2");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> findPessoasQueNaoMoramEmPracaTypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p from Pessoa p "
                + "WHERE NOT p.endereco.tipoLogradouro = 2", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> findPessoasQueNaoMoramEmPracaNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findPessoaQueNaoMoramEmPraca", Pessoa.class).getResultList();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Consulta 6">
    @Override
    public List<Object[]> findNomeTelefoneQuery() {
        Query q = entityManager.createQuery("SELECT p.nome, t FROM Pessoa p "
                + "JOIN p.telefones t");
        return (List<Object[]>) q.getResultList();
    }

    @Override
    public List<Object[]> findNomeTelefoneTypedQuery() {
        TypedQuery q = entityManager.createQuery("SELECT p.nome, t FROM Pessoa p JOIN p.telefones t ", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> findNomeTelefoneNamedQuery() {
        return entityManager.createNamedQuery("Pessoa.findNomeTelefones", Object[].class).getResultList();
    }
    //</editor-fold>

    @Override
    public List<Pessoa> consulta7ByQuery(LocalDate beginDate, LocalDate endDate) {
        Query q = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.nascimento BETWEEN :beginDate AND :endDate").setParameter("beginDate", beginDate).setParameter("endDate", endDate);
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> consulta8AByQuery() {
        Query q = entityManager.createQuery("SELECT DISTINCT p FROM Pessoa p, IN (p.telefones) t "
                + "WHERE t.ddd=41 OR t.ddd=42 OR t.ddd=43 OR t.ddd=44 OR t.ddd=45 OR t.ddd=46");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> consulta8BByQuery() {
        Query q = entityManager.createQuery("SELECT DISTINCT p FROM Pessoa p, IN (p.telefones) t "
                + "WHERE t.ddd=21 OR t.ddd=22 OR t.ddd=24");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> consulta9ByQuery() {
        Query q = entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.telefones IS EMPTY");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> Consulta10ByQuery() {
        Query q = entityManager.createQuery("SELECT p.nome, count(t.id) FROM Pessoa p, IN (p.telefones) t GROUP BY p.nome");
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> consulta13ByQuery(String nomeGrupo) {
        Query q = entityManager.createQuery("SELECT p.nome FROM Pessoa p JOIN p.atuacoes a WHERE a.grupo.nome =:nomeGrupo ORDER BY p.nome DESC").setParameter("nomeGrupo", nomeGrupo);
        return (List<Pessoa>) q.getResultList();
    }

}
