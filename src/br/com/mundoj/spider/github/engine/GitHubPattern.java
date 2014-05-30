package br.com.mundoj.spider.github.engine;

public final class GitHubPattern {
	public static final String REPOSITORIES_TAB = "[^<a\\shref=\"].*?\\?tab=repositories";
	public static final String AVATARED = "<div\\sclass=\"avatared\">[^>]*?<a\\shref=\"(.*?)\"";
	public static final String REPOSITORIES_LIST = "<h3>[^>]*?<span[^>]*?>.*?</span>[^>]*?<a\\shref=\"(.*?)\">(.*?)</a>[^>]*?</h3>";
	public static final String DOWNLOAD_ZIP = "<a\\shref=\"(.*?)\"[^>]*?><span[^>]*?></span>ZIP</a>";
	public static final String CLONE_URL = "<[^>]*?\\sclass=\"(?:http_clone_url|public_clone_url|private_clone_url)[^>]*?\">[^>]*?<a\\shref=\"(.*?)\"[^>]*?>(.*?)</a></[^>]*?>";
	public static final String GITHUB_HOME = "<[^>]*?class=\"(?:explore|search|features|blog)[^>]*?\"><a[^>]href=\"(.*?)>(.*?)</a></[^>]*?>";
	public static final String GITHUB_NOT_FOUND = "";
}