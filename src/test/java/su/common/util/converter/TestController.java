package su.common.util.converter;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class TestController {

    @GetMapping(value = "/test", produces = "multipart/form-data")
    public ResponseEntity<MultiValueMap<String, Object>> test() {
        final MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("firstModel", new FirstModel("Param1.Value", "Param2.Value"));
        map.add("secondModel", new SecondModel("Param3.Value", "Param4.Value"));
        map.add("secondModel", new SecondModel("Param31.Value", "Param41.Value"));
        return ResponseEntity.ok().contentType(MediaType.MULTIPART_FORM_DATA).body(map);
    }

}
