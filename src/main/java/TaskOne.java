import java.util.*;

public class TaskOne {
    public static void main(String[] args) {
//        Реализовать консольное приложение - телефонный справочник.
//        У одной фамилии может быть несколько номеров.
//        Пользователь может вводить команды:

//        1: ADD Ivanov 88005553535 - добавить в справочник новое значение. Первый аргумент - фамилия, второй - номер телефона
//        2: GET Ivanov - получить список всех номеров по фамилии
//        3: REMOVE Ivanov - удалить все номера по фамилии
//        4: LIST - Посмотреть все записи
//        5: EXIT - Завершить программу
//
//        Если при GET или REMOVE нужной фамилии нет, вывести информацию об этом
//        Пример взаимодействия (=> - это вывод на консоль):

//        ADD Ivanov 8 800 555 35 35
//        ADD Ivanov 8 800 100 10 10
//        GET Ivanov => [8 800 555 35 35, 8 800 100 10 10]
//        ADD Petrov 8 555 12 34
//        LIST => Ivanov = [8 800 5553535, 8 800 100 10 10], Petrov = [8 555 12 34]
//        REMOVE Ivanov
//        LIST => Petrov = [8 555 12 34]
//        GET NoName => Не найдена запись с фамилией "NoName"
//        REMOVE NoName => Не найдена запись с фамилией "NoName"3

        Map<String, List<String>> telBook = new HashMap<>();
        telMenue();
        Scanner scan = new Scanner(System.in);
        String[] line = scan.nextLine().split(" ");
        while (!line[0].equalsIgnoreCase("EXIT")) {

            if (line[0].equalsIgnoreCase("ADD") && line.length == 3) {
                if (telBook.containsKey(line[1])){
                    List<String> element = telBook.get(line[1]);
                    element.add(line[2]);
                    telBook.put(line[1], element);
                } else {
                    List<String> element = new ArrayList<>();
                    element.add(line[2]);
                    telBook.put(line[1], element);
                }

            } else if (line[0].equalsIgnoreCase("GET") && line.length >= 2) {
                if (!telBook.containsKey(line[1])){
                    System.out.printf("\"%s\" Not found :( \n", line[1]);
                } else {
                    System.out.println(telBook.get(line[1]));
                }

            } else if (line[0].equalsIgnoreCase("LIST")) {
                for (Map.Entry<String, List<String>> entry : telBook.entrySet()) {
                    System.out.println("Name: " + entry.getKey() + ", Phone: " + entry.getValue());
                }
            }else if (line[0].equalsIgnoreCase("REMOVE") && line.length >= 2) {
                if (!telBook.containsKey(line[1])){
                    System.out.printf("\"%s\" Not found :( \n", line[1]);
                } else {
                    telBook.remove(line[1]);
                }
            }else {
                System.out.println("Try again");
            }
            telMenue();
            line = scan.nextLine().split(" ");
        }

    }
 public static void telMenue(){
     System.out.println("Options:");
     System.out.println("- ADD");
     System.out.println("- GET");
     System.out.println("- REMOVE");
     System.out.println("- LIST");
     System.out.println("- EXIT");
     System.out.print("input: ");
 }




}
