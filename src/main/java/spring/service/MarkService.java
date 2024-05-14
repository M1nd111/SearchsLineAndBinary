package spring.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.Mark;
import spring.repository.MarkRepository;
import spring.repository.MarkRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional // только public методы оборачиваются
@RequiredArgsConstructor
public class MarkService {
    private final MarkRepository markRepository;

    private final EntityManager entityManager;

    public Mark save(Mark entity) {
        markRepository.save(entity);
        return entity;
    }

    public void delete(Long id) {
        markRepository.deleteById(id);
        markRepository.flush();
    }

    public void update(Mark entity) {
        entityManager.merge(entity);
    }

    public Optional<Mark> findById(Long id) {
        return markRepository.findById(id);
    }

    public List<Mark> findAll() {
        return markRepository.findAll();
    }

}
