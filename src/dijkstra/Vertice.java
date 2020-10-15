/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.LinkedList;

/**
 *
 * @author vluribe
 */
class Vertice {
    int dato;
    Vertice sgt;
LinkedList<Integer> list;
LinkedList<Integer> peso;
    public Vertice(int dato) {
        this.dato = dato;
        list   = new LinkedList();
        peso   = new LinkedList();
    }
    
}
