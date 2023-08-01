package com.c4ccup.laugh.zzerr;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.c4ccup.laugh.zzerr.bean.ValidationErrBean;

@ControllerAdvice
public class ApiExceptionHandler {

    /**
     * バリデーションエラーを返却する
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ValidationErrBean> handleError(BindException e) throws Exception {
        Map<String, String> err = new HashMap<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            err.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(new ValidationErrBean(err), HttpStatus.BAD_REQUEST);
    }
}
