package com.ivarsexample.calendardemo.controller;

import com.ivarsexample.calendardemo.model.Content;
import com.ivarsexample.calendardemo.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content") // This declares the path to this controller
@CrossOrigin // Browsers have security features that may block requests unless an access-control-allow-orgin header has been added. This annotation handles this.
public class ContentController {
    // A controller simply accepts requests and returns responses
    // You typically find the CRUD methods in a Controller -> Create Read Update Delete

    private final ContentCollectionRepository repository;

    // The @Autowired annotation is implicit when you only have one public constructor.
    // That will make Spring automatically inject the ContentCollectionRepository
    // instance that Spring is managing.
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("") //Specialized RequestMapping for Get requests
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}") //Something inside {} is assigned to the parameter annotated with @PathVariable
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found..."));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        //RequestBody tells Spring that the content is going to be sent in a request body.
        //@Valid will check that constraints like @NotBlank in Content class definition are valid.
        //If not the caller will just get a 400 BAD REQUEST response
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found... :(");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.delete(id);
    }
}
