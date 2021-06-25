package ru.sergey_gusarov.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Log4j
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
class EchoControllerTest {
    public static final String PROTOCOL_HOST_PORT = "https://localhost:";
    public static final String UTF_8 = "UTF-8";

    @LocalServerPort
    private Integer localPort;

    @Autowired
    private MockMvc mvc;

    private String getRequestJson(Object req) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(req);
    }

    @Test
    void postController() throws Exception {
        Map testMap = new HashMap();
        testMap.put("a", "b");
        testMap.put("1", "2");

        String requestJson = getRequestJson(testMap);

        MvcResult result = mvc.perform(post(PROTOCOL_HOST_PORT + localPort + "/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        Charset charset = Charset.forName(UTF_8);
        assertTrue(result.getResponse()
                 .getContentAsString(charset)
                 .equalsIgnoreCase("Request is: POST, IP: 127.0.0.1, request: {a=b, 1=2}")
        );
    }
}
