package br.com.vrsoft.vrmobile.infrastructure.interceptors;

import br.com.vrsoft.vrmobile.domain.entity.VRException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;


public class KeyValidationInterceptor implements HandlerInterceptor {
    private final String headerKey;

    public KeyValidationInterceptor(String headerKey) {
        this.headerKey = headerKey;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String headerValue = request.getHeader(headerKey);
        if (headerValue == null || !isValidKey(headerValue)) {
            throw new VRException("Chave inválida ou ausente.");
        }
        return true;
    }

    private boolean isValidKey(String key) {
        return key.contains("vrsoftware");
    }
}
