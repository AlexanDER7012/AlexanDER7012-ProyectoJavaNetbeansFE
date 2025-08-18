package ferreteria.conexion;

import java.sql.*;

public class Conexion {
   public static Connection getConexion(){
       Connection conexion = null;
       String dataBase = "Ferreteria_db";
       String url = "jdbc:mysql://localhost:3306/"+dataBase;
       String usuario= "root";
       String password = "MyAlex7012";
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,password);
       }catch(Exception e){
           System.out.println("Error al hacer la conexion: "+e.getMessage());
          
       }
       return conexion;
   }
}
