package br.com.hunters.engine;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

import br.com.hunters.bean.Restaurante;

public interface IHuntersSearchEngene {
	
	public abstract List<Restaurante> findReastaurante(HttpClient paramHttpClient, String paramHttpGet, ResponseHandler<String> paramResponseHandler);

}
