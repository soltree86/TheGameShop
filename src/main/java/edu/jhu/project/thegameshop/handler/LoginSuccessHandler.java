package edu.jhu.project.thegameshop.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	private static final Logger LOG = Logger.getLogger(LoginSuccessHandler.class);
			
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
		super.onAuthenticationSuccess(request, response, authentication);
		
		HttpSession session = request.getSession();

		
		String username = authentication.getName();
		String role = "";
		
		for(GrantedAuthority g :authentication.getAuthorities()) {
			role = g.getAuthority();
		}
		
		session.setAttribute("username", username);
		session.setAttribute("role", role);
		
		LOG.info("Logged in as Username : " + username + " Role : " + role);
	}
}
