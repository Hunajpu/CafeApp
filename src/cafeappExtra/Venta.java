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
public class Venta {
     String Fecha;
    int IDVenta;
    Vector <VentaProducto> VentaProductos;
    Venta (int IDVenta,String Fecha)
    {
        VentaProductos=new Vector <VentaProducto>();
        this.IDVenta=IDVenta;
    }
    
    void addVenta(Producto p,int cantidad)
    {
        VentaProductos.add(new VentaProducto(p,cantidad));
    }
    
    void remomeVenta()
    {
        int index=VentaProductos.size()-1;
        if (index>=0)
        {
            VentaProductos.remove(index);
        }
    }
    
    String ListarVenta()
    {
        String Lista="";
        int size;
        int i;
        size=VentaProductos.size();
        for(i=0;i<size;i++)
        {
            Lista=Lista + VentaProductos.get(i).GetVenta() + "<br>";
        }
        return Lista;
    }
    
    VentaProducto GetVenta(int index )
    {
        if (index<VentaProductos.size())
        {
            return VentaProductos.get(index);
         }
        else
        {
            return null;
        }
    }
    
   int getNumProductosVenta()
   {
       return VentaProductos.size();
   }
}
