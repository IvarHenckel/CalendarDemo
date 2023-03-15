package com.ivarsexample.calendardemo.controller;

import com.ivarsexample.calendardemo.model.Content;
import com.ivarsexample.calendardemo.repository.ContentCollectionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/content") // This declares the path to this controller
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
}
