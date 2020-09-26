package uz.xtreme.defaultstarter;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import uz.xtreme.defaultstarter.model.auth.AuthenticationRequest;

@SpringBootTest
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class AuthenticationControllerTest {

    private MockMvc mockMvc;
    private Gson gson;

    @BeforeEach
    public void setUp(WebApplicationContext context, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(documentationConfiguration(restDocumentation))
                .build();
        this.gson = new Gson();
    }

    @Test
    void getTokenShouldReturnOk() throws Exception {
        AuthenticationRequest body = AuthenticationRequest.builder()
                .username("foo").password("foo").build();
        this.mockMvc.perform(RestDocumentationRequestBuilders.post("/api/v1.0/token")
                .content(gson.toJson(body))
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(document("get-token"));
    }
}
