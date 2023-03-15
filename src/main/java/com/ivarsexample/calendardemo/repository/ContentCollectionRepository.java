package com.ivarsexample.calendardemo.repository;

import com.ivarsexample.calendardemo.model.Content;
import com.ivarsexample.calendardemo.model.Status;
import com.ivarsexample.calendardemo.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    // This class will just collect some state in to memory, we are not talking to a DB yet.

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content c) {
        contentList.removeIf(c2 -> c2.id().equals(c.id()));
        contentList.add(c);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c2 -> c2.id().equals(id));
    }

    @PostConstruct
    private void init() {
        Content c = new Content(
                1,
                "My First Blog Post",
                "My First Blog Post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );
        contentList.add(c);
    }
}
