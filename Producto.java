
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.Serializable;
/**
 *
 * @author Operador
 */
public abstract class Producto implements Serializable {
    protected int id;
    protected String nombre;
    protected double precioBase;

    public Producto(int id, String nombre, double precioBase) {
        if (nombre == null || nombre.length()< 3) throw new IllegalArgumentException ("Nombre debe tener al menos 3 caracteres");
        if (precioBase <= 0)throw new IllegalArgumentException ("el precio base debe ser mayor ue 0");
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }
    
    public abstract double calcularPrecioFinal();
    
    public String mostrarResumen(){
        return "ID:" + id + ", Nombre:" + nombre + ",Precio Final" + calcularPrecioFinal();
    }
    
    
}
