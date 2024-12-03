/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Operador
 */
public class Electronico extends Producto {
    private int garantia;

    public Electronico(String nombre, double precioBase, int id) {
        super(id, nombre, precioBase);
        if (garantia < 0) throw new IllegalArgumentException("la garantia no puede ser negativa");
        this.garantia = garantia;
    }
    
    public double calcularPrecioFinal(){
        if (garantia > 12){
            return precioBase * 1.20;
        }
        return precioBase;
    }   
}
