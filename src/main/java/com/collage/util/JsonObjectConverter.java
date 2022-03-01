package com.collage.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObjectConverter {

	
	public static String objectToJsonString(Object t) {
		
		try {
			
			return new ObjectMapper().writeValueAsString(t);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
