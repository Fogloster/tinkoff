package com.company.simple;

import com.company.simple.dto.UserDto;

import java.util.List;

/*
 * Класс Main - вызывает методы класса builder и generateFromFiles, и HttpClient.
 * Методы создают эксель файл,в который помещаются случайно сгенерированные данные.
 * После этого эксель файл сохраняется и преобразуется в PDF файл.
 * Так же создается запрос к апи и парситься полученный результат. 
 *
 * Создано 10.03.2019
 *
 * Автор Сунгатуллин Радик Ильдарович
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int count = Utils.getRandomNumberInRange(30, 50);

        List<UserDto> usersFromApi = HttpClient.getRandomUsers(count);

        if (usersFromApi == null || usersFromApi.size() == 0) {
            System.out.println("Пользователи получены из файлов");
            Builder.generateFromFiles();
        } else {
            System.out.println("Пользователи получены через API");
            Builder.generateExcel(usersFromApi);
            Builder.generatePdf(usersFromApi);
        }
    }
}