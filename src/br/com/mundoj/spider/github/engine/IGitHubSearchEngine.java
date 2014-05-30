package br.com.mundoj.spider.github.engine;

import br.com.hunters.bean.Restaurante;
import br.com.mundoj.spider.github.bean.GitHub;
import br.com.mundoj.spider.github.bean.GitHubCloneUrl;
import br.com.mundoj.spider.github.bean.GitHubHome;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

public abstract interface IGitHubSearchEngine {
	public static final String DOMAIN = "https://github.com";

	public abstract GitHub search(HttpClient paramHttpClient,
			HttpGet paramHttpGet, ResponseHandler<String> paramResponseHandler);

	public abstract String findUrlAvatared(HttpClient paramHttpClient,
			HttpGet paramHttpGet, ResponseHandler<String> paramResponseHandler);

	public abstract String findUrlTabRepositories(HttpClient paramHttpClient,
			HttpGet paramHttpGet, ResponseHandler<String> paramResponseHandler);

	public abstract String downloadZipFile(HttpClient paramHttpClient,
			HttpGet paramHttpGet, ResponseHandler<String> paramResponseHandler);

	public abstract List<GitHubCloneUrl> findCloneUrls(
			HttpClient paramHttpClient, HttpGet paramHttpGet,
			ResponseHandler<String> paramResponseHandler);

	public abstract List<GitHubHome> findMenuGitHubHome(
			HttpClient paramHttpClient, HttpGet paramHttpGet,
			ResponseHandler<String> paramResponseHandler);
	
}