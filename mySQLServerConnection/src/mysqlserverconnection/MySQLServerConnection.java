/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlserverconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Huu Hien
 */
public class MySQLServerConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*tao connection url toi database
        * cu phap: jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
        */
        String connectionUrl= "jdbc:sqlserver://localhost:1189;" +  
         "databaseName=UserData;integratedSecurity=True";
        //cau hinh lai sql server cho phep truy cap, lay so cong trong sql configuration manager
        String query=  "SELECT * FROM UserData";
        Connection connection = null;
        Statement stm = null;
        ResultSet rs= null;
        
        System.out.println(connectionUrl);
        try{
            connection = DriverManager.getConnection(connectionUrl);
            stm= (Statement) connection.createStatement();
            rs = stm.executeQuery(query);
            
            while(rs.next() ){
                System.out.println(rs.getString(1)+ "|"+ rs.getString(2)+ "|"+ rs.getString(3)+ "|"+ rs.getString(4));
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("Connection error: "+ ex.toString());
        }
    }
    
}
