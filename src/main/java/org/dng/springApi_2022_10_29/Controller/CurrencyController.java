package org.dng.springApi_2022_10_29.Controller;

import org.dng.springApi_2022_10_29.DTO.IMessage;
import org.dng.springApi_2022_10_29.DTO.Messages;
import org.dng.springApi_2022_10_29.Service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/")
public class CurrencyController {
    private final ConverterService converterService;
    @Autowired
    public CurrencyController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @GetMapping(path = "ping")
    public IMessage ping(){
        return new Messages.OutMessage(Messages.Currency.USD, Messages.Currency.RUB, 1);
    }

    @PostMapping(path = "convert")
    public IMessage convert(@RequestBody Messages.InMessage inMessage){
        return converterService.convert(inMessage);
    }
}
