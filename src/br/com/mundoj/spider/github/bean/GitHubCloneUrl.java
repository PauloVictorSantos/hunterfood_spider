package br.com.mundoj.spider.github.bean;

import java.io.Serializable;

public final class GitHubCloneUrl implements Serializable {
	private static final long serialVersionUID = 1L;
	private String url;
	private String title;

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		return getClass().getSimpleName() + " [url=" + this.url + ", title="
				+ this.title + "]";
	}
}