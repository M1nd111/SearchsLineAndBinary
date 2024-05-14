package spring.GenerateRandom;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;


public class GenerateDB {

    public static void generateRow(Connection connection, int quantity){

        LocalTime time;
        String fio;
        String stamp;
        List<String> listMark = GenerateStamp.getMark();
        List<String> listFIO = GenerateFIO.getFIO();
        Random random = new Random();


        String sql = """
                INSERT INTO trening.find (id, time, fio, mark) 
                VALUES (?, ?, ?, ?)
                """;

        for (int i = 1; i <= quantity; i++) {

            time = GenerateTime.generateTime();
            fio = listFIO.get(random.nextInt(100));
            stamp = listMark.get(random.nextInt(81));

            try {

                var statament = connection.prepareStatement(sql);
                statament.setInt(1, i);
                statament.setTime(2, Time.valueOf(time));
                statament.setString(3, fio);
                statament.setString(4, stamp);

                statament.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private GenerateDB() {
    }
}
