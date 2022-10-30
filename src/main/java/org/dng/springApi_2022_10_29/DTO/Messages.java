package org.dng.springApi_2022_10_29.DTO;


public class Messages {

    public record InMessage(Currency inCurrency, Currency outCurrency, double value) implements IMessage {
        public InMessage(Currency inCurrency, Currency outCurrency, double value) {
            this.inCurrency = inCurrency;
            this.outCurrency = outCurrency;
            this.value = value;
        }
    }

    public record OutMessage(Currency inCurrency, Currency outCurrency, double value) implements IMessage {
        public OutMessage(Currency inCurrency, Currency outCurrency, double value) {
            this.inCurrency = inCurrency;
            this.outCurrency = outCurrency;
            this.value = value;
        }
    }


//    public class Message implements IMessage{
//        public Currency inCurrency;
//        public Currency outCurrency;
//        public int inValue;
//        public int outValue;
//    }

//    public record OutputMessage(Currency inCurrency, Currency outCurrency, int inValue, int outValue) implements IMessage{
//        public OutputMessage(Currency inCurrency, Currency outCurrency, int inValue, int outValue) {
//            this.inCurrency = inCurrency;
//            this.outCurrency = outCurrency;
//            this.inValue = inValue;
//            this.outValue = outValue;
//        }
//    }


    public enum Currency{
        USD,
        RUB,
        EUR
    }
}
