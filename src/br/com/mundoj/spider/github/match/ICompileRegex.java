package br.com.mundoj.spider.github.match;

import java.util.regex.Matcher;

public abstract interface ICompileRegex {

	public abstract Matcher execute(String paramString1, String paramString2);

}