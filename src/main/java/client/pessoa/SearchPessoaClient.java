package client.pessoa;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SearchPessoaClient {

	public static void main(String[] args) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(newUri("http://localhost:8080/v1/PessoaFisica?nome=santo"))
												      .header("Accept", "application/json")
												      .GET().build();
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		List<PessoaFisicaDTO> listPessoas = (List<PessoaFisicaDTO>) new ObjectMapper().readValue(response.body(), new TypeReference<List<PessoaFisicaDTO>>() {});
		listPessoas.forEach(System.out::println);
	}

	private static URI newUri(String uri) {
		try {
			return new URI(uri);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
}
