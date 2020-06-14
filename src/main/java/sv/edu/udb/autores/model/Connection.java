/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.autores.model;


import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author raque
 */
public class Connection {
    
    protected DataSource dataSource;

    /**
     *
     */
    protected java.sql.Connection con;
    
    public Connection(){
        try{
            Context ctx=new InitialContext();
            dataSource=(DataSource)ctx.lookup("jdbc/mysql");
            
        }catch(NamingException e){
            e.printStackTrace();
            
        }
    }
    
 protected void connect()throws SQLException{
        if(dataSource==null)
            throw new SQLException("Nose puede obtener el data source");
            con= dataSource.getConnection();
            if(con==null)
                throw new SQLException("Nose puede establecer la conexion a la base de datos");
           
        }
        protected void close()throws SQLException{
            con.close();
        }
 }
    
 



