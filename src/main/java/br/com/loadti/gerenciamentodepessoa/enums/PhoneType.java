package br.com.loadti.gerenciamentodepessoa.enums;

import lombok.Getter;


@Getter
public enum PhoneType {

    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");


    private final String description;

    PhoneType(String descricao) {

        description = descricao;
    }
}
