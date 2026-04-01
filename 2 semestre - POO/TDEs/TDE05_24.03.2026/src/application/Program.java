package application;

import entities.Data;

import java.time.DateTimeException;

public class Program {

    public static void main(String[] args) {

        try {
            Data data1 = new Data(31, 2, 2000);
        }
        catch (DateTimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            Data data2 = new Data(15, 13, 2000);
        }
        catch (DateTimeException e) {
            System.out.println(e.getMessage());
        }

        Data dataCorreta = new Data(17, 10, 2006);
        System.out.println(dataCorreta);

    }

}
