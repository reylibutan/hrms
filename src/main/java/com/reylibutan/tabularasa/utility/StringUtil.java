package com.reylibutan.tabularasa.utility;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class StringUtil {

	public static String hashString(String str) {
		return BCrypt.hashpw(str, BCrypt.gensalt());
	}
}