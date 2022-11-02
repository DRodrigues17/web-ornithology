package com.br.puc.startdb.webornithology.exception;

public class NaoPermitidoException extends RuntimeException {

    public NaoPermitidoException(String message) {
        super("metodo não permitido, pois " + message);
    }

    public NaoPermitidoException(String message, Throwable cause) {
        super(message, cause);
    }
}