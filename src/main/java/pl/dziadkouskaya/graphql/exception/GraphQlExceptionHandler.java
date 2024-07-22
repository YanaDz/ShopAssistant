package pl.dziadkouskaya.graphql.exception;

import com.netflix.graphql.types.errors.ErrorType;
import com.netflix.graphql.types.errors.TypedGraphQLError;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.DataFetcherExceptionHandlerResult;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.netflix.graphql.types.errors.ErrorType.INTERNAL;
import static com.netflix.graphql.types.errors.ErrorType.NOT_FOUND;
import static java.util.Objects.nonNull;
import static pl.dziadkouskaya.graphql.utils.Constants.ERROR_SERVER_INTERNAL;
import static pl.dziadkouskaya.graphql.utils.Constants.RESOURCE_NOT_FOUND;

@ControllerAdvice
public class GraphQlExceptionHandler implements DataFetcherExceptionHandler {

    @Override
    public CompletableFuture<DataFetcherExceptionHandlerResult> handleException(DataFetcherExceptionHandlerParameters handlerParameters) {
        DataFetcherExceptionHandlerResult result =
                switch (handlerParameters.getException()) {
                    case ResourceNotFoundException ex -> createDataFetcherExceptionHandlerResult(handlerParameters,
                            NOT_FOUND, RESOURCE_NOT_FOUND);
                    case RuntimeException ex -> createDataFetcherExceptionHandlerResult(handlerParameters,
                            INTERNAL, ERROR_SERVER_INTERNAL);
                    default -> null;
                };

        return nonNull(result)
                ? CompletableFuture.completedFuture(result)
                : null;
    }

    private DataFetcherExceptionHandlerResult createDataFetcherExceptionHandlerResult(
            DataFetcherExceptionHandlerParameters handlerParameters, ErrorType errorType, String errorMessage) {
        Map<String, Object> debugInfo = new HashMap<>();

        var graphqlError = TypedGraphQLError.newInternalErrorBuilder()
                .errorType(errorType)
                .message(errorMessage)
                .path(handlerParameters.getPath())
                .location(handlerParameters.getDataFetchingEnvironment().getField().getSourceLocation())
                .build();

        DataFetcherExceptionHandlerResult result = DataFetcherExceptionHandlerResult.newResult()
                .error(graphqlError)
                .build();

        return result;
    }

}
