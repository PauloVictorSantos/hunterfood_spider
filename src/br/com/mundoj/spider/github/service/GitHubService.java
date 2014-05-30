package br.com.mundoj.spider.github.service;

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

import br.com.mundoj.spider.github.bean.GitHub;
import br.com.mundoj.spider.github.bean.GitHubHome;
import br.com.mundoj.spider.github.engine.GitHubSearchEngine;
import br.com.mundoj.spider.github.engine.IGitHubSearchEngine;
import br.com.mundoj.spider.github.match.CompileRegex;

@Path("/github")
public final class GitHubService {

	@GET
	@Produces({ "application/json" })
	public Map<String, List<GitHubHome>> findMenuHome() {

		String gitHubHomeDomain = "https://github.com";

		Map menuHome = new HashMap();

		IGitHubSearchEngine gitHub = new GitHubSearchEngine(new CompileRegex());

		List listGitHubHome = gitHub.findMenuGitHubHome( new DefaultHttpClient(), new HttpGet(gitHubHomeDomain), new BasicResponseHandler());

		menuHome.put(gitHubHomeDomain, listGitHubHome);

		return menuHome;
	}

	@GET
	@Produces({ "application/json" })
	@Path("{user}")
	public Map<String, GitHub> findDataUser(@PathParam("user") String user) {
		String gitHubDomainAndUser = "https://github.com/" + user;

		Map repositories = new HashMap();

		IGitHubSearchEngine gitHub = new GitHubSearchEngine(new CompileRegex());

		GitHub gitHubReference = gitHub.search(new DefaultHttpClient(), new HttpGet(gitHubDomainAndUser), new BasicResponseHandler());

		repositories.put(gitHubDomainAndUser, gitHubReference);

		return repositories;
	}
	
}