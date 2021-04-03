package su.common.util.converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FirstModel {

    public final String param1;
    public final String param2;

    @JsonCreator
    public FirstModel(@JsonProperty("param1") String param1,@JsonProperty("param2") String param2) {
        this.param1 = param1;
        this.param2 = param2;
    }
}
