
import abb.ABB;
import abb.Nodo;
import lista.ListaImp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        ABB<Integer> abb = new ABB();
        abb.agregar(10);
        abb.agregar(6);
        abb.agregar(18);
        abb.agregar(4);
        abb.agregar(9);
        abb.agregar(15);
        abb.agregar(21);

        ListaImp<Integer> listaCreciente = abb.aplanarCreciente();
        ListaImp<Integer> listaDecreciente = abb.aplanarDecreciente();

        for(int dato: listaCreciente){
            System.out.print(dato);
        }
        System.out.println();

        for(int dato: listaDecreciente){
            System.out.print(dato);
        }



    }
}