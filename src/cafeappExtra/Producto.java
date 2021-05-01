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
public class Producto {
 int ID;
    protected String Nombre;
    protected String Descripcion;
    Producto(int ID,String N, String D)
    {
        this.ID=ID;
        Nombre=N;
        Descripcion=D;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getID() {
        return ID;
    }    
}
