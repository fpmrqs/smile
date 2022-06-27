package com.fran.smile.smile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class SmileControllerIntegrationTest {
  @Autowired
  private MockMvc mvc;
  @Autowired
  private SmileRepository repository;

  @Test
  public void testCreateSmile() throws Exception {
    mvc.perform(
        MockMvcRequestBuilders.post("/api/smiles")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"isCrying\": \"true\", \"isLaughing\": \"false\"}"))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.isCrying").value("true"))
        .andExpect(jsonPath("$.isLaughing").value("false"));

    assertEquals(1, repository.count());
  }

  @Test
  public void testGetAllSmiles() throws Exception {
    repository.save(new Smile(true, false));
    repository.save(new Smile(false, true));

    mvc.perform(MockMvcRequestBuilders.get("/api/smiles").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0].isCrying").value("true"))
        .andExpect(jsonPath("$[0].isLaughing").value("false"))
        .andExpect(jsonPath("$[1].isCrying").value("false"))
        .andExpect(jsonPath("$[1].isLaughing").value("true"));

    assertEquals(2, repository.count());
  }

  @Test
  public void testGetSmileById() throws Exception {
    repository.save(new Smile(true, false));

    mvc.perform(MockMvcRequestBuilders.get("/api/smiles/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    assertEquals(1, repository.count());
  }
}
