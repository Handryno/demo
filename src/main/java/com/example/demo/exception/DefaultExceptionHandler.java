package com.example.demo.exception;

import com.example.demo.dto.ResponseService;
import com.example.demo.util.Constants;
import com.example.demo.util.ResponseUtil;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketTimeoutException;

@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class, RuntimeException.class, ResourceAccessException.class,
            SSLHandshakeException.class})
    public ResponseEntity<ResponseService> defaultErrorHandler(HttpServletRequest request, Exception e) {
        log.error(e.getClass() + " : " + e.getMessage() + " - Error service for request - " + request.getRequestURL(), e);
        ResponseService response = ResponseUtil.setResponse(Constants.RESPONSE.HTTP_INTERNAL_ERROR, e.getClass() + " : " + e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(value = {RetryableException.class, SSLProtocolException.class, SocketTimeoutException.class})
    public ResponseEntity<ResponseService> timeoutErrorHandler(Exception e) {
        log.warn(e.getClass() + " : " + e.getMessage(), e);
        ResponseService response = ResponseUtil.setResponse(Constants.RESPONSE.TRANSACTION_TIMEOUT,
                e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(value = {InvocationTargetException.class})
    public ResponseEntity<ResponseService> invocationTargetExceptionHandler(InvocationTargetException e) {
        log.warn(e.getClass() + " : " + e.getTargetException().getMessage() + " - " + e.getMessage(), e);
        ResponseService response = ResponseUtil.setResponse(Constants.RESPONSE.HTTP_INTERNAL_ERROR,
                e.getTargetException().getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(value = { WrongFormatException.class })
    public ResponseEntity<ResponseService> wrongFormatException(WrongFormatException e) {
        log.warn(e.getClass() + " : " + e.getMessage());
        return new ResponseEntity<>(ResponseUtil.setResponse(Constants.RESPONSE.WRONG_FORMAT_DATA, e.getMessage(), null), HttpStatus.OK);
    }

    @ExceptionHandler(value = { AuthenticationException.class })
    public ResponseEntity<ResponseService> authenticationException(AuthenticationException e) {
        log.warn(e.getClass() + " : " + e.getMessage());
        return new ResponseEntity<>(ResponseUtil.setResponse(Constants.RESPONSE.AUTHENTICATION_PROBLEM, e.getMessage(), null), HttpStatus.OK);
    }

    @ExceptionHandler(value = { BodyNotFoundException.class })
    public ResponseEntity<ResponseService> responseBodyNotFoundException(BodyNotFoundException e) {
        log.warn(e.getClass() + " : " + e.getMessage());
        return new ResponseEntity<>(ResponseUtil.setResponse(Constants.RESPONSE.HTTP_BODY_NOT_FOUND, e.getMessage(), null), HttpStatus.OK);
    }

}
