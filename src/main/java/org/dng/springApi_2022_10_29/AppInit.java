package org.dng.springApi_2022_10_29;


import org.dng.springApi_2022_10_29.DTO.CurrencyList;
import org.dng.springApi_2022_10_29.Service.CurrencyRateGetter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
public class AppInit {
    private static CurrencyList currencyList;
    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartApp(){
        System.out.println("App was started!");
        try {
            currencyList = CurrencyRateGetter.getCurrencyList();
            System.out.println("currency list was loaded...");
        } catch (URISyntaxException | IOException | InterruptedException e) {
            System.out.println("During getting currency rate some ass was heppend");
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }

    public static CurrencyList getCurrencyList() {
        return currencyList;
    }
}
