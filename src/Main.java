
import abb.ABB;

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


        abb.mostrarDecreciente();

    }
}