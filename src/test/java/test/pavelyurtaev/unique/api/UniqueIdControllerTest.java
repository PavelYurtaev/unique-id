package test.pavelyurtaev.unique.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import test.pavelyurtaev.unique.api.dto.UniqueIdDto;

import static org.junit.Assert.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UniqueIdControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void isUniqueSequentialTest() throws Exception {
        final UniqueIdDto response1 = mapper.readValue(getHttpGetResultAsString("/id"), UniqueIdDto.class);
        final UniqueIdDto response2 = mapper.readValue(getHttpGetResultAsString("/id"), UniqueIdDto.class);
        assertNotEquals(response1.getId(), response2.getId());
    }

    private String getHttpGetResultAsString(final String uri) throws Exception {
        return mvc.perform(get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

}