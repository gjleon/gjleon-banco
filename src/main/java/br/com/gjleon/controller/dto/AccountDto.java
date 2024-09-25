package br.com.gjleon.controller.dto;

import br.com.gjleon.domain.model.Account;

import java.math.BigDecimal;

public record AccountDto(
        Long id,
        String number,
        String agency,
        BigDecimal balance,
        BigDecimal limit
) {

    public AccountDto(Account accountModel) {
        this(
                accountModel.getId(),
                accountModel.getNumber(),
                accountModel.getAgency(),
                accountModel.getBalance(),
                accountModel.getLimit()
        );
    }

    public Account toModel(){
        Account accountModel = new Account();
        accountModel.setId(this.id);
        accountModel.setNumber(this.number);
        accountModel.setAgency(this.agency);
        accountModel.setBalance(this.balance);
        accountModel.setLimit(this.limit);
        return accountModel;
    }
}
