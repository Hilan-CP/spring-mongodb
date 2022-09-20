package com.hilan.mongodbapplication.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLString {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
}
