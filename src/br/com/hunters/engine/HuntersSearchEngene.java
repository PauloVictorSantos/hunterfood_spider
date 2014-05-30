package br.com.hunters.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

import br.com.hunters.bean.Restaurante;
import br.com.hunters.match.ICompileRegex;
import br.com.hunters.util.HuntersUtil;

/**
 * Classe responsavem por acessar a pagina HTML e obter as informações dos restaurantes
 * @author BrunoMeira
 *
 */
public class HuntersSearchEngene implements IHuntersSearchEngene{
	
	private ICompileRegex regex;
	private Matcher matcher;
	
	private List<Restaurante> listRestaurante;
	
	public HuntersSearchEngene(ICompileRegex regex) {
		this.regex = regex;
	}
	
	/**
	 * Metodo responsavel por pegar os restaurantes do Restaurante Web
	 */
	public List<Restaurante> findReastaurante(HttpClient httpclient, String httpget, ResponseHandler<String> responseHandler) {
		
		try {
			
			this.listRestaurante = new ArrayList<Restaurante>();
			int id = 1;
			for(int i = 1;i <= 30; i++){
				/**
				 * Regex que pega as informações do codigo HTML 
				 */
				this.matcher = this.regex.execute(
						"<h2>[^>]*?<a\\shref=\"(.*?)\"\\stitle=\"(.*?)\">[^>]*?</a>[^>]*?</h2>[^>]*?"
						+ "<p\\sclass=\"endereco\"\\stitle=\"(.*?)\">[^>]*?</p>[^>]*?<p\\sclass=\"cozinha\">[^>]*?"
						+ "<strong>[^>]*?</strong>[^>]*?<span\\stitle=\"(.*?)\"", (String) httpclient.execute(new HttpGet(httpget + i), responseHandler));
				
				/**
				 * while faz o parse da informação obtida pelo regex em uma instância da classe Restaurante
				 */
				while (this.matcher.find()) {				
					
					Restaurante restaurante = new Restaurante();
					this.matcher.group(0);
					restaurante.setIdRestaurante(id);
					restaurante.setPagina(this.matcher.group(1));
					restaurante.setNome(HuntersUtil.retiraAcentos(this.matcher.group(2)));
					restaurante.setEndereco(HuntersUtil.retiraAcentos(this.matcher.group(3)));
					restaurante.setEspecialidadeGastronomica(HuntersUtil.retiraAcentos(this.matcher.group(4)));
					this.listRestaurante.add(restaurante);
					
					id = id + 1;

				}
			}			

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();

		}

		return this.listRestaurante;
	}
	

}
