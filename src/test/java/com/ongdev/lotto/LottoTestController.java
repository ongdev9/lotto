package com.ongdev.lotto;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith({ RestDocumentationExtension.class, SpringExtension.class })
//@ExtendWith({ RestDocumentationExtension.class})
@RunWith(SpringRunner.class)
@SpringBootTest
public class LottoTestController {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation(); // (1)

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;


    @Before
    public void setUp() { // (2)
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void Lotto_테스트() throws Exception {

        // given
        String no = "100";

        // when
        mockMvc.perform(get("/v1/" + no)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  // then
//                .andExpect(jsonPath("$..no").value(no))
                .andDo(document("no")); // (3)
    }
}
