/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Transact.BEFJ.Adapter.Repositories;

import com.Transact.BEFJ.Adapter.Ports.OutPersistence.Models.Usuarios;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author l
 */
@Repository
public interface UserRepository extends JpaRepository<Usuarios, Integer>{

    Usuarios findByDocumento(String Documento);
    
}
