/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author SAUL FERNANDO GONZÁLEZ DOMINGUEZ
 * @author CARLOS EDUARDO GONZÁLEZ ANGUIANO 
 */
public abstract class Boton extends JButton{
    
    public Boton(String text, int x, int y, Ventana padre){
        super();
        this.setText(text);
        
        this.setVisible(true);
        this.setSize(this.getPreferredSize());
        
        this.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Método abstracto para implementar acciones en Botones
                action();
            }
        });
        
        this.setLocation(new Point(x, y));
        
        //Agrega el elemento al objeto padre
        padre.add(this);
    }
   
    public abstract void action();
}
