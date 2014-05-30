package br.com.hunters.util;

public class HuntersUtil {

	/**
	 * Troca as tags HTML ISO-8859-1 de acentos comuns para a letra referente
	 * @param value
	 * @return value
	 */
	public static String retiraAcentos(String value) {

		value = value.replaceAll("&#192;", "A"); // À
		value = value.replaceAll("&#193;", "A"); // Á
		value = value.replaceAll("&#194;", "A"); // Â
		value = value.replaceAll("&#195;", "A"); // Ã

		value = value.replaceAll("&#201;", "E"); // È
		value = value.replaceAll("&#202;", "E"); // É
		value = value.replaceAll("&#203;", "E"); // Ê

		value = value.replaceAll("&#204;", "I"); // Ì
		value = value.replaceAll("&#205;", "I"); // Í
		value = value.replaceAll("&#206;", "I"); // Î

		value = value.replaceAll("&#210;", "O"); // Ò
		value = value.replaceAll("&#211;", "O"); // Ó
		value = value.replaceAll("&#212;", "O"); // Ô
		value = value.replaceAll("&#213;", "O"); // Õ

		value = value.replaceAll("&#217;", "U"); // Ù
		value = value.replaceAll("&#218;", "U"); // Ú
		value = value.replaceAll("&#219;", "U"); // Û

		value = value.replaceAll("&#224;", "a"); // à
		value = value.replaceAll("&#225;", "a"); // á
		value = value.replaceAll("&#226;", "a"); // â
		value = value.replaceAll("&#227;", "a"); // ã

		value = value.replaceAll("&#232;", "e"); // è
		value = value.replaceAll("&#233;", "e"); // é
		value = value.replaceAll("&#234;", "e"); // ê

		value = value.replaceAll("&#236;", "i"); // ì
		value = value.replaceAll("&#237;", "i"); // í
		value = value.replaceAll("&#238;", "i"); // î

		value = value.replaceAll("&#242;", "o"); // ò
		value = value.replaceAll("&#243;", "o"); // ó
		value = value.replaceAll("&#244;", "o"); // ô
		value = value.replaceAll("&#245;", "o"); // õ

		value = value.replaceAll("&#249;", "u"); // ù
		value = value.replaceAll("&#250;", "u"); // ú
		value = value.replaceAll("&#251;", "u"); // û

		value = value.replaceAll("&#231;", "c"); // ç

		return value;

	}

}
