package br.com.alura.viacep;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Principal {

	public static void main(String[] args) {
		
		Scanner leitura = new Scanner(System.in);
		
		System.out.println("CEP: ");
		var busca = leitura.nextLine();
		String url = "https://viacep.com.br/ws/" + busca + "/json/";
		
		try {
		HttpClient client = HttpClient.newHttpClient();
		   HttpRequest request = HttpRequest.newBuilder()
		         .uri(URI.create(url))
		         .build();
		   
		HttpResponse<String> response = client
				     .send(request, BodyHandlers.ofString()); 
		
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		EnderecoViaCep meuEnderecoViaCep = gson.fromJson(response.body(), EnderecoViaCep.class);
		
		System.out.println(meuEnderecoViaCep.toString());
		
		Endereco meuEndereco = new Endereco(meuEnderecoViaCep);
		
		FileWriter escrita = new FileWriter("Endereços.txt");
		escrita.write(meuEndereco.toString());
		escrita.close();
		
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println("Verifique o endereço");
		} catch(NullPointerException e) {
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro");
		}
	
}
}
