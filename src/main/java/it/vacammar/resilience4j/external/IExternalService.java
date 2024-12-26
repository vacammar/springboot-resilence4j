package it.vacammar.resilience4j.external;

import it.vacammar.resilience4j.dto.ApiResponse;

public interface IExternalService {

    /**
     * Call external service.
     *
     * @param number: number of cookies you want
     * @return
     */
    ApiResponse<String> getCookieFromBakery(int number);
}
