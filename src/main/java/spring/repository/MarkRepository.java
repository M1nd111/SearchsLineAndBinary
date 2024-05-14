package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.entity.Mark;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {


}
