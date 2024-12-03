/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Operador
 */
public class GestorPersistencia<T extends Serializable> {
    private String archivo;

    public GestorPersistencia(String archivo) {
        this.archivo = archivo;
    }
    
    public void guardar (List<T> lista){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))){
            oos.writeObject(lista);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public List<T> cargar(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))){
            return(List<T>) ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            return new ArrayList<>();
        }
    }
}
