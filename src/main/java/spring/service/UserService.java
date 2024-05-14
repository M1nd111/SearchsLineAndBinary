package spring.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dto.UserDto;
import spring.entity.User;
import spring.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional // только public методы оборачиваются
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    public User save(User entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void delete(Long id) {
        entityManager.remove(userRepository.findById(id));
        userRepository.flush();
    }

    public void update(User entity) {
        entityManager.merge(entity);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(user -> {
            return new UserDto(
                    user.getId(),
                    user.getTime(),
                    user.getPersonalInfo().getFirstname(),
                    user.getPersonalInfo().getName(),
                    user.getPersonalInfo().getLastname(),
                    user.getMark(),
                    user.getApplicationNumber());
        }).collect(Collectors.toList());
    }

}
