package spring;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import spring.GenerateRandom.GenerateDB;
import spring.entity.PersonalInfo;
import spring.entity.User;
import spring.repository.UserRepository;
import spring.service.UserService;

import java.time.LocalTime;

@SpringBootTest(classes = ApplicationRunner.class)
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void generateRow(){
        GenerateDB generateDB = new GenerateDB();
        generateDB.generateRow(userService, 500);
    }

    @Test
    @Transactional
    @Commit
    public void pushRow(){

        PersonalInfo personalInfo = PersonalInfo.builder()
                .firstname("test")
                .name("test")
                .lastname("test")
                .build();
        LocalTime localTime = LocalTime.now();
        User user = User.builder()
                .time(localTime)
                .personalInfo(personalInfo)
                .mark("test")
                .applicationNumber(Long.valueOf(111))
                .build();

        entityManager.persist(user);
        entityManager.flush();

    }

}
