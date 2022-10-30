package org.dng.springApi_2022_10_29.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dng.springApi_2022_10_29.DTO.CurrencyList;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class CurrencyRateGetter {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        System.out.println(getCurrencyList());
    }

    public static CurrencyList getCurrencyList() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI("https://postman-echo.com/get"))
                .uri(new URI("https://www.cbr-xml-daily.ru/daily_json.js"))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();

//        CurrencyList cl = new CurrencyList(
//                Map.of(
//                        "AUD", Map.of("ID", "R01010",
//                                "NumCode", "036",
//                                "CharCode", "AUD",
//                                "Nominal", 1,
//                                "Name", "Австралийский доллар",
//                                "Value", 39.8065,
//                                "Previous", 39.9508
//                        )
//                )
//        );
//        String str = mapper.writeValueAsString(cl);
//        System.out.println(str);

        //        System.out.println(currencyList);

        return mapper.readValue(response.body(), CurrencyList.class);

    }
}
