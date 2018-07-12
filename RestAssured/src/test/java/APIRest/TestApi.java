package APIRest;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.response.Response;

public class TestApi {

	@Test
	public void Executa() {
		String[] url = {};
		TestarApi(200,url, "proxylatam.indra.es", 8080);
	}

	public void TestarApi(int paramStatus, String[] url, String enderecoProxy, Integer portaProxy) {

		Response response = null;
		try {
			if (url.length > 0 && url != null) {
				for (int i = 0; i < url.length; i++) {
					String uriBase = url[i];
					if (enderecoProxy != null && portaProxy != null) {
						response = (Response) given().relaxedHTTPSValidation().proxy(enderecoProxy, portaProxy).when()
								.get(uriBase);
					} else {
						response = (Response) given().get(uriBase);
					}
					if (response.getStatusCode() == paramStatus) {
						System.out.println("Sucesso: " + response.getStatusCode());
					} else {
						System.out.println("Erro na url: " + url[i]);
					}
				}
			} else {
				System.out.println("Url sem parametros!! ");
			}
		} catch (Exception ex) {
			System.out.println("Erro: " + response);
		}
	}

}
