/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Cuteness
 */
public class DAO {
    public static Connection con;
    
    public DAO(){}
    
    public static void getInstance(){
        if( con == null){
            String dbUrl = "jdbc:mysql://localhost:3306/qlnuoc";
            String dbDriver = "com.mysql.jdbc.Driver";
            try{
                Class.forName(dbDriver);
//                con = DriverManager.getConnection(dbUrl,"root","123");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnuoc?useUnicode=yes&characterEncoding=utf-8", "root","");
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
