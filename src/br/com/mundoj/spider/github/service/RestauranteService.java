package br.com.mundoj.spider.github.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import br.com.hunters.bean.Restaurante;
import br.com.hunters.engine.HuntersSearchEngene;
import br.com.hunters.engine.IHuntersSearchEngene;
import br.com.hunters.match.CompileRegex;

@Path("/restaurante")
public class RestauranteService {
	
	/**
	 * Metodo responsavel por acessar a pagina do Restaurante Web e retornar um json
	 * @return
	 */
	@GET
	@Produces({"application/json"})
	public Map<String, Restaurante> findRestaurante(){
		
		String restauranteWebHomeDomain = "";
		
		Map restaurantes = new HashMap();
		
		List listRestaurante = new ArrayList<Restaurante>();
			
		restauranteWebHomeDomain = "http://restauranteweb.com.br/delivery/restaurantes?page=";
		
		IHuntersSearchEngene hunters = new HuntersSearchEngene(new CompileRegex());
		
		listRestaurante.add(hunters.findReastaurante(new DefaultHttpClient(), restauranteWebHomeDomain, new BasicResponseHandler()));
					
		restaurantes.put("Restaurantes", listRestaurante);
		
		return restaurantes;
		
	}
	
	@GET
	@Produces({"application/json"})
	public Map<String, Restaurante> findRestauranteZ(){
		
		String restauranteWebHomeDomain = "";
		
		Map restaurantes = new HashMap();
		
		List listRestaurante = new ArrayList<Restaurante>();
		
		restauranteWebHomeDomain = "http://www.zomato.com/saopaulo/restaurants/zona-oeste/itaim-bibi?page=";
		
		IHuntersSearchEngene hunters = new HuntersSearchEngene(new CompileRegex());
		
		listRestaurante.add(hunters.findReastaurante(new DefaultHttpClient(), restauranteWebHomeDomain, new BasicResponseHandler()));
					
		restaurantes.put("Restaurantes", listRestaurante);
		
		return restaurantes;
		
	}

}
