/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Operador
 */
public class ProductoRepository implements Repository<Producto>{
    private List<Producto> productos;
    private GestorPersistencia<Producto> gestorPersistencia;
    

    public ProductoRepository(String archivo){
        this.gestorPersistencia = new GestorPersistencia<>(archivo);
        this.productos = gestorPersistencia.cargar();
    }
    public void add (Producto entity){
        productos.add (entity);
        gestorPersistencia.guardar(productos);
    }
    public Optional<Producto> findById(int id){
        return productos.stream().filter(p -> p.getId()== id).findFirst();
        
    }
    public List<Producto> findAll(){
        return productos;
    }
}
