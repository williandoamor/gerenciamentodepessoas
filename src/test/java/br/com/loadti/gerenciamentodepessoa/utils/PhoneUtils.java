package br.com.loadti.gerenciamentodepessoa.utils;


import br.com.loadti.gerenciamentodepessoa.dto.PhonesDTO;
import br.com.loadti.gerenciamentodepessoa.entity.Phone;
import br.com.loadti.gerenciamentodepessoa.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhonesDTO createFakeDTO() {
        return PhonesDTO.builder()
                .number(PHONE_NUMBER)
                .phoneType(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
