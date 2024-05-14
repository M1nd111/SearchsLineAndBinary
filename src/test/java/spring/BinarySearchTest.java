package spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.Hellper.PrintToConsoleDtoId;
import spring.SearchAlgorithms.BinarySearch;
import spring.repository.UserRepository;
import spring.service.UserService;

@SpringBootTest(classes = ApplicationRunner.class)
public class BinarySearchTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Test
    void binarySearch(){
        var users = userService.findAll();
        users.sort((x, y) -> {
            return Integer.compare(x.application_number().intValue() - y.application_number().intValue(), 0);
        } );

        var result = BinarySearch.binarySearch(718L, users);

        PrintToConsoleDtoId.userDto(result);
    }
}
