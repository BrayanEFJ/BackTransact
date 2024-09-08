package com.Transact.BEFJ.Domain.Usuarios;

import lombok.Data;

@Data
public class DtoRequestLogin {

    private String documento;
    private String pin;

}
