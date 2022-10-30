package org.dng.springApi_2022_10_29.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyList {
    @JsonProperty("Date")
    private String Date="some date";
    @JsonProperty("Valute")
    private Map<String, Map<String, Object>> Valute;

    public CurrencyList() {
    }

    public CurrencyList(Map<String, Map<String, Object>> valute) {
        Valute = valute;
    }


    public Map<String, Map<String, Object>> getValute() {
        return Valute;
    }

    @Override
    public String toString() {
        return "CurrencyList{" +
                "Date='" + Date + '\'' +
                ", Valute=" + Arrays.toString(Valute.entrySet().toArray()) +
                '}';
    }
}
