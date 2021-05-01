/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cafeappExtra;

/**
 *
 * @author Rodrigo Luna
 */
public class VentaProducto {
 Producto P;
    int Cantidad;
    VentaProducto(Producto p, int c)
    {
        P=p;
        Cantidad=c;
    }
    
    String GetVenta()
    {
        return P.getNombre() + " " + P.getDescripcion()+ " " +Cantidad;
    }    
    
}
