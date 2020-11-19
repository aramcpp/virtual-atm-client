package com.atm.card_reader;

import com.Card;
import com.utils.enums.CardInfo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class CardReaderAbstract {
    private Card card;

    private final Scanner scanner;

    public CardReaderAbstract() {
        scanner = new Scanner(System.in);
        card = null;
    }

    public Card getCard() throws NullPointerException {
        if (card == null) throw new NullPointerException("Invalid Card");
        return card;
    }

    public void readCard() throws CardIsInvalidException {
        LinkedHashMap<CardInfo,String> cardIdentifyInfo = new LinkedHashMap<>();
        String info;
        for (CardInfo cardInfo : CardInfo.values()) {
            System.out.print("Insert your " + cardInfo + ": ");
            info = scanner.nextLine();
            cardIdentifyInfo.put(cardInfo, info);
        }
        checkCardIsValid(cardIdentifyInfo);
        card = new Card(cardIdentifyInfo);
    }

    private void checkCardIsValid(LinkedHashMap<CardInfo, String> cardIdentifyInfo) throws CardIsInvalidException {
        int cardNumberLength = cardIdentifyInfo.get(CardInfo.CARD_NUMBER).length();
        if (cardNumberLength >= Card.ID_MAX_LENGTH || cardNumberLength <= Card.ID_MIN_LENGTH) {
            throw new CardIsInvalidException("Invalid Card");
        }
    }

    public void ejectCard() {
        card = null;
    }

    public void eatCard() {
        System.out.println("Please contact card service");
    }
}
