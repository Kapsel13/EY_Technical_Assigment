import api.PetApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.Pet;
import static utils.FakerUtils.generateName;
import static utils.FakerUtils.generateUrls;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PetCreationTest {

    private static final int STATUS_CODE_200 = 200;

    @Test
    public void verifyPetCreation() {
        String petName = generateName();
        String[] petPhotoUrls = generateUrls();

        Pet pet = petBuilder(petName, petPhotoUrls);
        Response response = PetApi.post(pet);
        assertThat(response.statusCode(), equalTo(STATUS_CODE_200));
        Long petId = response.as(Pet.class).getId();

        try{
            Response getResponse = PetApi.get(petId);
            assertThat(getResponse.statusCode(), equalTo(STATUS_CODE_200));
            Pet createdPet = getResponse.as(Pet.class);
            verifyCreatedPetAttributesMatchExpected(createdPet, petName, petPhotoUrls);
        } finally {
            PetApi.delete(petId);
        }

    }

    public Pet petBuilder(String name, String[] photoUrls) {
        return Pet.builder().
                name(name).
                          photoUrls(photoUrls).
                          build();

    }

    public void verifyCreatedPetAttributesMatchExpected(Pet createdPet, String petName, String[] petPhotoUrls) {
        assertThat(createdPet.getName(), equalTo(petName));
        assertThat(createdPet.getPhotoUrls(), equalTo(petPhotoUrls));
    }

}
