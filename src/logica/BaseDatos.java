package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDatos {
    private Connection conexion;
    private PreparedStatement consulta;
    private String varMsg;
    public BaseDatos() throws Exception {
        String user = "root";
        String pass = "n0m3l0";
        String db_name = "datosFormulario";
        String puerto = ":3306";
        this.varMsg = "Todo ok";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost"+puerto+"/" + db_name, user, pass);
        }catch (Exception ex) {
            this.varMsg = "Fallo en [0]";
        }
    }
    
    public void setConsulta(String sql){
        try {
            this.consulta = this.conexion.prepareStatement(sql);
        }catch (Exception ex) {
            this.varMsg = "Fallo en [1]";
        }
    }
    
    public PreparedStatement getConsulta(){
        return  this.consulta;
    }
    
    public ResultSet executeQuery(){
        ResultSet rs = null;
        try {
            rs  = this.consulta.executeQuery();
        }catch (Exception ex) {
            this.varMsg = "Fallo en [2]";
        }
        return rs; 
    } 
    
    public void execute(){
        try {
            this.consulta.executeUpdate();
        }catch (Exception ex) {
            this.varMsg = ex.getMessage();
        }    
    }
    
    public void close(){
        try {
            this.conexion.close();
        }catch (Exception ex) {
            this.varMsg = "Fallo en [4]";
        }
    }    
    public String getVarMsg() {
        return this.varMsg;
    }

}
/*    
    BaseDatos bd = new BaseDatos();
    bd.setConsulta("select * from persona");
    ResultSet rs = bd.executeQuery();
    if (rs != null) while (rs.next()) {
        rs.getString("id_usuario")
    }
*/

/*
    BaseDatos bd = new BaseDatos();
    bd.setConsulta("insert into persona values(?,?)");

    bd.getConsulta().setString(1,request.getParameter("boleta").toString());

    bd.getConsulta().setString(2,request.getParameter("name").toString());

    bd.execute();
    bd.close();
    
*/
