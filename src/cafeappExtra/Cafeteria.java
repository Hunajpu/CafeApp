/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cafeappExtra;

import java.util.Vector;

/**
 *
 * @author Rodrigo Luna
 */
public class Cafeteria {
     static int NumVentas=0;
    protected Vector <Producto> Productos;
    protected Vector <Venta> Ventas;
    Cafeteria(int NumVentas)
    {
        Productos=new Vector<Producto>();
        Ventas=new Vector<Venta>();
        Cafeteria.NumVentas=NumVentas;
    }
    void AddProducto(Producto P)
    {
        Productos.add(P);       
    }
    
    Producto GetProducto(int index)
    {
        return Productos.get(index-1);
    }
    
    boolean removeProducto(Producto P)
    {
        return Productos.remove(P);
    }
      
    boolean removeProducto(int index)
    {
        if (Productos.remove(index)!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }   
    
    Venta CrearNuevaVenta()
    {
        NumVentas++;
        return new Venta(NumVentas,java.util.Calendar.getInstance().toString());
    }
    
    public void AddVenta(Venta V)
    {
        Ventas.add(V);
    }
    
    public  Vector<Producto> ListarProductos()
    {
        return Productos;      
    }
    
    public Vector<Venta> ListarVentas()
    {
        return Ventas;
    }
}
