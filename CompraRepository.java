/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Operador
 */
public class CompraRepository implements Repository<Compra> {
    private List<Compra> compras;
    private GestorPersistencia<Compra> gestorPersistencia;

    public CompraRepository(String archivo) {
        this.gestorPersistencia = new GestorPersistencia<>(archivo);
        this.compras = gestorPersistencia.cargar();
    }
    public void add (Compra entity){
        compras.add(entity);
        gestorPersistencia.guardar(compras);
    }
    public List<Compra> findAll(){
        return compras;
    }

    @Override
    public Optional<Compra> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
