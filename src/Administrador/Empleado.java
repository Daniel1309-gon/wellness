/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Administrador;

/**
 *
 * @author danig
 */
public class Empleado implements Comparable<Empleado>{
    //se implementa Comparable para el metodo compareTo
    
    private int ID;
    private String nombre, cargo, area;

    public Empleado(int ID, String nombre, String cargo, String area) {
        this.ID = ID;
        this.nombre = nombre;
        this.cargo = cargo;
        this.area = area;
    }

    @Override
    public int compareTo(Empleado em) {
        if(ID == em.ID){
            return 0;
        } else if( ID < em.ID){
            return -1;
        } else {
            return 1;
        }
    }
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "ID=" + ID + ", nombre=" + nombre + ", cargo=" + cargo + ", area=" + area + '}';
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    } 
}
