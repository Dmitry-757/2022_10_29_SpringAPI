package org.dng.springApi_2022_10_29.Service;

import org.dng.springApi_2022_10_29.AppInit;
import org.dng.springApi_2022_10_29.DTO.IMessage;
import org.dng.springApi_2022_10_29.DTO.Messages;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;


@Service
public class ConverterService {

    public double getRate(Messages.Currency currency){

//        //приводим все к usd
//        float amountUSD = switch (inCurrency){
//            case USD -> 1F;
//            case RUB -> (1/61.0F);
//            case EUR -> 1.2F;
//        };
//
//        result = amountUSD * switch (outCurrency){
//            case USD -> 1;
//            case RUB -> 61.0F;
//            case EUR -> 1F/1.2F;
//        };
        if (currency == Messages.Currency.RUB ){
            return 1;
        }
        else if (AppInit.getCurrencyList().getValute().containsKey(currency.toString())){
            Map<String, Map<String, Object>> valuteMap = AppInit.getCurrencyList().getValute();
            Map<String, Object> valute = valuteMap.get(currency.toString());
            Object value = valute.get("Value");
            return (double) Optional.ofNullable(value).orElse(0F);
        }

        return 0;
    }

    public IMessage convert(IMessage inMessage){
        double result;
        result = inMessage.value()*getRate(inMessage.inCurrency()) / getRate(inMessage.outCurrency());
        return new Messages.OutMessage(inMessage.inCurrency(), inMessage.outCurrency(), result);
    }


}
