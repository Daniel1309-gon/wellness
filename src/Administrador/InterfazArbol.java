/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Administrador;

import javax.swing.JTextArea;

/**
 *
 * @author danig
 */
public interface InterfazArbol<Empleado extends Comparable>{
    
    void insertar(Empleado em);
    
    boolean existe(int id);
    
    Empleado obtener(int id);
    
    boolean esHoja();
    
    boolean esVacio();
    
    void preOrder(JTextArea area);
    
    void inOrder(JTextArea area);
    
    void postOrder(JTextArea area);
    
    void eliminar(int id);
    
}
