package br.com.neppogamify.neppogamify.repository;

import br.com.neppogamify.neppogamify.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by joaop on 17/08/2017.
 */
public interface Funcionarios extends JpaRepository<Funcionario, Long>{

}
