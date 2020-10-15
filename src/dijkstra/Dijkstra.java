/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author vluribe
 */
public class Dijkstra {

    /**
     * @param args the command line arguments
     */
                            //0, 1, 2, 3 ,4
    static int M[][] =/*0*/ {{0, 2, 0, 5, 0},
                     /*1*/  {3, 0, 4, 0, 0},
                    /*2*/   {0, 2, 0, 6, 1},
                    /*3*/   {1, 0, 2, 0, 0},
                      /*4*/ {0, 0, 1, 0, 0}};
    static LinkedList<Vertice> lista = new LinkedList();
    static int dis[] = new int[5];
    static boolean visitado[] = new boolean[5];
    static int padre[] = new int[5];

    public static void main(String[] args) {
        llenarLista();
       
        Dijsktra(M, new Vertice(0));
        System.out.println("vertices  0  1  2  3  4  ");
        System.out.print("padre ");
        for (int i = 0; i < padre.length; i++) {
            
                System.out.print(padre[i]+"  ");
            
        }
        System.out.println("");
        System.out.println(" distancias ");
        for (int i = 0; i < dis.length; i++) {
            System.out.print(dis[i]+"  ");
        }
    }
    
    public static void llenarLista() {

        for (int i = 0; i < 5; i++) {
            Vertice a = new Vertice(i);
            for (int j = 0; j < 5; j++) {
                if (M[i][j] != 0) {
                    a.list.add(j);
                    a.peso.add(M[i][j]);
                }
            }
            lista.add(a);
        }
    }

    public static void Dijsktra(int M[][], Vertice o) {
        LinkedList<Integer> cola = new LinkedList<Integer>();
        for (int i = 0; i < M.length; i++) {
            dis[i] = 999;
            padre[i] = -1;
            visitado[i] = false;
        }

        int l = dis[o.dato] = 0;
        cola.add(l);
        while (!cola.isEmpty()) {
            int u = caminoMin(cola);
            l = cola.indexOf(u);
            visitado[l] = true;
            cola.removeFirstOccurrence(u);
            u = l;
            System.out.println("u "+u);
            for (Integer v : getAdy(u)) {
                int temp = dis[u] + peso(u, v);
                if (temp < dis[v] && !visitado[v]) {
                    dis[v] = temp;
                    padre[v] = u;
                    cola.add(dis[v]);
                    System.out.println(cola.element());
                }
            }
        }
       // System.out.println("dist "+cola.element());
    }

    public static int caminoMin(LinkedList<Integer> cola) {
        int min = cola.getFirst();
        for (Integer num : cola) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static void Ady(LinkedList<Vertice> lista) {

        for (int i = 0; i < 5; i++) {
            Vertice a = new Vertice(i);
            for (int j = 0; j < 5; j++) {
                if (M[i][j] != 0) {
                    a.list.add(j);
                    a.peso.add(M[i][j]);
                }
            }
            lista.add(a);
        }
    }

    public static LinkedList<Integer> getAdy(int a) {

        
            System.out.println("jj");
           System.out.println(lista.get(a).list.size());
            return lista.get(a).list;
        
   
    }

    public static int peso(int a, int b) {
        int x = lista.get(a).list.indexOf(b);
        System.out.println("x "+x);
        return lista.get(a).peso.get(x);

    }

}
