package api;

import io.restassured.response.Response;
import pojo.Pet;

public class PetApi {

    public static Response post(Pet pet) {
        return RestResource.post(Route.BASE_URL + Route.PETS, pet);
    }

    public static Response get(Long petId) {
        return RestResource.get(Route.BASE_URL + Route.PETS + "/" + petId);
    }

    public static void delete(Long petId) {
        RestResource.delete(Route.BASE_URL + Route.PETS + "/" + petId);
    }
}
