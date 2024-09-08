/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Transact.BEFJ.Adapter.Ports.InWeb;

import com.Transact.BEFJ.Adapter.Ports.OutPersistence.Models.Usuarios;
import com.Transact.BEFJ.Application.Ports.In.IUserService;
import com.Transact.BEFJ.Commons.Errors.CustomException;
import com.Transact.BEFJ.Domain.Usuarios.DtoInfoUserLog;
import com.Transact.BEFJ.Domain.Usuarios.DtoRequestLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author l
 */
@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    IUserService objserv;

    @GetMapping
    public ResponseEntity<?> findby (DtoRequestLogin forauth){
        try {
            DtoInfoUserLog infolog = objserv.Auth(forauth);
            return ResponseEntity.ok(infolog);
        }catch (CustomException ex){
            return ResponseEntity.status(ex.getStatus()).body(ex.toString());
        }
    }


    
}
