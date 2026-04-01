package application;

import models.entities.Hora;

import java.time.DateTimeException;

public class Program {

    public static void main(String[] args) {

        try {
            Hora hora = new Hora(29, 20, 33);
        }
        catch (DateTimeException e) {
            System.out.println(e.getMessage());
        }

        Hora hora1 = new Hora(20, 30, 47);

        System.out.println(hora1);

    }
}
