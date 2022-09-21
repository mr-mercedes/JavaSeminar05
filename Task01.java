package ru.seminar05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */
public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> stringIntegerMap = new HashMap<>();
        boolean flag = true;
        String name;
        int telephoneNumber;
        while (flag) {
            int operator = Menu();
            if (operator == 1) {
                System.out.print("Введите имя для внесения в телефонную книгу: ");
                name = scanner.next();
                System.out.print("Введите телефон для внесения в телефонную книгу: ");
                telephoneNumber = scanner.nextInt();
                stringIntegerMap.put(telephoneNumber, name);
            } else if (operator == 2) {
                System.out.print("Введите имя для удаления записи: ");
                name = scanner.next();
                for (Integer item :stringIntegerMap.keySet()){
                    if (stringIntegerMap.get(item).equals(name)){
                        stringIntegerMap.remove(item);
                    }
                }
                System.out.printf("Запись с имененм %s удалена\n", name);
            } else if (operator == 3) {
                System.out.print("Введите имя для поиска: ");
                name = scanner.next();
                for (Integer item :stringIntegerMap.keySet()){
                    if (stringIntegerMap.get(item).equals(name)){
                        System.out.printf("Телефон %d принадлежит абоненту %s\n",item, name);
                    }
                }
            } else if (operator == 4) {
                System.out.print("Введите телефон для поиска: ");
                telephoneNumber = scanner.nextInt();
                System.out.printf("Телефон %d принадлежит абоненту %s\n",telephoneNumber, stringIntegerMap.get(telephoneNumber));
            } else if (operator == 0) {
                System.out.println("Завершение работы с программой.");
                flag = false;
            } else if (operator == 5) {
                for (Integer item : stringIntegerMap.keySet()){
                    System.out.println(stringIntegerMap.get(item) + " : " + item);
                }
            }
        }
        scanner.close();

    }

    private static Integer Menu() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> menu = new HashMap<>(Map.of(1, "Внести запись в телефонную книгу",
                                                        2, "Удалить запись из телефонной книги",
                                                        3, "Поиск телефона по имени",
                                                        4, "Поиск имени по телефону",
                                                        0, "Выход",
                                                        5, "Распечатать всю книгу"));

        for (Map.Entry<Integer, String> entry : menu.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        int operation = 0;
        System.out.print("Введите номер операции: ");
        operation = scanner.nextInt();
        return operation;

    }
}
