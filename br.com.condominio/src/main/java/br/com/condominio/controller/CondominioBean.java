package br.com.condominio.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.condominio.model.Condominio;
import br.com.condominio.model.repositorios.RepositorioCondominio;

@Scope( value = WebApplicationContext.SCOPE_SESSION )
@Named( value = "CondominioBean" )
public class CondominioBean extends BaseBeans{

	@Inject
	private RepositorioCondominio repositorioCondominio;
	private List<Condominio> condominios;
	private Condominio condominioSelecionado;
	
	public void onLoad(){
		this.condominios =  this.repositorioCondominio.findAll();
	}
	
	public void unSelectCondominio() {
		this.condominioSelecionado = null;
	}

	public void selectCondominio( SelectEvent evento ){//evento ajax
		try{
			if ( evento.getObject() != null ){
				this.condominioSelecionado = (Condominio) evento.getObject();
			}
			else{
				this.condominioSelecionado = null;
			}
		}catch (Exception ex){
			this.condominioSelecionado = null;
		}
	}
	
	public void delete() {
		if (this.condominioSelecionado != null) {
			this.repositorioCondominio.delete(this.condominioSelecionado.getCNPJ());
		}
	}
	
	public List<Condominio> getCondominios() {
		return condominios;
	}

	public void setCondominios(List<Condominio> condominios) {
		this.condominios = condominios;
	}

	public Condominio getCondominioSelecionado() {
		return condominioSelecionado;
	}

	public void setCondominioSelecionado(Condominio condominioSelecionado) {
		this.condominioSelecionado = condominioSelecionado;
	}
	
}
