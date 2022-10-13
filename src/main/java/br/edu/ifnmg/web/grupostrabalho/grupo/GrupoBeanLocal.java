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

    
}
