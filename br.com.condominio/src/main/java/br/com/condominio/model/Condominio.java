package br.com.condominio.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "condominio" )
public class Condominio {//extends BaseEntity<String>

	@Id
    private String CNPJ;
	//private Long id;
	private String nome;
    private int andares;
    private int aptosPorAndar;
    private String cep;
    private String municipio;
    private String endereco;
    private String bairro;
    
    public Condominio() {
	}

	public Condominio(String nome, String CNPJ, int andares, int aptosPorAndar,
			String cep, String municipio, String endereco, String bairro) {
		super();
		this.CNPJ = CNPJ;
		this.nome = nome;
		this.andares = andares;
		this.aptosPorAndar = aptosPorAndar;
		this.cep = cep;
		this.municipio = municipio;
		this.endereco = endereco;
		this.bairro = bairro;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAndares() {
		return andares;
	}
	public void setAndares(int andares) {
		this.andares = andares;
	}
	public int getAptosPorAndar() {
		return aptosPorAndar;
	}
	public void setAptosPorAndar(int aptosPorAndar) {
		this.aptosPorAndar = aptosPorAndar;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
		
    
}
