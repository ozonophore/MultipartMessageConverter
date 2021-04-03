package su.common.util.converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SecondModel {

    public final String param3;
    public final String param4;

    @JsonCreator
    public SecondModel(@JsonProperty("param3") String param3,@JsonProperty("param4") String param4) {
        this.param3 = param3;
        this.param4 = param4;
    }
}
