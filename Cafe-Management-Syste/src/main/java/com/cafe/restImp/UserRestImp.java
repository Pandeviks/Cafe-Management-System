package com.cafe.restImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.Constant.CafeConstant;
import com.cafe.rest.UserRest;
import com.cafe.service.UserService;
import com.cafe.util.CafeUtility;

@RestController
public class UserRestImp implements UserRest {
	@Autowired
	UserService userService;

	@Override
	public ResponseEntity<String> signup(Map<String, String> requestMap) {
		try {
			return userService.singUp(requestMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtility.getResponseEntity(CafeConstant.SOMTHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
