package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pet {
    @JsonProperty("id")
    Long id;
    @JsonProperty("category")
    Category category;
    @JsonProperty("name")
    String name;
    @JsonProperty("photoUrls")
    String[] photoUrls;
    @JsonProperty("tags")
    Tag[] tags;
    @JsonProperty("status")
    String status;
}
