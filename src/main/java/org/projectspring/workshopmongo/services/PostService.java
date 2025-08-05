package org.projectspring.workshopmongo.services;

import org.projectspring.workshopmongo.domain.Post;
import org.projectspring.workshopmongo.domain.User;
import org.projectspring.workshopmongo.dto.UserDTO;
import org.projectspring.workshopmongo.exception.ObjectNotFoundException;
import org.projectspring.workshopmongo.repository.PostRepository;
import org.projectspring.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String title) {
        return repo.searchTitle(title);
    }
}
