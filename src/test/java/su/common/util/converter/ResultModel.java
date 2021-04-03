package su.common.util.converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultModel {

    public final FirstModel firstModel;
    public final List<SecondModel> secondModel;

    @JsonCreator
    public ResultModel(@JsonProperty("firstModel") FirstModel firstModel, @JsonProperty("secondModel") List<SecondModel> secondModel) {
        this.firstModel = firstModel;
        this.secondModel = secondModel;
    }
}
