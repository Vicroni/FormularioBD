/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import generico.Boton;
import generico.ComboAdapter;
import generico.EntradaTextoAdapter;
import generico.Texto;
import generico.Ventana;
import javax.swing.JOptionPane;
import logica.BaseDatos;

/**
 *
 * @author Alumno
 */
public class Formulario extends Ventana{
    private Texto nombreTxt, apellidoPatTxt, apellidoMatTxt, escuelaTxt;
    private EntradaTextoAdapter nombreIN, apellidoPatIN, apellidoMatIN;
    private Boton registroBtn, consultaBtn;
    private ComboAdapter escuelaIN;
    
    public Formulario(){
        super();
        
        //Configuranto cuadros de texto
        this.nombreTxt = new Texto("Nombre: ", 12, 12, this);
        
        this.apellidoPatTxt = new Texto("Apellido Paterno:  ", 12, 36, this);
        
        this.apellidoMatTxt = new Texto("Apellido Materno: ", 12, 60, this);
        
        this.escuelaTxt = new Texto("Escuela: ", 12, 84, this);
        
        
        //Configurando entradas de texto
        this.nombreIN = new EntradaTextoAdapter(200, 12, 20, 200, this);
        
        this.apellidoPatIN = new EntradaTextoAdapter(200, 36, 20, 200, this);
        
        this.apellidoMatIN = new EntradaTextoAdapter(200, 60, 20, 200, this);
        
        //Configurando Combo
        this.escuelaIN = new ComboAdapter(200, 84, new String[]{
            "Selecciona ","CECyT 1", "CECyT 3", "CECyT 9", "CECyT 11" 
        }, this); 
        
        
        //Configurando botones
        this.registroBtn = new Boton("Registrar", 12, 132, this) {
            @Override
            public void action() {
                if(
                    nombreIN.getText().equalsIgnoreCase("")
                    || apellidoPatIN.getText().equalsIgnoreCase("") 
                    || apellidoMatIN.getText().equalsIgnoreCase("")
                    || escuelaIN.getSelectedItem().toString().equalsIgnoreCase("Selecciona ")
                ){
                    JOptionPane.showMessageDialog(null, "Falto llenar algun campo", null, JOptionPane.ERROR_MESSAGE);
                }else{
                    realizarRegistro();
                    Registro t = new Registro();
                    JOptionPane.showMessageDialog(null, "Registrado", null, JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    t.configFrame(25, 25, 25, 50);
                }
            }
        };
        
        this.consultaBtn = new Boton("Ir a la tabla", 200, 132, this) {
            @Override
            public void action() {
                Registro t = new Registro();
                dispose();
                t.configFrame(25, 25, 25, 50);
            }
        };
    }
    
    @Override
    public void loopAction() {
        
    }
    
    private void realizarRegistro() {
        try{
            BaseDatos bd = new BaseDatos();
            bd.setConsulta("insert into datos values(?,?, ?, ?)");

            bd.getConsulta().setString(1, nombreIN.getText());
            bd.getConsulta().setString(2, apellidoPatIN.getText());
            bd.getConsulta().setString(3, apellidoMatIN.getText());
            bd.getConsulta().setString(4, escuelaIN.getSelectedItem().toString());

            bd.execute();
            bd.close();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, null, JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
