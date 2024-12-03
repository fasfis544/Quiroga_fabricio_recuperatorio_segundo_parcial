/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import Model.Repository;
import Model.Compra;
import Model.Producto;

/**
 *
 * @author Operador
 */
public class GestorTienda {
    private Map<Integer,Producto> productos;
    private Map<Integer,Compra> compras;
    private static int ultimoIdProducto = 1;
    private static int ultimoIdCompra = 1;
    
    private Repository<Producto> productoRepository;
    private Repository<Compra> compraRepository;

    public GestorTienda(String productosFile, String comprasFile) {
        this.productoRepository = new ProductoRepository(productosFile);
        this.compraRepository = new CompraRepository(comprasFile);
        this.productos = new HashMap<>();
        this.compras = new HashMap<>();
    }
    
    public void agregarProducto(Producto producto){
        if (producto == null){
            throw new IllegalArgumentException("Producto no puede ser nulo.");
            producto = new Producto(ultimoIdProducto++, producto.getNombre(), producto.getPrecioBase());
        }
        productoRepository.add(producto);
    }
    public Optional<Producto> buscarProductoPorId (int id){
        return Optional.ofNullable(productos.get(id));
    }
    public void realizarCompra (Compra compra){
        compraRepository.add(compra);
    }
    public double calcularIngresos(){
        return compraRepository.findAll().stream().mapToDouble(Compra::getTotal).sum();
    }
    public List<Producto> filtrarProductos(Predicate<Producto> criterio){
        return productoRepository.findAll().stream().filter(criterio).toList();
    }
    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }
    public List<Compra> listarCompras(){
        return compraRepository.findAll();

    }
    public void aplicarDescuento(Function<Producto, Double> descuento){
        for (Producto producto : productos.values()){
            double descuentoAplicado = descuento.apply(producto);
            producto.calcularPrecioFinal());
            }
        }
    }
