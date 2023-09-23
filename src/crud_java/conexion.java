/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_java;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USUARIO
 */
public class conexion {
    public static Connection Conectar (){
        
        Connection cn=null;
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/producto","root","miumg2023");
            
        } catch (Exception e){
            System.out.println(String.valueOf(e));
            
        }
        
        return cn;
    }    
}
