package br.com.loadti.gerenciamentodepessoa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {

    private String mensagem;
}
