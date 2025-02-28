package com.example.internbankingtask.globalExceptionHandler;

import com.example.internbankingtask.globalExceptionHandler.exceptions.EmailAlreadyExists;
import com.example.internbankingtask.globalExceptionHandler.exceptions.IllegalArgumentException;
import com.example.internbankingtask.globalExceptionHandler.exceptions.InsufficientFunds;
import com.example.internbankingtask.globalExceptionHandler.exceptions.InvalidOtp;
import com.example.internbankingtask.globalExceptionHandler.exceptions.NotFoundException;
import com.example.internbankingtask.model.dto.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class HandleException {

    @ExceptionHandler(EmailAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionDto handleEmailAlreadyExists(EmailAlreadyExists e) {
        log.error("ActionLog error " + e.getMessage());
        return new ExceptionDto(e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handleNotFoundException(NotFoundException e) {
        log.error("ActionLog error " + e.getMessage());
        return new ExceptionDto(e.getMessage());
    }

    @ExceptionHandler(InvalidOtp.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionDto handleInvalidOtp(InvalidOtp e) {
        log.error("ActionLog error " + e.getMessage());
        return new ExceptionDto(e.getMessage());
    }

    @ExceptionHandler(InsufficientFunds.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handleInsufficientFunds(InsufficientFunds e) {
        log.error("ActionLog error " + e.getMessage());
        return new ExceptionDto(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("ActionLog error " + e.getMessage());
        return new ExceptionDto(e.getMessage());
    }

}
