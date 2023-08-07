package br.com.alura.viacep;

import com.google.gson.annotations.SerializedName;

import br.com.alura.screenmatch.modelos.Titulo;

public class Endereco {

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	
	public Endereco(String numero, String logradouro) {
		this.cep = numero;
		this.logradouro = logradouro;
	}
	
	public Endereco(EnderecoViaCep ViaCep) {
		this.cep = ViaCep.cep();
		this.logradouro = ViaCep.logradouro();
		this.complemento = ViaCep.complemento();
		this.bairro = ViaCep.bairro();
		this.localidade = ViaCep.localidade();
	}
	
	@Override
	public String toString() {
		return "CEP: " + getCep() + "\n" + 
				"Logradouro: " + getLogradouro() + "\n" + 
		"Complemento: " + getComplemento() + "\n" + 
		"Bairro: " + getBairro() + "\n" + 
		"Cidade: " + getLocalidade();
	}
	
	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLocalidade() {
		return localidade;
	}


	


	
	
}
