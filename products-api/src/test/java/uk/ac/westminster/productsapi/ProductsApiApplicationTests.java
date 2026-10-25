package uk.ac.westminster.productsapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class ProductsApiApplicationTests {
    @Autowired
    private MockMvc mvc;

    @Test
    void helloAndGoodbyeWork() throws Exception {
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello from Spring Boot!"));
        mvc.perform(get("/goodbye"))
                .andExpect(status().isOk())
                .andExpect(content().string("Goodbye from Spring Boot!"));
    }

    @Test
    void customerHasNestedAddress() throws Exception {
        mvc.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ada Lovelace"))
                .andExpect(jsonPath("$.address.city").value("London"));
    }

    @Test
    void seedsTwoDifferentProductTypes() throws Exception {
        mvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].downloadUrl").value("/downloads/clean-code.pdf"))
                .andExpect(jsonPath("$[1].weightKg").value(5.4));
    }

    @Test
    void postAcceptsPlainProduct() throws Exception {
        mvc.perform(post("/products").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Laptop\",\"price\":899.99}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    void postAcceptsDigitalProduct() throws Exception {
        mvc.perform(post("/products").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Video Course\",\"price\":15.0,\"downloadUrl\":\"/downloads/course.zip\",\"fileSizeMB\":20.5}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.downloadUrl").value("/downloads/course.zip"));
    }
}
