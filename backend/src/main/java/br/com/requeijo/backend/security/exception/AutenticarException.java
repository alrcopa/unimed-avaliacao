package br.com.requeijo.backend.security.exception;

import org.springframework.security.core.AuthenticationException;

public class AutenticarException extends AuthenticationException {
    public AutenticarException(String msg) {
        super(msg);
    }
}
