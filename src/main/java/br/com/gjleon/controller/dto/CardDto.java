package br.com.gjleon.controller.dto;

import br.com.gjleon.domain.model.Card;

import java.math.BigDecimal;

public record CardDto(
        Long id,
        String number,
        BigDecimal limit
) {
    public CardDto(Card cardModel) {
        this(
                cardModel.getId(),
                cardModel.getNumber(),
                cardModel.getLimit());
    }
    public Card toModel() {
        Card cardModel = new Card();
        cardModel.setId(this.id);
        cardModel.setNumber(this.number);
        cardModel.setLimit(this.limit);
        return cardModel;
    }
}
