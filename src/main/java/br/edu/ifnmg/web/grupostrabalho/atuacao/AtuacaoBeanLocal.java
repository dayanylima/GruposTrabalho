package br.edu.ifnmg.web.grupostrabalho.atuacao;

import javax.ejb.Local;

/**
 *
 * @author dayany
 */
@Local
public interface AtuacaoBeanLocal {

    void save(Atuacao atuacao);

}
