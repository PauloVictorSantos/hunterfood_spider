package br.com.mundoj.spider.github.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import br.com.hunters.bean.Restaurante;
import br.com.mundoj.spider.github.bean.GitHub;
import br.com.mundoj.spider.github.bean.GitHubCloneUrl;
import br.com.mundoj.spider.github.bean.GitHubHome;
import br.com.mundoj.spider.github.bean.GitHubRepository;
import br.com.mundoj.spider.github.match.ICompileRegex;

public final class GitHubSearchEngine implements IGitHubSearchEngine {

	private ICompileRegex regex;
	private Matcher matcher;
	private String urlTabRepositories;
	private String urlAvatared;
	private String urlDownloadZipFile;
	private List<GitHubRepository> listGitHubRepository;
	private List<GitHubCloneUrl> listGitHubCloneUrl;
	private final GitHub gitHub;
	private List<GitHubHome> listGitHubHome;
	

	public GitHubSearchEngine(ICompileRegex regex) {
		this.regex = regex;
		this.gitHub = new GitHub();
	}

	public GitHub search(HttpClient httpclient, HttpGet httpget, ResponseHandler<String> responseHandler) {

		try {

			this.gitHub.setUrlAvatared(new GitHubSearchEngine(this.regex).findUrlAvatared(httpclient, httpget, responseHandler));

			this.gitHub.setUrlTabRepositories(new GitHubSearchEngine(this.regex).findUrlTabRepositories(httpclient, httpget, responseHandler));

			if (this.gitHub.getUrlTabRepositories() != null) {

				httpget = new HttpGet(this.gitHub.getUrlTabRepositories());

			}

			this.matcher = this.regex.execute("<h3>[^>]*?<span[^>]*?>.*?</span>[^>]*?<a\\shref=\"(.*?)\">(.*?)</a>[^>]*?</h3>",(String) httpclient.execute(httpget, responseHandler));
			
			this.listGitHubRepository = new ArrayList();

			while (this.matcher.find()) {

				GitHubRepository gitHubRepository = new GitHubRepository();

				gitHubRepository.setUrl("https://github.com"
						+ this.matcher.group(1));

				gitHubRepository.setTitle(this.matcher.group(2));

				gitHubRepository.setZip(new GitHubSearchEngine(this.regex)
						.downloadZipFile(new DefaultHttpClient(), new HttpGet(
								"https://github.com" + this.matcher.group(1)),
								new BasicResponseHandler()));

				this.listGitHubRepository.add(gitHubRepository);

				this.gitHub.setCloneUrls(new GitHubSearchEngine(this.regex)
						.findCloneUrls(new DefaultHttpClient(), new HttpGet(
								"https://github.com" + this.matcher.group(1)),
								new BasicResponseHandler()));
			}

			this.gitHub.setRepositories(this.listGitHubRepository);

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		finally {

			httpclient.getConnectionManager().shutdown();

		}

		return this.gitHub;

	}

	public String findUrlAvatared(HttpClient httpclient, HttpGet httpget,
			ResponseHandler<String> responseHandler) {

		try {

			this.matcher = this.regex.execute(
					"<div\\sclass=\"avatared\">[^>]*?<a\\shref=\"(.*?)\"",
					(String) httpclient.execute(httpget, responseHandler));

			while (this.matcher.find()) {
				this.urlAvatared = this.matcher.group(1);
			}

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return this.urlAvatared;
	}

	public String findUrlTabRepositories(HttpClient httpclient,
			HttpGet httpget, ResponseHandler<String> responseHandler) {

		try {

			this.matcher = this.regex.execute(
					"[^<a\\shref=\"].*?\\?tab=repositories",
					(String) httpclient.execute(httpget, responseHandler));

			while (this.matcher.find()) {
				this.urlTabRepositories = ("https://github.com" + this.matcher
						.group(0));
			}

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return this.urlTabRepositories;

	}

	public String downloadZipFile(HttpClient httpclient, HttpGet httpget,
			ResponseHandler<String> responseHandler) {

		try {

			this.matcher = this.regex.execute("<a\\shref=\"(.*?)\"[^>]*?><span[^>]*?></span>ZIP</a>",
					(String) httpclient.execute(httpget, responseHandler));

			while (this.matcher.find()) {
				this.urlDownloadZipFile = ("https://github.com" + this.matcher.group(1));
			}

		}

		catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return this.urlDownloadZipFile;
	}

	public List<GitHubCloneUrl> findCloneUrls(HttpClient httpclient,
			HttpGet httpget, ResponseHandler<String> responseHandler) {

		try {

			this.listGitHubCloneUrl = new ArrayList();

			this.matcher = this.regex
					.execute(
							"<[^>]*?\\sclass=\"(?:http_clone_url|public_clone_url|private_clone_url)[^>]*?\">[^>]*?<a\\shref=\"(.*?)\"[^>]*?>(.*?)</a></[^>]*?>",
							(String) httpclient.execute(httpget, responseHandler));

			while (this.matcher.find()) {

				GitHubCloneUrl gitHubCloneUrl = new GitHubCloneUrl();

				gitHubCloneUrl.setUrl(this.matcher.group(1));

				gitHubCloneUrl.setTitle(this.matcher.group(2));

				this.listGitHubCloneUrl.add(gitHubCloneUrl);

			}

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return this.listGitHubCloneUrl;

	}

	public List<GitHubHome> findMenuGitHubHome(HttpClient httpclient, HttpGet httpget, ResponseHandler<String> responseHandler) {

		try {
			this.listGitHubHome = new ArrayList();
			this.matcher = this.regex
					.execute(
							"<[^>]*?class=\"(?:explore|search|features|blog)[^>]*?\"><a[^>]href=\"(.*?)>(.*?)</a></[^>]*?>",
							(String) httpclient.execute(httpget,
									responseHandler));

			while (this.matcher.find()) {

				GitHubHome gitHubHome = new GitHubHome();
				gitHubHome.setUrl(this.matcher.group(1));
				gitHubHome.setTitle(this.matcher.group(2));
				this.listGitHubHome.add(gitHubHome);

			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();

		}

		return this.listGitHubHome;
	}
	
	
}