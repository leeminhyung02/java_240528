package kr.kh.final_project.config;

import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FailureHandler extends SimpleUrlAuthenticationFailureHandler {
	

	
	@Override
	    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
	                                        AuthenticationException exception) throws IOException, ServletException {

	        String errorMessage;
	        if (exception instanceof BadCredentialsException) {
	            errorMessage = "아이디 또는 비밀번호가 맞지 않습니다. 다시 확인해 주세요.";
	        } else if (exception instanceof InternalAuthenticationServiceException) {
	            errorMessage = "계정이 정지상태입니다.";
	        } else if (exception instanceof UsernameNotFoundException) {
	            errorMessage = "계정이 존재하지 않습니다. 회원가입 진행 후 로그인 해주세요.";
	        } else if (exception instanceof AuthenticationCredentialsNotFoundException) {
	            errorMessage = "인증 요청이 거부되었습니다. 관리자에게 문의하세요.";
	        } else if (exception instanceof DisabledException) {
	      	errorMessage = "계정이 정지상태입니다.";
	        } else {
	            errorMessage = "알 수 없는 이유로 로그인에 실패하였습니다 관리자에게 문의하세요.";
	        }

	        errorMessage = URLEncoder.encode(errorMessage, "UTF-8");
	        setDefaultFailureUrl("/user/login?error=true&exception=" + errorMessage);

	        super.onAuthenticationFailure(request, response, exception);
	    }


	}