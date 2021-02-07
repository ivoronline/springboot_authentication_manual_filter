package com.ivoronline.springboot_authentication_manual_filter.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MyFilter implements Filter {

  @Autowired MyAuthenticationManager myAuthenticationManager;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
    throws IOException, ServletException {

    //GET CREDENTIALS
    String enteredUsername = request.getParameter("enteredUsername");
    String enteredPassword = request.getParameter("enteredPassword");

    //AUTHENTICATE
    Authentication enteredAuth = new UsernamePasswordAuthenticationToken(enteredUsername, enteredPassword);
    Authentication returnedAuth = myAuthenticationManager.authenticate(enteredAuth);

    //STORE AUTHENTICATION INTO CONTEXT (SESSION)
    SecurityContextHolder.getContext().setAuthentication(returnedAuth);

    //FORWARD REQUEST
    filterchain.doFilter(request, response);

  }

}
