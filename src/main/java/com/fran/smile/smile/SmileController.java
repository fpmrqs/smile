package com.fran.smile.smile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class SmileController {
  @Autowired private SmileRepository repository;

  @GetMapping("api/smiles")
  public Iterable<Smile> getAll() {
    return repository.findAll();
  }

  @GetMapping("api/smiles/{id}")
  public Smile getSmile(@PathVariable Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No smiles exists with id " + id));
  }

  @PostMapping("api/smiles")
  public Smile create(@RequestBody Smile smile) {
    repository.save(smile);
    return smile;
  }
}
