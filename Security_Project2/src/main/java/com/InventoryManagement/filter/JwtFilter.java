package com.InventoryManagement.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.util.StringUtils;

import com.InventoryManagement.beans.User;
import com.InventoryManagement.data.UserRepo;
import com.InventoryManagement.utils.JwtUtil;


//import com.coderscampus.AssignmentSubmissionApp.util.JwtUtil;
//import com.coderscampus.proffesso.repository.ProffessoUserRepo;

//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.SignatureException;

@Component					   //validates data once
public class JwtFilter extends OncePerRequestFilter {
    
    
    //@Autowired
    //private ProffessoUserRepo proffessoUserRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
      
        // Get authorization header and validate
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        
        if (!StringUtils.hasText(header) || (StringUtils.hasText(header) && !header.startsWith("Bearer"))) {
            chain.doFilter(request, response);
            
            return;
        }

        final String token = header.split(" ")[1].trim();
        UserDetails userDetails = userRepo.findByUsername(jwtUtil.getUsernameFromToken(token)).orElse(null);
    
        if(!jwtUtil.validateToken(token, userDetails)) 
        {
        	chain.doFilter(request, response);
        	return;
        }
        
        UsernamePasswordAuthenticationToken
            authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                userDetails == null ?
                		Collections.unmodifiableList(new ArrayList<>(Arrays.asList())) : userDetails.getAuthorities()
            );

        authentication.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
        );

        // this is where the authentication magic happens and the user is now valid!
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        chain.doFilter(request, response);
        
    }
    
    
}