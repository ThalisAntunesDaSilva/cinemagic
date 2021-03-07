package com.cinemagic.resources.utils;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
	
	public static List<Integer> decodeIntList(String value){
		List<Integer> ids = new ArrayList<>();
		String [] vet = value.split(",");
		for(String s : vet) {
			ids.add(Integer.parseInt(s));
		}
		return ids;
	}
	
	public static String decodeParam(String value) {
		try {
			return URLDecoder.decode(value,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
