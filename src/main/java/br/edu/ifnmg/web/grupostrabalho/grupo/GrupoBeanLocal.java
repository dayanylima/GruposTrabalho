package br.edu.ifnmg.web.grupostrabalho.grupo;

import javax.ejb.Local;

/**
 *
 * @author dayany
 */
@Local
public interface GrupoBeanLocal {

    void save(Grupo grupo);
    
}
