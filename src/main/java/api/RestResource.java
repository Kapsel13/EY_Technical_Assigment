package api;

import io.restassured.response.Response;
import pojo.Pet;

import static io.restassured.RestAssured.given;

public class RestResource {
    public static Response post(String path, Pet pet) {
        return given(SpecBuilder.getRequestSpec()).
                                                          body(pet).
                                                          when().
                                                          post(path).
                                                          then().
                                                          spec(SpecBuilder.getResponseSpec()).
                                                          extract().
                                                          response();
    }

    public static Response get(String path) {
        return given(SpecBuilder.getRequestSpec()).
                                                          when().
                                                          get(path).
                                                          then().
                                                          spec(SpecBuilder.getResponseSpec()).
                                                          extract().
                                                          response();
    }

    public static void delete(String path) {
        given(SpecBuilder.getRequestSpec()).
                                                   when().
                                                   delete(path).
                                                   then().
                                                   spec(SpecBuilder.getResponseSpec());
    }

}
