package abbInt;

public class AbbInt {

    private Nodo raiz;

    public void agregar (int dato){
        if(raiz == null) raiz = new Nodo(dato);
        else agregar(raiz, dato);
    }

    private void agregar(Nodo nodo, int dato){
        if(nodo.getDato() < dato){
            //Derecha
            if(nodo.getDer() == null) {
                nodo.setDer(new Nodo(dato));
            }else{
                agregar(nodo.getDer(), dato);
            }
        }else{
            //Izquierda
            if(nodo.getIzq() == null){
                nodo.setIzq(new Nodo(dato));
            }else{
                agregar(nodo.getIzq(), dato);
            }
        }
    }

    public boolean existe(int dato){
            return existe(this.raiz, dato);
    }

    private boolean existe(Nodo nodo, int dato ){
        if(nodo == null){
            return false;
        }
        if(nodo.getDato() == dato){
            return true;
        }
        if(nodo.getDato() > dato){
           return existe(nodo.getIzq(), dato);
        }else{
            return existe(nodo.getDer(), dato);
        }
    }

    public void mostrarCreciente(){
        mostrarCrecienteRec(this.raiz);
    }

    private void mostrarCrecienteRec(Nodo nodo) {
        if (nodo != null) {
            mostrarCrecienteRec(nodo.getIzq());
            System.out.print(nodo.getDato() + " ");
            mostrarCrecienteRec(nodo.getDer());
        }
    }

    public void mostrarDecreciente(){
        mostrarDecrecienteRec(raiz);
    }

    private void mostrarDecrecienteRec(Nodo nodo) {
        if (nodo != null) {
            mostrarDecrecienteRec(nodo.getDer());
            System.out.print(nodo.getDato() + " ");
            mostrarDecrecienteRec(nodo.getIzq());
        }
    }

}
