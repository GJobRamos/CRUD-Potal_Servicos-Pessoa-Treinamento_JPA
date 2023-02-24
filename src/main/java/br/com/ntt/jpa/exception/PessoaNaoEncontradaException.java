package br.com.ntt.jpa.exception;

public class PessoaNaoEncontradaException extends RuntimeException{

    public PessoaNaoEncontradaException(String message) {
        super(message);
    }
}
