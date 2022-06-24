package com.fran.smile.smile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class SmileControllerIntegrationTest {
  @Autowired private MockMvc mvc;
  @Autowired private SmileRepository repository;
  
  @Test
  void canCreateSmile() throws Exception {

    mvc.perform(MockMvcRequestBuilders.post("/api/smiles")
      .contentType(MediaType.APPLICATION_JSON)
      .content("{\"isCrying\": \"true\", \"isLaughing\": \"false\"}"));
      assertEquals(2, repository.count());
  }
}
