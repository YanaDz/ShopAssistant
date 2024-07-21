package pl.dziadkouskaya.graphql.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dziadkouskaya.graphql.codegen.types.CreateProductPayload;
import pl.dziadkouskaya.graphql.entity.Product;
import pl.dziadkouskaya.graphql.service.PayloadService;

import java.util.UUID;

import static pl.dziadkouskaya.graphql.utils.Constants.*;

@Slf4j
@Service
public class PayloadServiceImpl implements PayloadService {
    @Override
    public CreateProductPayload createCreateProductPayload(UUID id, boolean idSuccess, Exception ... exception) {
        CreateProductPayload payload = new CreateProductPayload();
        if (idSuccess) {
            payload.setCode(POSITIVE_PAYLOAD_CODE);
            payload.setProductId(id.toString());
            payload.setMessage(POSITIVE_PAYLOAD_MESSAGE);
            payload.setSuccess(idSuccess);
        } else {
            payload.setCode(NEGATIVE_PAYLOAD_CODE);
            payload.setProductId(null);
            var message = exception.length == 0
                    ? NEGATIVE_PAYLOAD_MESSAGE
                    : exception[0].getMessage();
            payload.setMessage(message);
            payload.setSuccess(idSuccess);
        }

        return payload;
    }

}
