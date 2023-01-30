package cm.enspy.gi.project.localisation_service.filters;

import java.io.IOException; 
import java.util.List;
import java.util.stream.Collectors;

 
 
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;  
import org.springframework.web.filter.OncePerRequestFilter;

import cm.enspy.gi.project.localisation_service.config.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

 

public class JWTAuthorizationFilter extends OncePerRequestFilter {


	@Value("${app.jwt.secret}")
	private String SECRET;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		String header = request.getHeader(SecurityConstants.HEADER_STRING);

		if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
		}
		else{
		
			
			UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(request, response);
		
		}
	}

	private Claims validateToken(String jwtToken) throws ExpiredJwtException, UnsupportedJwtException,
			MalformedJwtException, SignatureException, IllegalArgumentException {

		String token = jwtToken.trim().replace(SecurityConstants.TOKEN_PREFIX, "").trim();
		return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token).getBody();
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

		String token = request.getHeader(SecurityConstants.HEADER_STRING);

		if (token != null) {
			// parse the token.
			Claims claims = validateToken(token);
			List<String> authorities = (List<String>) claims.get("authorities");

			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(),
					null,
					authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

			return auth;

		}

		return null;
	}

	//

}