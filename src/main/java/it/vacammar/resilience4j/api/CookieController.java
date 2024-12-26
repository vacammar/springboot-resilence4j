package it.vacammar.resilience4j.api;

import it.vacammar.resilience4j.dto.ApiResponse;
import it.vacammar.resilience4j.external.IExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookies")
public class CookieController {

    private final IExternalService externalService;

    @Autowired
    public CookieController(IExternalService externalService) {
        this.externalService = externalService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<String>> getCookie(@RequestParam("number") int number) {
        return ResponseEntity.ok(this.externalService.getCookieFromBakery(number));
    }
}
