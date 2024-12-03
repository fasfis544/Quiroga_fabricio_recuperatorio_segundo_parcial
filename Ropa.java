/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Operador
 */
public class Ropa extends Producto {
    private String talla;

    public Ropa(String talla, int id, String nombre, double precioBase) {
        super(id, nombre, precioBase);
        if (talla == null)throw new IllegalArgumentException("la talla no puede estar vacia");
        if (!talla.matches("S|M|L|XL"))throw new IllegalArgumentException("talla invalida");
        this.talla = talla;
    }
    @Override
    public double calcularPrecioFinal(){
        if (talla.equals("XL")){
            return precioBase * 1.10;
        }
        return precioBase;
    } 
}
