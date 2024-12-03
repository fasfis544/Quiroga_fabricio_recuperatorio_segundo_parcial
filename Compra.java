package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Operador
 */
public class Compra implements Serializable {
    private static int contador = 1;
    private int idCompra;
    private String cliente;
    private List<Producto> productos = new ArrayList <>();
    private double total;

    public Compra(String cliente) {
        this.idCompra = contador++;
        this.cliente = cliente;
     
    }
    public void agregarProducto(Producto producto){
        productos.add(producto);
        calcularTotal();
    }
    public void calcularTotal(){
        total = productos.stream().mapToDouble (Producto::calcularPrecioFinal).sum();
    }
    public String mostrarDetalle(){
        StringBuilder detalle = new StringBuilder ("compra id;" + idCompra + "\nCliente:" + cliente + "\nProductos:\"n");
        for (Producto producto : productos){
            detalle.append(producto.mostrarResumen()).append("\n");
        }
        detalle.append("Total:"+ total);
        return detalle.toString();
    }
    
    public double getTotal(){
        return total;
    }
    
    public List<Producto> getProductos(){
        return productos;
    }
}
