package br.com.vrsoft.vrmobile.infrastructure.interceptors;

import br.com.vrsoft.vrmobile.domain.entity.VRException;
import br.com.vrsoft.vrmobile.infrastructure.controllers.dtos.DefaultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor {
    @ExceptionHandler(value = VRException.class)
    public ResponseEntity<DefaultResponse> catchVRException(VRException vrException) {
        return ResponseEntity.internalServerError().body(new DefaultResponse(vrException.getMessage(), null));
    }
}
