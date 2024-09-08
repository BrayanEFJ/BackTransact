/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Transact.BEFJ.Commons.Errors;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

/**
 *
 * @author l
 */
public class CustomException extends RuntimeException {
    
    private String timestamp;
    private int status;
    private String error;
    private String motive;
//   private String path;  por ahora comentado, ver si hay una posible integracion mas adelante

     public CustomException(int status, String motive) {
        super(motive);
        this.timestamp = LocalDateTime.now().toString();
        this.status = status;
        this.error = HttpStatus.valueOf(status).getReasonPhrase(); // se uso para obtrener el mensaje de error automáticamente
        this.motive = motive;
    }
     
    public int getStatus() {
        return this.status;
    }


    @Override
    public String toString() {
        return "{" +
                "\"timestamp\": \"" + timestamp + "\"," +
                "\"status\": " + status + "," +
                "\"error\": \"" + error + "\"," +
                "\"motive\": \"" + motive + "\"" +
//                "\"path\": \"" + path + "\"" +
                "}";
    }
}