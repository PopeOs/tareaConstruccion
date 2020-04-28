/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tareaconstru;

import java.util.ArrayList;

/**
 * 
 * @author Felipe
 */
public class Farmacia {
    String nombre;
    String direccion;
    String telefono;
    String comuna;
    ArrayList<Item> inventario = new ArrayList<>();

    public Farmacia(String nombre, String direccion, String telefono, String comuna) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.comuna = comuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public ArrayList<Item> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Item> inventario) {
        this.inventario = inventario;
    }


    
    
}