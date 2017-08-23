/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

import java.awt.event.KeyEvent;

/**
 *
 * @author SAUL
 */
public class EntradaTextoAdapter extends EntradaTexto{

    public EntradaTextoAdapter(int x, int y, double alto, double ancho, Ventana padre) {
        super(x, y, alto, ancho, padre);
    }

    @Override
    public void validar(KeyEvent e) {
        
    }
    
}
