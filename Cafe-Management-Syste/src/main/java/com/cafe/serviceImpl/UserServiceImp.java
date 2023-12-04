package com.cafe.serviceImpl;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cafe.Constant.CafeConstant;
import com.cafe.service.UserService;
import com.cafe.util.CafeUtility;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImp implements UserService {

	@Override
	public ResponseEntity<String> singUp(Map<String, String> requestMap) {
		//log.info("Inside singup {}",  requestMap);
		if(validateUSer(requestMap)) {
			
		}else {
			CafeUtility.getResponseEntity(CafeConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
		}

	}

	private boolean validateUSer(Map<String, String> requestMap) {
		if(requestMap.containsKey("name") && requestMap.containsKey("ContactNumber") && requestMap.containsKey("email") && requestMap.containsKey("Password")){
			
			return true;
	}

}
