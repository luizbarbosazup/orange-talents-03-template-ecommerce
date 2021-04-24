package br.com.zupacademy.Mercadolivre.handleerros;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiErrosHandle {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroResponse> errosValidacao(MethodArgumentNotValidException ex){

        List<FieldError> listaDeErros = ex.getBindingResult().getFieldErrors();
        List<ErroResponse> listaDeErrosReponse = new ArrayList<>();

        listaDeErros.forEach(erro-> listaDeErrosReponse
                .add(new ErroResponse(erro.getField(),erro.getDefaultMessage())));

        return listaDeErrosReponse;

    }

}
