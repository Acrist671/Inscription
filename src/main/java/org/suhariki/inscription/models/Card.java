package org.suhariki.inscription.models;

import lombok.Data;

@Data
public class Card {
    int CardId;
    String CardName;
    byte CardHp;
    byte CardDMG;
    byte CardCost;
    boolean CardRare;
    String CardCostType;
    String CardRace;
    boolean CardHandable;


}

