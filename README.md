# Resilience4j with SpringBoot 2

Simple SpringBoot microservice, with integration of Resilience4j library, to test circuit breaker fallback.

## Build microservice

`mvn clean package`

## Run microservice

```shell
java -jar target/resilience4j-0.0.1-SNAPSHOT.jar
```

## Testing API with circuit breaker

To understand the circuit breaker work, we need to execute two test, one with a valid external service URL
in order to obtain a HTTP response `200 OK`, and another with not valid service URL
in order to obtain a HTTP response `404 NOT_FOUNT` and do open the circuit.

### Test 01 - Valid external service

```shell
curl "http://localhost:8080/cookies?number=21" | jq
```

As expected result will you obtain:

```json
{
  "data": null,
  "message": "<The google HTML page>",
  "success": true
}
```

### Test 02 - Not valid external service

Update [application.yml](/src/main/resources/application.yml) file, remove comment on property `external.service.url`
and comment the actual active properties.

```shell
curl "http://localhost:8080/cookies?number=21" | jq
```

As expected result will you obtain:

```json
{
  "data": null,
  "message": "Something went wrong: I/O error on GET request for \"https://www.test-cicuitbraker.fallback\": www.test-cicuitbraker.fallback; nested exception is java.net.UnknownHostException: www.test-cicuitbraker.fallback I'cant give you 21 cookies",
  "success": false
}
```

### Reference Documentation

For further reference, please consider the following sections:

* [Spring Web](https://docs.spring.io/spring-boot/3.4.1/reference/web/servlet.html)
* [Resilience4j](https://resilience4j.readme.io/docs/getting-started)
* [spring-boot-resilience4j](https://www.baeldung.com/spring-boot-resilience4j)