/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cafeappExtra;

/**
 *
 * @@author Rodrigo Luna
 */
public class ProductoCantidad extends Producto{
 protected int Cantidad;
    ProductoCantidad(int Id, String N, String D)
    {
        super(Id,N,D);
        Cantidad=0;
    }
    
    ProductoCantidad(int Id, String N, String D,int cant)
    {
        super(Id,N,D);
        Cantidad=cant;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
}
