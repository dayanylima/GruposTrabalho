package br.edu.ifnmg.web.grupostrabalho.pessoa;

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



    

   
}
