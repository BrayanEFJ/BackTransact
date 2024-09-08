/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Transact.BEFJ.Security;

import com.Transact.BEFJ.Commons.Errors.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 *
 * @author l
 */

@Component
public class JwtBalancer {
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public boolean authjwt(String Token) {
        if ((Token == null) || (Token.equals(""))) {
            throw new CustomException(HttpStatus.UNAUTHORIZED.value(), "El token no puede ser nulo");
        } else {
            try {
                String realToken = Token.substring(7);
                String tokenCheckResult = jwtTokenUtil.validateToken(realToken);
                if (tokenCheckResult.equalsIgnoreCase("valido")) {
                    return true;
                } else {
                    throw new CustomException(HttpStatus.UNAUTHORIZED.value(), "No autorizado: " + tokenCheckResult);
                }
            } catch (StringIndexOutOfBoundsException ex) {
                // El token está presente pero no tiene el formato adecuado
                throw new CustomException(HttpStatus.UNAUTHORIZED.value(), "No autorizado: El formato del token es incorrecto");
            }
        }
    }
    
}
