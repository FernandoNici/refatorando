package br.com.condominio.model.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.condominio.model.Condominio;

public interface RepositorioCondominio extends JpaRepository<Condominio, String>{

}
