package spring.SearchAlgorithms;

import spring.dto.UserDto;
import spring.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BinarySearch {
    public static List<Optional<Long>> binarySearch(Long key, List<UserDto> array, int count) {
        if ( count >= array.size()) count = array.size();

        int N = count;
        List<Optional<Long>> findUsers = new ArrayList<>();
        Integer countOfIt = 0;


        // Создаем массив DELTA
        int[] DELTA = new int[(int) (Math.log(N) / Math.log(2)) + 2];
        for (int j = 1; j <= DELTA.length; j++) {
            DELTA[j - 1] = (int) Math.round(N / Math.pow(2, j));
        }

        int i = DELTA[0];
        int j = 2;

        while (true) {
            if (array.get(i).application_number().equals(key)) {
                findUsers.add(Optional.ofNullable(array.get(i).id()));
                System.out.println("Кол-во шагов алгоритма binarySearch = " + countOfIt);
                return findUsers; // Возвращаем индекс элемента, если нашли ключ
            }

            if (key < array.get(i).application_number()) {
                if (DELTA[j - 1] == 0) {
                    findUsers.add(Optional.empty());
                    return findUsers; // Алгоритм оканчивается неудачно
                }
                i -= DELTA[j - 1];
                j++;
            } else {
                if (DELTA[j - 1] == 0) {
                    findUsers.add(Optional.empty());
                    return findUsers; // Алгоритм оканчивается неудачно
                }
                i += DELTA[j - 1];
                j++;
            }
            countOfIt += 1;
        }
    }

}
