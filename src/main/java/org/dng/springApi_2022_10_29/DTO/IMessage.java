package org.dng.springApi_2022_10_29.DTO;

public interface IMessage {
    Messages.Currency inCurrency();
    Messages.Currency outCurrency();
    float value();
}
