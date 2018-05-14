
package my.application.model.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Adrián Gutiérrez & Arvid Zabel
 */
public class ConexionMySql {

    static Connection conexion = null;

    public ConexionMySql() { }
    
    public static void cargarDriverMysql(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            System.err.println("no carga el driver");
            System.exit(1);
        }        
    }
    
    public static Connection mysql(String url, String user, String pass) throws SQLException {
        conexion = null;
        /*String jdbcUrl = "jdbc:mysql://192.168.56.101/sakila"; //sakila es el nombre de la base de datos sobre la que actua
        String usuario = "root";
        String clave = "1q2w3e4r";
        if(url != null && !url.isEmpty()) {
            jdbcUrl = url;
        }
        if(user != null && !user.isEmpty()){
            usuario = user;
        }
        if(pass != null && !pass.isEmpty()){
            clave = pass;
        }
        Connection con = DriverManager.getConnection(jdbcUrl, usuario, clave);*/
        Connection con = DriverManager.getConnection(url, user, pass);
        System.out.println("Conectado a mysql!");
        conexion = con;
        return conexion;
    }
    
}