package abb;

import lista.ListaImp;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class ABB<T extends Comparable<T>> {

    private Nodo<T> raiz;

    public void agregar (T dato){
        if(raiz == null) raiz = new Nodo<T>(dato);
        else agregar(raiz, dato);
    }

    private void agregar(Nodo<T> nodo, T dato){
        if(nodo.getDato().compareTo(dato) < 0){
            //Derecha
            if(nodo.getDer() == null) {
                nodo.setDer(new Nodo<T>(dato));
            }else{
                agregar(nodo.getDer(), dato);
            }
        }else{
            //Izquierda
            if(nodo.getIzq() == null){
                nodo.setIzq(new Nodo<T>(dato));
            }else{
                agregar(nodo.getIzq(), dato);
            }
        }
    }

    public boolean existe(T dato){
            return existe(this.raiz, dato);
    }

    private boolean existe(Nodo<T> nodo, T dato ){
        if(nodo == null){
            return false;
        }
        if(nodo.getDato().equals(dato)){
            return true;
        }
        if(nodo.getDato().compareTo(dato) > 0){
           return existe(nodo.getIzq(), dato);
        }else{
            return existe(nodo.getDer(), dato);
        }
    }


    public void mostrarCreciente(){
        mostrarCrecienteRec(this.raiz);
    }

    private void mostrarCrecienteRec(Nodo<T> nodo) {
        if (nodo != null) {
            mostrarCrecienteRec(nodo.getIzq());
            System.out.print(nodo.getDato() + " ");
            mostrarCrecienteRec(nodo.getDer());
        }
    }

    public void mostrarDecreciente(){
        mostrarDecrecienteRec(raiz);
    }

    private void mostrarDecrecienteRec(Nodo<T> nodo) {
        if (nodo != null) {
            mostrarDecrecienteRec(nodo.getDer());
            System.out.print(nodo.getDato() + " ");
            mostrarDecrecienteRec(nodo.getIzq());
        }
    }

    public ListaImp<T>  aplanarCreciente(){
        ListaImp<T>  lista = new ListaImp<T>();
        aplanarRecCrec(raiz, lista);
        return lista;
    }

    private void aplanarRecCrec(Nodo<T> nodo, ListaImp<T> listaAux){
        if(nodo != null) {
            aplanarRecCrec(nodo.getDer(), listaAux);
            listaAux.insertar(nodo.getDato());
            aplanarRecCrec(nodo.getIzq(), listaAux);
        }
    }

    public ListaImp<T>  aplanarDecreciente(){
        ListaImp<T>  lista = new ListaImp<T>();
        aplanarRecDecrec(raiz, lista);
        return lista;
    }

    private void aplanarRecDecrec(Nodo<T> nodo, ListaImp<T> listaAux){
        if(nodo != null) {
            aplanarRecDecrec(nodo.getIzq(), listaAux);
            listaAux.insertar(nodo.getDato());
            aplanarRecDecrec(nodo.getDer(), listaAux);
        }
    }


}
