package com.company.simple;

import com.company.simple.dto.UserDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
 * Класс HttpClient
 *
 *
 * Создано 10.03.2019
 *
 * Автор Сунгатуллин Радик Ильдарович
 */
public class HttpClient {

    public static List<UserDto> getRandomUsers(int count) {
        List<UserDto> result = new ArrayList<>();

        HttpURLConnection connection = null;

        try {
            for (int i = 0; i < count; i++) {
                URL url = new URL("https://randus.org/api.php");

                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();

                if (responseCode != 200) {
                    System.err.println("Не могу запросить пользователей с randus.org");

                    return null;
                }

                BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                StringBuilder response = new StringBuilder();

                String inputLine;
                while ((inputLine = input.readLine()) != null) {
                    response.append(inputLine);
                }

                input.close();

                result.add(convertToGetRandomUserDto(response.toString()));
            }
        } catch (IOException e) {
            System.err.println("Не могу запросить пользователей с randus.org");

            return new ArrayList<>();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return result;
    }

    private static UserDto convertToGetRandomUserDto(String input) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(input, UserDto.class);
    }
}