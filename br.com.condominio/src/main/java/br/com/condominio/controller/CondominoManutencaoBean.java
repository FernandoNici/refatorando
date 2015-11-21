package br.com.condominio.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.condominio.model.Condomino;
import br.com.condominio.model.repositorios.RepositorioCondomino;

@Scope( value = WebApplicationContext.SCOPE_REQUEST )
@Named( value = "CondominoManutencaoBean" )
public class CondominoManutencaoBean extends BaseBeans{
	
	private static final long serialVersionUID = 1L;
	private Condomino condomino;
	private String titulo;
	
	@Inject
	private CondominoBean condominoBean;
	@Inject
	private RepositorioCondomino repositorioCondomino;
	
	public CondominoManutencaoBean() {
		this.condomino = new Condomino();
	}
	
	public void add(){
		this.titulo = "Adicionar";
	}
	public void update(){
		this.titulo = "Editar";
		this.condomino = condominoBean.getCondominoSelecionado();
	}
	public Condomino getCondomino() {
		return condomino;
	}
	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}
	public String getTitulo() {
		return titulo;
	}
	public void save(){
		if (titulo == "Adicionar"){
			if (this.condomino != null){
				if (this.repositorioCondomino.findOne(this.condomino.getCPF()) == null ) {
					this.repositorioCondomino.save(this.condomino);
				}
				else{
					System.out.println("já existe");
				}
			}
		}
		else{
			this.repositorioCondomino.save(this.condomino);
		}
	}

	public void cancel(){
		this.condominoBean.unSelectCondomino();
	}
}

