package ab;

public class AB {

    private Nodo raiz;

    public AB(Nodo raiz) {
        this.raiz = raiz;
    }

    public int cantNodos() {
        return cantNodosRec(raiz);
    }

    private int cantNodosRec(Nodo nodo) {
        //1.- Casos base
        if(nodo == null){
            return 0;
        }
        //2.- Llamadas recursivas
        int cantNodosIzq = cantNodosRec(nodo.getIzq());//3
        int cantNodosDer = cantNodosRec(nodo.getDer());//2

        //3.- Unir resultados
        return 1 + cantNodosDer + cantNodosIzq;

    }

    public int cantHojas(){
        return cantHojasRec(raiz);
    }

    private int cantHojasRec(Nodo nodo) {
        if(nodo == null){
            return 0;
        }

        //1.- Casos base
        if(nodo.getDer() == null && nodo.getIzq() == null){
            return 1;
        }
        //2.- Llamadas recursivas
        int cantHojasIzq = cantHojasRec(nodo.getIzq());
        int cantHojasDer = cantHojasRec(nodo.getDer());

        //3.- Unir resultados
        return cantHojasDer + cantHojasIzq;

    }

    public int altura(){
        return alturaRec(raiz);
    }

    private int alturaRec(Nodo nodo) {
        if(nodo == null){
            return -1;
        }
        if(nodo.getIzq() == null && nodo.getDer() == null){
            return 0;
        }

        int alturaIzq = alturaRec(nodo.getIzq());
        int alturaDer = alturaRec(nodo.getDer());

        return 1 + Math.max(alturaDer, alturaIzq);
    }

    public boolean todosPares(){
        return todosParesRec(raiz);
    }

    private boolean todosParesRec(Nodo nodo) {
        //1
        if(nodo == null){
            return true;
        }
        if(nodo.getDato() % 2 != 0 ){
            return false;
        }
        //2
        boolean sonTodosParesIzq =  todosParesRec(nodo.getIzq());
        boolean sonTodosParesDer =  todosParesRec(nodo.getDer());
        //3
        return sonTodosParesIzq && sonTodosParesDer;
    }

    private boolean todosParesRecV2(Nodo nodo) {
        //1
        if(nodo == null){
            return true;
        }
        if(nodo.getDato() % 2 != 0 ){
            return false;
        }

        //2 y 3
        return todosParesRecV2(nodo.getIzq()) && todosParesRecV2(nodo.getDer());
    }

    private boolean todosParesRecV3(Nodo nodo) {
        if(nodo == null){
            return true;
        }
        return nodo.getDato() % 2 == 0  && todosParesRecV3(nodo.getIzq()) && todosParesRecV3(nodo.getDer());
    }

    boolean pertenece(int x){
        return perteneceRec(raiz, x);
    }

    private boolean perteneceRec(Nodo nodo, int x) {
        if(nodo == null){
            return false;
        }
        if(nodo.getDato() == x){
            return true;
        }
        return perteneceRec(nodo.getIzq(), x) || perteneceRec(nodo.getDer(), x);
    }

    public boolean equilibrado(){
        return equilibradoRec(raiz);
    }

    private boolean equilibradoRec(Nodo nodo) {
        if(nodo == null){
            return true;
        }
        int alturaIzq = alturaRec(nodo.getIzq());
        int alturaDer = alturaRec(nodo.getDer());
        if( Math.abs(alturaIzq-alturaDer) > 1 ){
            return false;
        }
        return equilibradoRec(nodo.getIzq()) && equilibradoRec(nodo.getDer());
    }

    public boolean iguales(AB a){
        return igualesRec(raiz, a.raiz);
    }

    private boolean igualesRec(Nodo nodo1, Nodo nodo2) {
        if(nodo1 == null && nodo2 == null){ //los dos null
            return true;
        }
        if(nodo1 == null || nodo2 == null){ //solo 1 es null
            return false;
        }
        if(nodo1.getDato() != nodo2.getDato()){
            return false;
        }
        return igualesRec(nodo1.getDer(), nodo2.getDer()) && igualesRec(nodo1.getIzq(), nodo2.getIzq());


    }



}
