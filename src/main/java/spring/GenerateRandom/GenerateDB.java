package spring.GenerateRandom;


import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.entity.PersonalInfo;
import spring.entity.User;
import spring.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
@Transactional
public class GenerateDB {

    public void generateRow(UserService userService, int quantity){

        LocalTime time;
        String[] fio;
        String stamp;
        Integer application;
        String firstname;
        String name;
        String lastname;
        List<String> listMark = GenerateStamp.getMark();
        List<String> listFIO = GenerateFIO.getFIO();
        Random random = new Random();


        for (int i = 1; i <= quantity; i++) {

            time = GenerateTime.generateTime();
            fio = listFIO.get(random.nextInt(100)).split(" ");
            firstname = fio[0];
            name = fio[1];
            lastname = fio[2];
            stamp = listMark.get(random.nextInt(81));
            application = random.nextInt(1000);

            try {

                PersonalInfo personalInfo = PersonalInfo.builder()
                        .firstname(firstname)
                        .name(name)
                        .lastname(lastname)
                        .build();

                User user = User.builder()
                        .time(time)
                        .personalInfo(personalInfo)
                        .mark(stamp)
                        .applicationNumber(Long.valueOf(application))
                        .build();


                userService.save(user);
                log.debug("создан user " + user );

            } catch (Exception e) {
                e.printStackTrace();
                log.error("Exception при записи в бд");
            }
        }
        log.info("Записи сохранились в бд");
    }

}
