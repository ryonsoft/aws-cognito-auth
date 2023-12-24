package com.main.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

//import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AppController {
	@Autowired
	//// private HttpServletRequest request;

	@GetMapping("/")
	public String index(@AuthenticationPrincipal OAuth2User user) {
		return "Hello, " + user.getAttribute("username");
	}

	@GetMapping("/home")
	public RedirectView home() {
		// String currentURL = request.getRequestURL().toString();
		// String domain = getDomainFromURL(currentURL);
		// System.out.println(domain);
		String redirectUrl = "https://tiennv2-azure-user-pool.auth.ap-northeast-1.amazoncognito.com/oauth2/authorize?identity_provider=tiennv2-azure-idp&redirect_uri=http://localhost:8080/login/oauth2/code/cognito&response_type=CODE&client_id=1vq8nujnlstvkcldpbomgqsc77&scope=email openid profile";
		return new RedirectView(redirectUrl);
	}

	@GetMapping("/error")
	public String error() {
		return "Access denied. Not enough permission.";
	}

	public String getErrorPath() {
		return error();
	}

	// Phương thức để lấy domain từ URL
	// private String getDomainFromURL(String url) {
	// String domain = null;
	// try {
	// URL parsedURL = new URL(url);
	// domain = parsedURL.getProtocol() + "://" + parsedURL.getHost() + ":" +
	// parsedURL.getPort();
	// } catch (MalformedURLException e) {
	// e.printStackTrace();
	// }
	// return domain;
	// }
}