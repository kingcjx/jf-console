package com.atguigu.jf.console.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class ShiroCodeCreate {

	public static void main(String[] args) {
		Object createCode = createCode();
		System.out.println(createCode);
	}
	
	public static Object createCode() {
		String algorithmName = 	"MD5";
		Object credentials = "123456";
		ByteSource salt = ByteSource.Util.bytes("admin");
		//Object salt = "user";
		int iterations = 1024;
		Object str = 	new SimpleHash(algorithmName, credentials, salt, iterations);
		return str;
	}
}
