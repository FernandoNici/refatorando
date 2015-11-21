package br.com.condominio.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "condomino")
public class Condomino{
	
	private String nome;
    private String sobreNome;
    private String RG;
    private Long telefone;
    private String apartamento;
    private String CPF;
      
    public Condomino() {
	}

	public Condomino(String nome, String sobreNome, String RG, String CPF,
			Long telefone, String apartamento) {
		super();
		this.CPF = CPF;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.RG = RG;
		this.telefone = telefone;
		this.apartamento = apartamento;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}


    
}