package ru.seminar05;

import java.util.*;

/*
2. Пусть дан список сотрудников:
    "Иван", "Иванов",
    "Светлана", "Петрова",
    "Кристина", "Белова",
    "Анна", "Муинса",
    "Анна", "Крутова",
    "Иван", "Юрин",
    "Петр", "Лыков",
    "Павел", "Чернов",
    "Петр", "Чернышов",
    "Мария", "Федорова",
    "Марина", "Светлова",
    "Мария", "Савина",
    "Мария", "Рыкова",
    "Марина", "Лугова",
    "Анна", "Владимирова",
    "Иван", "Мечников",
    "Петр", "Петин",
    "Иван", "Ежов"
    Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */
public class Task02 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(List.of("Иван Иванов",
                                                                        "Светлана Петрова",
                                                                        "Кристина Белова",
                                                                        "Анна Муинса",
                                                                        "Анна Крутова",
                                                                        "Иван Юрин",
                                                                        "Петр Лыков",
                                                                        "Павел Чернов",
                                                                        "Петр Чернышов",
                                                                        "Мария Федорова",
                                                                        "Марина Светлова",
                                                                        "Мария Савина",
                                                                        "Мария Рыкова",
                                                                        "Марина Лугова",
                                                                        "Анна Владимирова",
                                                                        "Иван Мечников",
                                                                        "Петр Петин",
                                                                        "Иван Ежов"));

        TreeMap<String, Integer> treeMap = getStringIntegerTreeMap(arrayList);
        int maxLength = getMaxLength(treeMap);
        printFromMaxToMinCount(treeMap, maxLength);

    }

    private static void printFromMaxToMinCount(TreeMap<String, Integer> treeMap, int maxLength) {
        for (int i = maxLength; i >= 0 ; i--) {
            if (treeMap.containsValue(i)){
                for (String item : treeMap.keySet()){
                    if (treeMap.get(item) == i && treeMap.get(item) != 1){
                        System.out.println(item + "\t : " + i);
                    }
                }
            }
        }
    }

    private static int getMaxLength(TreeMap<String, Integer> treeMap) {
        int maxLength = 0;
        for (String item : treeMap.keySet()){
            if (treeMap.get(item) != 1) {
                if (treeMap.get(item) > maxLength){
                    maxLength = treeMap.get(item);
                }
            }
        }
        return maxLength;
    }

    private static TreeMap<String, Integer> getStringIntegerTreeMap(ArrayList<String> arrayList) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        int count = 1;
        for (String item : arrayList) {
            String[] tmp = item.split(" ");
            if (!treeMap.containsKey(tmp[0])){
                treeMap.put(tmp[0], count);
            } else {
                count = treeMap.get(tmp[0]) + 1;
                treeMap.replace(tmp[0], count);
                count--;
            }
        }
        return treeMap;
    }

}
