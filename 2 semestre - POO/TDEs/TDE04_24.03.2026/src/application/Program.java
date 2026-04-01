package application;

import entities.Triangulo;

public class Program {

    public static void main(String[] args) {

        Triangulo triangulo = new Triangulo(14, 8);

        System.out.println(triangulo.areaTriangulo());
    }

}
