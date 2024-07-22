package pl.dziadkouskaya.graphql.exception;

public class InnerGraphQlException extends RuntimeException {
    public InnerGraphQlException(String message) {
        super(message);
    }
}
