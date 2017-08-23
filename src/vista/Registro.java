/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import generico.Boton;
import generico.Tabla;
import generico.Ventana;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import logica.BaseDatos;
/**
 *
 * @author SAUL
 */
public class Registro extends Ventana{
    
    private Tabla tabla;
    private Boton regresarBtn;
    
    public Registro(){
        super();
        this.configFrame(25, 25, 25, 50);
        
        tabla = new Tabla(0,0, 200, this.getSize().width, new Object[]{
            "Nombre", "Apellido materno", "Apellido paterno", "Escuela" 
        }, this);
        
        this.regresarBtn = new Boton("Regresar", 0, 224,this) {
            @Override
            public void action() {
                dispose();
                Formulario f = new Formulario();
                f.configFrame(25, 25, 25, 50);
            }
        };
        
        
        try{
            BaseDatos bd = new BaseDatos();
            bd.setConsulta("select * from datos");
            ResultSet rs = bd.executeQuery();
            if (rs != null) while (rs.next()) {
                tabla.agregarRegistro(new Object[]{
                    rs.getString("nombre"),
                    rs.getString("apellidoMat"),
                    rs.getString("apellidoPat"),
                    rs.getString("escuela")
                });
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fallo la conexion con la BD", null, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void loopAction() {

    }
    
}
