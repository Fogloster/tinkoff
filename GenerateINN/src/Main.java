/*
 * Класс Main - вызывает методы класса builder и generateData, и RequestHTTP.
 * Методы создают эксель файл,в который помещаются случайно сгенерированные данные.
 * После этого эксель файл сохраняется и преобразуется в PDF файл.
 * Так же создается запрос к апи и парситься полученный результат.
 *
 * Создано 10.03.2019
 *
 * Автор Сунгатуллин Радик Ильдарович
 */


public class Main {
    public static <string> void main(String[]args) throws Exception {
        Builder builder = new Builder();
        builder.generateData();

        RequestHTTP requestHTTP = new RequestHTTP();
        requestHTTP.callMe();

    }
}