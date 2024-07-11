package br.eng.jonnes.core.domain.exception;

public class FriendNotFoundException extends RuntimeException {

    public FriendNotFoundException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
