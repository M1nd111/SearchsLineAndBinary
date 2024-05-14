package spring.Hellper;

import spring.dto.UserDto;

import java.util.List;
import java.util.Optional;

public class PrintToConsoleDtoId{

    public static void userDto(List<Optional<Long>> users){
        for(Optional<Long> userDto : users){
            userDto.ifPresent(System.out::println);
        }
    }

}
