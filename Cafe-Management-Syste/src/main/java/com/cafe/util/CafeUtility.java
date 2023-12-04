package com.cafe.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CafeUtility {
	private CafeUtility() {

	}

	public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus status) {
		return new ResponseEntity<String>("{\"message\":\" "+ responseMessage + "\"}", status);
	}

}
