package spring.SearchAlgorithms;

import spring.dto.UserDto;
import spring.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LineSearch {

   public static List<Optional<Long>> linearSearch(Long key, List<UserDto> array, int count) {
       List<Optional<Long>> findUsers = new ArrayList<>();
       Integer countOfIt = 0;

       if ( count >= array.size()) count = array.size();

        for (int i = 0; i < count; i++) {

            if (array.get(i).application_number().equals(key)) {

                findUsers.add(Optional.ofNullable(array.get(i).id()));
                System.out.println("Кол-во шагов алгоритма linearSearch = " + countOfIt);
                return findUsers;

            }
            countOfIt += 1;
        }
        return findUsers;
    }

}
