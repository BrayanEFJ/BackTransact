package com.Transact.BEFJ.Application.Services;

import com.Transact.BEFJ.Adapter.Ports.OutPersistence.Models.Usuarios;
import com.Transact.BEFJ.Application.Ports.In.IUserService;
import com.Transact.BEFJ.Application.Ports.Out.IFunUser.IFAuthU;
import com.Transact.BEFJ.Commons.Errors.CustomException;
import com.Transact.BEFJ.Domain.Usuarios.DtoInfoUserLog;
import com.Transact.BEFJ.Domain.Usuarios.DtoRequestLogin;
import com.Transact.BEFJ.Security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IFAuthU IFauth;
    
    @Autowired
    JwtTokenUtil jwt;

    @Override
    public DtoInfoUserLog Auth(DtoRequestLogin forauth) {
        try {
            Usuarios infousuario = IFauth.UnicoUsuario(forauth.getDocumento());
            DtoInfoUserLog infolog = new DtoInfoUserLog();
            infolog.setDocumento(infousuario.getDocumento());
            infolog.setNombres(infousuario.getNombre() + " " + infousuario.getApellido());
            String infousuariotoken = jwt.generateToken(infousuario.getDocumento());
            infolog.setToken(infousuariotoken);
            return infolog;
        }catch (CustomException ex){
            throw new CustomException(HttpStatus.NO_CONTENT.value(), "Contenido no mostrado" + ex.getMessage());
        }

    }
}
