package br.edu.ifnmg.web.grupostrabalho.grupo;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dayany
 */
@Local
public interface GrupoBeanLocal {

    void save(Grupo grupo);

    List<Object[]> findLiderENomeGrupoByQuery();

    List<Grupo> findGruposNaoAtivosByQuery();

    List<Grupo> consuta14ByQuery(String nomeLider);

    List<Object[]> consulta15ByQuery(String nomeMembro);

    List<Grupo> consulta16ByQuery(String str);

    List<Object[]> consulta17ByQuery();

    List<Object[]> consulta18ByQuery(long qtd);

    
}
