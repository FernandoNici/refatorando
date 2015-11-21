package br.com.condominio.model.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.condominio.model.Condomino;

public interface RepositorioCondomino  extends JpaRepository<Condomino, String>{

}
