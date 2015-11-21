package br.com.condominio.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.condominio.model.Condomino;
import br.com.condominio.model.repositorios.RepositorioCondomino;

@Scope( value = WebApplicationContext.SCOPE_SESSION )
@Named( value = "CondominoBean" )
public class CondominoBean extends BaseBeans{
	
	@Inject
	private RepositorioCondomino repositorioCondomino;
	private List<Condomino> condominos;
	private Condomino condominoSelecionado;
	private String id;
	
	public void onLoad(){
		this.condominos =  this.repositorioCondomino.findAll();
	}
	
	public void unSelectCondomino() {
		this.condominoSelecionado = null;
	}

	public void selectCondomino( SelectEvent evento ){//evento ajax
		try{
			if ( evento.getObject() != null ){
				this.condominoSelecionado = (Condomino) evento.getObject();
			}
			else{
				this.condominoSelecionado = null;
			}
		}catch (Exception ex){
			this.condominoSelecionado = null;
		}
	}
	
	public void delete() {
		if (this.condominoSelecionado != null) {
			this.repositorioCondomino.delete(this.condominoSelecionado.getCPF());
		}
	}
	
	public List<Condomino> getCondominos() {
		return condominos;
	}

	public void setCondominos(List<Condomino> condominos) {
		this.condominos = condominos;
	}

	public Condomino getCondominoSelecionado() {
		return condominoSelecionado;
	}

	public void setCondominoSelecionado(Condomino condominoSelecionado) {
		this.condominoSelecionado = condominoSelecionado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}