package br.com.hunters.util;

public class HuntersUtil {

	/**
	 * Troca as tags HTML ISO-8859-1 de acentos comuns para a letra referente
	 * @param value
	 * @return value
	 */
	public static String retiraAcentos(String value) {

		value = value.replaceAll("&#192;", "A"); // �
		value = value.replaceAll("&#193;", "A"); // �
		value = value.replaceAll("&#194;", "A"); // �
		value = value.replaceAll("&#195;", "A"); // �

		value = value.replaceAll("&#201;", "E"); // �
		value = value.replaceAll("&#202;", "E"); // �
		value = value.replaceAll("&#203;", "E"); // �

		value = value.replaceAll("&#204;", "I"); // �
		value = value.replaceAll("&#205;", "I"); // �
		value = value.replaceAll("&#206;", "I"); // �

		value = value.replaceAll("&#210;", "O"); // �
		value = value.replaceAll("&#211;", "O"); // �
		value = value.replaceAll("&#212;", "O"); // �
		value = value.replaceAll("&#213;", "O"); // �

		value = value.replaceAll("&#217;", "U"); // �
		value = value.replaceAll("&#218;", "U"); // �
		value = value.replaceAll("&#219;", "U"); // �

		value = value.replaceAll("&#224;", "a"); // �
		value = value.replaceAll("&#225;", "a"); // �
		value = value.replaceAll("&#226;", "a"); // �
		value = value.replaceAll("&#227;", "a"); // �

		value = value.replaceAll("&#232;", "e"); // �
		value = value.replaceAll("&#233;", "e"); // �
		value = value.replaceAll("&#234;", "e"); // �

		value = value.replaceAll("&#236;", "i"); // �
		value = value.replaceAll("&#237;", "i"); // �
		value = value.replaceAll("&#238;", "i"); // �

		value = value.replaceAll("&#242;", "o"); // �
		value = value.replaceAll("&#243;", "o"); // �
		value = value.replaceAll("&#244;", "o"); // �
		value = value.replaceAll("&#245;", "o"); // �

		value = value.replaceAll("&#249;", "u"); // �
		value = value.replaceAll("&#250;", "u"); // �
		value = value.replaceAll("&#251;", "u"); // �

		value = value.replaceAll("&#231;", "c"); // �

		return value;

	}

}
