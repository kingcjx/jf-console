package com.atguigu.jf.console.login.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atguigu.jf.console.common.utils.VerifyCodeUtil;
import com.atguigu.jf.console.exception.LoginFailedException;
import com.atguigu.jf.console.login.service.LoginService;
import com.atguigu.jf.console.user.bean.bo.SysFuncBean;
import com.atguigu.jf.console.user.bean.pojo.SysOp;


@RequestMapping("/logincontroller/")
@Controller
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	/**
	 * 
	 * @throws IOException
	 * @方法名: getVerifyCodeImage
	 * @功能描述: 生成图片验证码
	 * @作者 cjx
	 * @日期 2016年11月5日
	 */
	@RequestMapping("getVerifyCodeImage")
	public void getVerifyCodeImage(HttpServletResponse response,
			HttpSession session) throws IOException {

		// 生成四位字符串验证码
		String textCode = VerifyCodeUtil.generateTextCode(
				VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
		session.setAttribute("testCode", textCode);
		BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(
				textCode, 100, 30, 3, true, Color.WHITE, Color.BLACK, null);
		ServletOutputStream outputStream = response.getOutputStream();
		ImageIO.write(bufferedImage, "JPEG", outputStream);
	}

	/**
	 * @方法名: login
	 * @功能描述: 进行登录验证
	 * @return
	 * @throws Exception 
	 * @作者 cjx
	 * @日期 2016年11月6日
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String userName,
			String password, String verifyCode, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		
		String textCode = (String) session.getAttribute("testCode");
		if (textCode == null || !textCode.equals(verifyCode)) {
			redirectAttributes.addFlashAttribute("errmsg", "验证码不正确");
			return "redirect:/login";
		}
		// 1、获得当前用户信息
		Subject currentUser = SecurityUtils.getSubject();
		// 2、是否经过了验证
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
			token.setRememberMe(true);
			try {
				currentUser.login(token);
				session.setAttribute("currentUser", currentUser.getPrincipal());
			} catch (AuthenticationException ae) {
				log.debug("用户名密码不匹配");
				//自定义异常返回错误信息
				throw new LoginFailedException("用户名密码不匹配！");
			}
			
		}
			return "redirect:/index";
	}
	/**
	 * 
	 * @方法名: getMenu  
	 * @功能描述: TODO(这里用一句话描述这个方法的作用)  
	 * @param session
	 * @return
	 * @throws Exception 
	 * @作者  cjx
	 * @日期 2016年11月7日
	 */
	@RequestMapping("getMenu")
	@ResponseBody
	public List<SysFuncBean> getMenu(HttpSession session) throws Exception {
		SysOp sysOp = (SysOp) session.getAttribute("currentUser");
		Long opId = sysOp.getOpId();
		List<SysFuncBean> list = loginService.getMenu(opId);
		return list;
	}
}
