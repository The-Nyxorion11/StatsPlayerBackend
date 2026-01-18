package sp.statsplayer.StatsPlayer.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
//filter
@Component
public class ApiKeyFilter  extends OncePerRequestFilter {


    private String apiHeaderName;


    private String apiKeyValue;

    public ApiKeyFilter(@Value("${api.header.name:X-API-KEY}") String apiHeaderName,
                        @Value("${api.key.value:clave_maestra_emergencia}") String apiKeyValue) {
        this.apiHeaderName = apiHeaderName;
        this.apiKeyValue = apiKeyValue;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestKey = request.getHeader(apiHeaderName);


        if (requestKey != null && requestKey.equals(apiKeyValue)) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    "ApiKeyUser",
                    null,
                    AuthorityUtils.NO_AUTHORITIES
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            filterChain.doFilter(request, response);
        }else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");

            response.getWriter().write("{\"error\": \"ERROR API KEY\"}");
        }
    }
}
