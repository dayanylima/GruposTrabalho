package br.edu.ifnmg.web.grupostrabalho.pessoa;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dayany
 */
@Local
public interface PessoaBeanLocal {

    void save(Pessoa pessoa);

    List<Pessoa> findAllPessoaQuerry();

    List<Pessoa> findAllPessoaTypedQuery();

    List<Pessoa> findAllPessoaNamedQuery();

    List<Object[]> findNomeQuery();

    List<Object[]> findNomeTypedQuery();

    List<Object[]> findNomeNamedQuery();

    List<Pessoa> fiindNomeEnderecoQuery();

    List<Object[]> fiindNomeEnderecoTypedQuery();

    List<Object[]> fiindNomeEnderecoNamedQuery();

    List<Object[]> findNomeTelefoneQuery();

    List<Object[]> findNomeTelefoneTypedQuery();

    List<Object[]> findNomeTelefoneNamedQuery();

    List<Object[]> findPessoasQueNaoPossuemTelefoneQuery();

}
