package apiHelper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Paths;


import static apiHelper.ScenarioContext.ContextType.HTTP_REQUEST_SPECIFICATION;
import static apiHelper.ScenarioContext.ContextType.HTTP_RESPONSE;
import static apiHelper.ScenarioContext.getContext;
import static apiHelper.ScenarioContext.setContext;
import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static io.restassured.http.ContentType.*;
import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
public class RestAssuredHelper {

    public static void getRequest(@NonNull String endPoint) {
        RequestSpecification reqSpec = getContext(HTTP_REQUEST_SPECIFICATION);
        Response response = given()
                .spec(reqSpec)
                .when()
                .get(endPoint);
        log.info("Response body if GET request is: " + response.body().prettyPrint());
        setContext(HTTP_RESPONSE,response);
    }

    public static void setupRequestSpecification(@NonNull String url, String contentType) {
        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri(url)
                .setConfig(config().encoderConfig(encoderConfig().defaultContentCharset(UTF_8)))
                .setContentType(getContentTypeByString(contentType))
                .setUrlEncodingEnabled(false)
                .setAccept(getContentTypeByString(contentType))
                .log(LogDetail.ALL)
                .build();
        setContext(HTTP_REQUEST_SPECIFICATION,reqSpec);
    }

    private static ContentType getContentTypeByString(String contentType) {
        ContentType type = null;
        switch (contentType) {
            case "json":
                type = JSON;
                break;
            case "xml":
                type = XML;
                break;
            case "text":
                type = TEXT;
                break;
            case "html":
                type = HTML;
                break;
            default:
                log.info("Unknown content type!");
        }
        return type;
    }

    @SneakyThrows
    private static String readFileAsString(String file) {
        return new String(Files.readAllBytes(Paths.get(file)))
                .replace("\r", "").replaceAll(" +", " ");
    }

}
