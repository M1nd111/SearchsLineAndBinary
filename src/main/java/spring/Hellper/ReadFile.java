//package spring.Hellper;
//
//import entity.Field;
//import entity.Time;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class ReadFile {
//
//    public static ArrayList<Field> readFile(String filename){
//        ArrayList<Field> list = new ArrayList<>();
//        Field line;
//        String string = "";
//        int number = 0;
//
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(filename));
//
//            while (reader.ready()){
//                string = reader.readLine();
//                number++;
//                String[] strings = string.split(" ");
//
//                line = new Field(
//                        new Time(Integer.parseInt(strings[0].substring(0, 2)), Integer.parseInt(strings[0].substring(3, 5))),
//                        "%s %s %s".formatted(strings[1], strings[2], strings[3]),
//                        strings[4],
//                        number
//                );
//                list.add(line);
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return list;
//    }
//
//    public static void printFile(String fileName){
//        for(Field field : ReadFile.readFile(fileName)){
//            System.out.println("%d:%d %s %s %d\n".formatted(
//                    field.TIME.hour, field.TIME.minute,
//                    field.FIO,
//                    field.STAMP,
//                    field.NUMBER
//            ));
//        }
//    }
//
//    private ReadFile() {
//    }
//}
