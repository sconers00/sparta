package calculators.calculator2.calculator3;

import java.util.Scanner;

public class GenericInput<T> {

    private T item;

    public void GenericBox(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }

    public T Generics() {
        Scanner sc2 = new Scanner(System.in);
        T gen = (T) sc2.nextLine();
        return gen;
    }

}