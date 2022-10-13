package br.edu.ifnmg.web.grupostrabalho.pessoa;

import java.time.LocalDate;
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

    List<Pessoa> findPessoaQueMoramEmAvenidaQuery();

    List<Pessoa> findPessoaQueMoramEmAvenidaTypedQuery();

    List<Pessoa> findPessoaQueMoramEmAvenidaNamedQuery();

    List<Pessoa> findPessoasQueNaoMoramEmPracaQuery();

    List<Pessoa> findPessoasQueNaoMoramEmPracaTypedQuery();

    List<Pessoa> findPessoasQueNaoMoramEmPracaNamedQuery();

    List<Pessoa> consulta7ByQuery(LocalDate beginDate, LocalDate endDate);

}
