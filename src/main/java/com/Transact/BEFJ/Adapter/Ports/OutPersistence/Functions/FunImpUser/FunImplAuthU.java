package com.Transact.BEFJ.Adapter.Ports.OutPersistence.Functions.FunImpUser;

import com.Transact.BEFJ.Adapter.Ports.OutPersistence.Models.Usuarios;
import com.Transact.BEFJ.Adapter.Repositories.UserRepository;
import com.Transact.BEFJ.Application.Ports.Out.IFunUser.IFAuthU;
import com.Transact.BEFJ.Commons.Errors.CustomException;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class FunImplAuthU implements IFAuthU {

    @Autowired
    UserRepository objrep;

    //metodo para buscar un usuario por su documento en el sistema
    @Override
    public Usuarios UnicoUsuario(String Documento) {
        try {
            Usuarios objuser = objrep.findByDocumento("1234567890");
            if (objuser != null) {
                return objuser;
            } else {
                throw new CustomException(HttpStatus.NOT_FOUND.value(), "Algo salio mal encontrando el documento");
            }
        } catch (CustomException ex) {
            throw new CustomException(HttpStatus.NOT_FOUND.value(), "Usario no encontrado" + ex.getMessage());
        }
    }
}
