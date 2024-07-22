package pl.dziadkouskaya.graphql.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dziadkouskaya.graphql.codegen.types.CreateProductPayload;
import pl.dziadkouskaya.graphql.service.PayloadService;

import java.util.UUID;

import static pl.dziadkouskaya.graphql.utils.Constants.POSITIVE_PAYLOAD_CODE;
import static pl.dziadkouskaya.graphql.utils.Constants.POSITIVE_PAYLOAD_MESSAGE;

@Slf4j
@Service
public class PayloadServiceImpl implements PayloadService {
    @Override
    public CreateProductPayload createCreateProductPayload(UUID id) {
        CreateProductPayload payload = new CreateProductPayload();
        payload.setCode(POSITIVE_PAYLOAD_CODE);
        payload.setProductId(id.toString());
        payload.setMessage(POSITIVE_PAYLOAD_MESSAGE);
        payload.setSuccess(true);
        return payload;
    }

}
