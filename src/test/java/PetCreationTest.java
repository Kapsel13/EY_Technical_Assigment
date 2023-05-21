import api.PetApi;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pojo.Pet;
import utils.FakerUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PetCreationTest {

    private Long petId;
    private final String petName = FakerUtils.generateName();
    private final String[] petPhotoUrls = FakerUtils.generateUrls();

    @Test
    public void verifyPetCreation() {
        Pet pet = petBuilder(petName, petPhotoUrls);
        Response response = PetApi.post(pet);
        final int STATUS_CODE_200 = 200;
        assertThat(response.statusCode(), equalTo(STATUS_CODE_200));
        petId = response.as(Pet.class).getId();
        Response getResponse = PetApi.get(petId);
        assertThat(getResponse.statusCode(), equalTo(STATUS_CODE_200));
        Pet createdPet = getResponse.as(Pet.class);
        verifyPetWasCreated(createdPet);
    }

    public Pet petBuilder(String name, String[] photoUrls) {
        return Pet.builder().
                name(name).
                          photoUrls(photoUrls).
                          build();

    }

    public void verifyPetWasCreated(Pet createdPet) {
        assertThat(createdPet.getName(), equalTo(petName));
        assertThat(createdPet.getPhotoUrls(), equalTo(petPhotoUrls));
    }

    @AfterClass
    public void deletePet() {
        PetApi.delete(petId);
    }

}
