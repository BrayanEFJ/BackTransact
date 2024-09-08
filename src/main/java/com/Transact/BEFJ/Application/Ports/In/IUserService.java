package com.Transact.BEFJ.Application.Ports.In;

import com.Transact.BEFJ.Adapter.Ports.OutPersistence.Models.Usuarios;
import com.Transact.BEFJ.Domain.Usuarios.DtoInfoUserLog;
import com.Transact.BEFJ.Domain.Usuarios.DtoRequestLogin;

public interface IUserService {

    DtoInfoUserLog Auth (DtoRequestLogin forauth);


}
