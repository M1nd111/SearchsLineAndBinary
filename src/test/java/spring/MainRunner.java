package spring;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.Hellper.PrintToConsoleDtoId;
import spring.SearchAlgorithms.BinarySearch;
import spring.SearchAlgorithms.LineSearch;
import spring.dto.UserDto;
import spring.repository.UserRepository;
import spring.service.UserService;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = ApplicationRunner.class)
public class MainRunner {
    private static UserService userService;
    static List<UserDto> users;

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    static void beforeAll() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationRunner.class);
        userService = context.getBean(UserService.class);
        users = userService.findAll();
        users.sort((x, y) -> Integer.compare(x.application_number().intValue(), y.application_number().intValue()));
    }

    @Test
    void Search(){
        users = userService.findAll();
        users.sort((x, y) -> {
            return Integer.compare(x.application_number().intValue() - y.application_number().intValue(), 0);
        } );

        var resultBinary = BinarySearch.binarySearch(718L, users);
        PrintToConsoleDtoId.userDto(resultBinary);
        var resultLine = LineSearch.linearSearch(718L, users);
        PrintToConsoleDtoId.userDto(resultLine);
    }


}
