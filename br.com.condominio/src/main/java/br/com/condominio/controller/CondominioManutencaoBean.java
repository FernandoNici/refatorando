package br.com.condominio.controller;

import javax.inject.Inject;
import javax.inject.Named;



import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.condominio.model.Condominio;
import br.com.condominio.model.repositorios.RepositorioCondominio;

@Scope( value = WebApplicationContext.SCOPE_REQUEST )
@Named( value = "CondominioManutencaoBean" )
public class CondominioManutencaoBean extends BaseBeans{
	
	private Condominio condominio;
	private String titulo;
	
	@Inject
	private CondominioBean condominioBean;
	@Inject
	private RepositorioCondominio repositorioCondominio;
	
	public CondominioManutencaoBean() {
		this.condominio = new Condominio();
	}
	
	public void add(){
		this.titulo = "Adicionar";
	}
	
	public void update(){
		this.titulo = "Editar";
		this.condominio = condominioBean.getCondominioSelecionado();
	}
	
	public Condominio getCondominio() {
		return condominio;
	}
	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}
	public String getTitulo() {
		return titulo;
	}
	public void save(){
		if (this.titulo.equals("Adicionar")){
			if (this.repositorioCondominio.findOne(this.condominio.getCNPJ()) == null ) {
				this.repositorioCondominio.save(this.condominio);
			}
			else{
				System.out.println("já existe");
			}
		}
		else{//this.titulo == "Editar";
			this.repositorioCondominio.save(this.condominio);
		}
		
	}

	public void cancel(){
		this.condominioBean.unSelectCondominio();
	}
}




