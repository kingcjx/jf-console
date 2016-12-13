package com.atguigu.jf.console.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.jf.console.login.service.LoginService;
import com.atguigu.jf.console.user.bean.pojo.SysOp;

/**
 * 使用shiro进行登录验证
 * @包名 com.atguigu.jf.console.shiro
 * @类名 MyRleam.java
 * @作者  cjx
 * @创建日期 2016年11月14日
 * @描述 
 * @版本 V 1.0
 */
public class MyRleam extends AuthorizingRealm{

	@Autowired
	private LoginService loginService;

	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		return null;
	}

	/**
	 * 进行登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//1、将AuthenticationToken强转为UsernamePasswordToken类型
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		//2、从upToken中获取用户的信息
		Object principal = upToken.getPrincipal();
		//3、通过用户信息，从数据库中获取密码
		SysOp sysOp = new SysOp();
		sysOp.setLoginCode(principal.toString());
		try {
			sysOp = loginService.getLogin(sysOp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String credentials = sysOp.getLoginPasswd(); 
		//4、添加盐值
		ByteSource salt = ByteSource.Util.bytes(principal);
		//5、进行密码的比对
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysOp, credentials, salt, getName());
		return info;
	}
	
	
}
