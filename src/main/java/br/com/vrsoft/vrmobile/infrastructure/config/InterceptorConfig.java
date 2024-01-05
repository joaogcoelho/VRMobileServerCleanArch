package br.com.vrsoft.vrmobile.infrastructure.config;

import br.com.vrsoft.vrmobile.infrastructure.interceptors.KeyValidationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new KeyValidationInterceptor("chave"));
    }
}
