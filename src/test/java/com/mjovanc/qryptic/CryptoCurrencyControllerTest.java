package com.mjovanc.qryptic;

import com.mjovanc.qryptic.controller.CryptoCurrencyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CryptoCurrencyController.class)
@TestPropertySource(locations = "classpath:application-dev.yml")
public class CryptoCurrencyControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CryptoCurrencyController cryptoCurrencyController;

    @Test
    public void getCryptoCurrenciesTest() throws Exception {
        mvc.perform(get("/v1/cryptocurrencies")
            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getCryptoCurrencyTest() throws Exception {
        //TODO: Add mock object and see if the result is as expected

        mvc.perform(get("/v1/cryptocurrencies/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
