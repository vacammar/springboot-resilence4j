package it.vacammar.resilience4j.external;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import it.vacammar.resilience4j.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalServiceImpl implements IExternalService {

    private final RestTemplate restTemplate;

    @Value("${external.service.url}")
    private String externalServiceUrl;

    @Autowired
    public ExternalServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "ExternalService", fallbackMethod = "callExternalServiceFallback")
    public ApiResponse<String> getCookieFromBakery(int number) {
        return ApiResponse.Builder.anApiResponse()
                .withData(restTemplate.getForObject(this.externalServiceUrl, String.class))
                .withMessage("External service call completed")
                .withSuccess(true)
                .build();
    }

    public ApiResponse<String> callExternalServiceFallback(int number, Exception e) {
        return ApiResponse.Builder.anApiResponse()
                .withMessage(String.format("Something went wrong: %s I'cant give you %s cookies", e.getMessage(), number))
                .withSuccess(false)
                .build();
    }
}
