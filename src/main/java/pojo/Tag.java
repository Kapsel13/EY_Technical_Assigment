package pojo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;


@Value
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tag {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("name")
    String name;
}
