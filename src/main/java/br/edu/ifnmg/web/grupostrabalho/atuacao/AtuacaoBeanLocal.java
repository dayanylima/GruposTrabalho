package br.edu.ifnmg.web.grupostrabalho.atuacao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dayany
 */
@Local
public interface AtuacaoBeanLocal {

    void save(Atuacao atuacao);

}
