package br.com.mkacunha.warmerscup.warmerscupserver.application.controller;

import br.com.mkacunha.warmerscup.warmerscupserver.domain.category.CategoryDTO;
import br.com.mkacunha.warmerscup.warmerscupserver.domain.category.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin("*")
@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity post(@RequestBody CategoryDTO category) {
        CategoryDTO saved = service.create(category);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity getOne(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.findOneToDTO(id));
    }

    @PutMapping("{id}")
    public ResponseEntity put(@PathVariable("id") String id, @RequestBody CategoryDTO category) {
        return ResponseEntity.accepted().body(service.update(id, category));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
