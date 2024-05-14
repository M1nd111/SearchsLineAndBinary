package spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import spring.ApplicationRunner;
import spring.Hellper.PrintToConsoleDtoId;
import spring.SearchAlgorithms.BinarySearch;
import spring.SearchAlgorithms.LineSearch;
import spring.dto.UserDto;
import spring.repository.UserRepository;

import java.util.List;

@Service
@ContextConfiguration(classes = ApplicationRunner.class)
public class AlgorithmService {
    private static UserService userService;
    @Autowired
    private UserRepository userRepository;

    public void StartAlgSearchLine(ConfigurableApplicationContext context, Long key, int count){
        List<UserDto> users;
        userService = context.getBean(UserService.class);
        users = userService.findAll();
        users.sort((x, y) -> {
            return Integer.compare(x.application_number().intValue() - y.application_number().intValue(), 0);
        } );

        var resultLine = LineSearch.linearSearch(key, users, count);
        PrintToConsoleDtoId.userDto(resultLine);
    }

    public void StartAlgSearchBinary(ConfigurableApplicationContext context, Long key, int count){
        List<UserDto> users;
        userService = context.getBean(UserService.class);
        users = userService.findAll();
        users.sort((x, y) -> {
            return Integer.compare(x.application_number().intValue() - y.application_number().intValue(), 0);
        } );

        var resultBinary = BinarySearch.binarySearch(key, users, count);
        PrintToConsoleDtoId.userDto(resultBinary);
    }

    public void StartAlgSearchBinaryAndLine(ConfigurableApplicationContext context, Long key, int count){
        List<UserDto> users;
        userService = context.getBean(UserService.class);
        users = userService.findAll();
        users.sort((x, y) -> {
            return Integer.compare(x.application_number().intValue() - y.application_number().intValue(), 0);
        } );

        var resultBinary = BinarySearch.binarySearch(key, users, count);
        PrintToConsoleDtoId.userDto(resultBinary);
        var resultLine = LineSearch.linearSearch(key, users, count);
        PrintToConsoleDtoId.userDto(resultLine);
    }
}
