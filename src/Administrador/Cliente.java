/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Administrador;

/**
 *
 * @author danig
 */
public class Cliente {
    private int id;
    private String nombre, correo, password;
    private float peso, altura;

    public Cliente(int id, String nombre, String correo, String password, float peso, float altura) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.peso = peso;
        this.altura = altura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Cliente{" + "Nombre=" + nombre + ", correo=" + correo + ", peso=" + peso + ", altura=" + altura + '}';
    }
    
}
