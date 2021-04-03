package su.common.util.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private ObjectMapper objectMapper;

    @EnableAutoConfiguration
    @SpringBootConfiguration
    @ComponentScan(basePackages = "su.common.util.converter")
    public static class TestConfig extends SpringBootServletInitializer {

    }

    @Test
    public void shouldGetRest() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MultiPartMessageConverter(objectMapper));
        final ResponseEntity<ResultModel> responseEntity = restTemplate.getForEntity("http://localhost:" + randomServerPort + "/test", ResultModel.class);
        final ResultModel resultModel = responseEntity.getBody();
        Assertions.assertNotNull(resultModel);
        Assertions.assertEquals(2, resultModel.secondModel.size());
        Assertions.assertEquals("Param1.Value", resultModel.firstModel.param1);
        Assertions.assertEquals("Param2.Value", resultModel.firstModel.param2);
    }

}
