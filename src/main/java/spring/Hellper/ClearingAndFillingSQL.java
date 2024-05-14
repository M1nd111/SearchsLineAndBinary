/*
package spring.Hellper;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

public class ClearingAndFillingSQL {
*/
/**//*

    private final static  String DELETE_ALL_ROWS_SQL = """
                                            DELETE FROM trening.%s
                                            """;
    private final static  String SAVE_SQL_WITH_ID = """
                                            INSERT INTO trening.%s
                                            (id, time, fio, mark)
                                            values (?, ?, ?, ?)
                                            """;

    public static void ClearAndPush(String nameTable, List<Buyer> list){
        try(var connection = ConnectionManager.get();
            var statamentClear = connection.prepareStatement(String.format(DELETE_ALL_ROWS_SQL, nameTable));
            var statamentPush = connection.prepareStatement(String.format(SAVE_SQL_WITH_ID, nameTable))) {

            System.out.println("начался процесс очитки бд" + LocalTime.now());
            statamentClear.executeUpdate();
            System.out.println("закончаился процесс очитки бд" + LocalTime.now());

            System.out.println("начался процесс записи в бд" + LocalTime.now());
            for(Buyer buyer : list){
                statamentPush.setInt(1, buyer.getId());
                statamentPush.setTime(2, buyer.getTime());
                statamentPush.setString(3, buyer.getFio());
                statamentPush.setString(4, buyer.getMark());
                statamentPush.executeUpdate();
            }
            System.out.println("закончился процесс записи в бд" + LocalTime.now());

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private final static  String SAVE_SQL = """
                                            INSERT INTO trening.%s
                                            (id, time, fio, mark)
                                            values (999, null, ?, ?)
                                            """;
    public static void save(String watch, String TableName){
        System.out.println("начался процесс сохранения записи в mysql" + LocalTime.now());

        try(var connection = ConnectionManager.get();
            var statament = connection.prepareStatement(String.format(SAVE_SQL, TableName))){

            statament.setString(1, "Время на поиск затрачено ->");
            statament.setString(2, watch);

            statament.executeUpdate();
            System.out.println("записи сохранились корректно" + LocalTime.now());

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }
}
*/
