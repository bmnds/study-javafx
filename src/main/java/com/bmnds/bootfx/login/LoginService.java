package com.bmnds.bootfx.login;

import org.springframework.stereotype.Component;

@Component
class LoginService {

	public boolean isLoginSuccessful(String user, String password) {
		// TODO retrieve information from the database
		return "admin".equals(user) && "123".equals(password);
	}

}
