package com.payment.controller.system;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.payment.common.Const;
import com.payment.common.model.Qx;
import com.payment.controller.base.BaseController;
import com.payment.dto.User;
import com.payment.model.SysUser;
import com.payment.service.menu.IMenuSV;
import com.payment.service.role.IRoleSV;
import com.payment.service.user.IUserSV;
import com.payment.util.AppUtil;
import com.payment.util.DateUtil;
import com.payment.util.PageData;
import com.payment.util.Tools;

@Controller  
@RequestMapping("/login")  
public class LoginController  extends BaseController  {
	private static final Logger log = LoggerFactory
			.getLogger(LoginController.class);
	@Autowired
	private IMenuSV menuSV;
	@Autowired
	private IUserSV userSV;
	@Autowired
	private IRoleSV roleSV;
	
	@RequestMapping("/index")  
    public String index(HttpServletRequest request,Model model){  
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("SYSNAME", Tools.readTxtFile(Const.SYSNAME)); //读取系统名称
		model.addAttribute("pd",pd);
        return "system/admin/login";  
    }
	
	/**
	 * 请求登录，验证用户
	 */
	@RequestMapping(value="/checkLogin" ,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object login()throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		PageData pd = new PageData();
		pd = this.getPageData();
		String errInfo = "";
		String KEYDATA[] = pd.getString("KEYDATA").split(",fh,");
		
		if(null != KEYDATA && KEYDATA.length == 3){
			//shiro管理的session
			Subject currentUser = SecurityUtils.getSubject();  
			Session session = currentUser.getSession();
			String sessionCode = (String)session.getAttribute(Const.SESSION_SECURITY_CODE);		//获取session中的验证码
			
			String code = KEYDATA[2];
			if(null == code || "".equals(code)){
				errInfo = "nullcode"; //验证码为空
			}else{
				String USERNAME = KEYDATA[0];
				String PASSWORD  = KEYDATA[1];
				pd.put("USERNAME", USERNAME);
				if(Tools.notEmpty(sessionCode) && sessionCode.equalsIgnoreCase(code)){
					String passwd = new SimpleHash("SHA-1", USERNAME, PASSWORD).toString();	//密码加密
					pd.put("PASSWORD", passwd);
					SysUser sysUser = userSV.getUserByAccountAndPwd(USERNAME, passwd);
					if(sysUser != null){
						pd.put("LAST_LOGIN",DateUtil.getTime().toString());
						userSV.updateLastLogin(sysUser.getUserId(),DateUtil.getTime().toString());
						User user = new User();
						user.setUSER_ID(sysUser.getUserId());
						user.setUSERNAME(sysUser.getUsername());
						user.setPASSWORD(sysUser.getPassword());
						user.setNAME(sysUser.getName());
						user.setRIGHTS(sysUser.getRights());
						user.setROLE_ID(sysUser.getRoleId());
						user.setLAST_LOGIN(sysUser.getLastLogin());
						user.setIP(sysUser.getIp());
						user.setSTATUS(sysUser.getStatus());
						user.setShopId(sysUser.getShopId());
						user.setOrgId(sysUser.getOrgId());
						session.setAttribute(Const.SESSION_USER, user);
						session.removeAttribute(Const.SESSION_SECURITY_CODE);
						session.setAttribute(Const.SESSION_QX, new Qx(sysUser.getRoleId(),roleSV.getById(sysUser.getRoleId()).getType()));
						//shiro加入身份验证
						Subject subject = SecurityUtils.getSubject(); 
					    UsernamePasswordToken token = new UsernamePasswordToken(USERNAME, PASSWORD); 
					    try { 
					        subject.login(token); 
					    } catch (AuthenticationException e) { 
					    	errInfo = "身份验证失败！";
					    }
					    
					}else{
						errInfo = "usererror"; 				//用户名或密码有误
					}
				}else{
					errInfo = "codeerror";				 	//验证码输入有误
				}
				if(Tools.isEmpty(errInfo)){
					errInfo = "success";					//验证成功
				}
			}
		}else{
			errInfo = "error";	//缺少参数
		}
		map.put("result", errInfo);
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**
	 * 用户注销
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout")
	public ModelAndView logout(){
		ModelAndView mv = this.getModelAndView("redirect: ../index.jsp");
		PageData pd = new PageData();
		
		//shiro管理的session
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		
		session.removeAttribute(Const.SESSION_USER);
		session.removeAttribute(Const.SESSION_ROLE_RIGHTS);
		session.removeAttribute(Const.SESSION_allmenuList);
		session.removeAttribute(Const.SESSION_menuList);
		session.removeAttribute(Const.SESSION_QX);
		session.removeAttribute(Const.SESSION_userpds);
		session.removeAttribute(Const.SESSION_USERNAME);
		session.removeAttribute(Const.SESSION_USERROL);
		session.removeAttribute("changeMenu");
		
		//shiro销毁登录
		Subject subject = SecurityUtils.getSubject(); 
		subject.logout();
		
		pd = this.getPageData();
		String  msg = pd.getString("msg");
		pd.put("msg", msg);
		
		pd.put("SYSNAME", Tools.readTxtFile(Const.SYSNAME)); //读取系统名称
		//mv.setViewName("system/admin/login");
		mv.addObject("pd",pd);
		return mv;
	}
}
