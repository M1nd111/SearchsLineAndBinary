package spring.dto;

import java.time.LocalTime;

public record UserDto(
        Long id,
        LocalTime time,
        String firstname,
        String name, String lastname,
        String mark_id,
        Long application_number
) {
}
