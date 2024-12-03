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
public interface Repository<T> {
    void add(T entity);
    Optional<T> findById(int id);
    List<T> findAll(); 
}
