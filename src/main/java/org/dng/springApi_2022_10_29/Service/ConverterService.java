package org.dng.springApi_2022_10_29.Service;

import org.dng.springApi_2022_10_29.DTO.IMessage;
import org.dng.springApi_2022_10_29.DTO.Messages;
import org.springframework.stereotype.Service;


@Service
public class ConverterService {

    public float getRate(Messages.Currency inCurrency, Messages.Currency outCurrency){
        float result;

        //приводим все к usd
        float amountUSD = switch (inCurrency){
            case USD -> 1F;
            case RUB -> (1/61.0F);
            case EUR -> 1.2F;
        };

        result = amountUSD * switch (outCurrency){
            case USD -> 1;
            case RUB -> 61.0F;
            case EUR -> 1F/1.2F;
        };

        return result;
    }

    public IMessage convert(IMessage inMessage){
        float result;
        result = inMessage.value()*getRate(inMessage.inCurrency(), inMessage.outCurrency());
        return new Messages.OutMessage(inMessage.inCurrency(), inMessage.outCurrency(), result);
    }


}
