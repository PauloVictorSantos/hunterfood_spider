package br.com.mundoj.spider.github.bean;

import java.io.Serializable;
import java.util.List;

public final class GitHub implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<GitHubRepository> repositories;
	private List<GitHubCloneUrl> cloneUrls;
	private String urlAvatared;
	private String urlTabRepositories;

	public List<GitHubRepository> getRepositories() {
		return this.repositories;
	}

	public void setRepositories(List<GitHubRepository> repositories) {
		this.repositories = repositories;
	}

	public List<GitHubCloneUrl> getCloneUrls() {
		return this.cloneUrls;
	}

	public void setCloneUrls(List<GitHubCloneUrl> cloneUrls) {
		this.cloneUrls = cloneUrls;
	}

	public String getUrlAvatared() {
		return this.urlAvatared;
	}

	public void setUrlAvatared(String urlAvatared) {
		this.urlAvatared = urlAvatared;
	}

	public String getUrlTabRepositories() {
		return this.urlTabRepositories;
	}

	public void setUrlTabRepositories(String urlTabRepositories) {
		this.urlTabRepositories = urlTabRepositories;
	}

	public String toString() {
		return getClass().getSimpleName() + " [repositories="
				+ this.repositories.toString() + ", cloneUrls="
				+ this.cloneUrls.toString() + ", avataredUrl="
				+ this.urlAvatared + ", urlTabRepositories="
				+ this.urlTabRepositories + "]";
	}
}