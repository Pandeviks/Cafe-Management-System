package com.cafe.serviceImpl;

import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cafe.Constant.CafeConstant;
import com.cafe.dao.UserDao;
import com.cafe.pojo.User;
import com.cafe.service.UserService;
import com.cafe.util.CafeUtility;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Log4j
@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserDao userDao;
Logger log ;
	@Override
	public ResponseEntity<String> singUp(Map<String, String> requestMap) {
		log.info("Inside singup {}", requestMap);
	
		try {
		if (validateUSer(requestMap)) {
			User user = userDao.findByEmailId(requestMap.get("email"));
			if (Objects.isNull(user)) {
				userDao.save(getDataFromMAp(requestMap));
			CafeUtility.getResponseEntity("Successfully Register",HttpStatus.OK);

			} else {
				return CafeUtility.getResponseEntity(CafeConstant.USER_ALREDY_EXIST, HttpStatus.BAD_REQUEST);
			}

		} else

		{
			return CafeUtility.getResponseEntity(CafeConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CafeUtility.getResponseEntity(CafeConstant.SOMTHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private boolean validateUSer(Map<String, String> requestMap) {
		if(requestMap.containsKey("name") && requestMap.containsKey("ContactNumber") && requestMap.containsKey("email") && requestMap.containsKey("Password")){
			
			return true;
	}
		return false;

}

	private User getDataFromMAp(Map<String, String> requestMap) {
		User user = new User();
		user.setName(requestMap.get("name"));
		user.setContactNumber(requestMap.get("contactNumber"));
		user.setEmail(requestMap.get("email"));
		user.setPassword(requestMap.get("password"));
		user.setStatus("false");
		user.setRole("user");
		return user;
	}
}
