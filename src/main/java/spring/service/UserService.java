package spring.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.User;
import spring.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional // только public методы оборачиваются
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    public User save(User entity) {
        userRepository.save(entity);
        return entity;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
        userRepository.flush();
    }

    public void update(User entity) {
        entityManager.merge(entity);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
