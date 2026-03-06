import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a palavra para começar o jogo (até 6 digitos): ");
        String palavra = sc.nextLine().toLowerCase();

        List<Character> list = new ArrayList<>(palavra.length());
        List<Character> listAcertos = new ArrayList<>();
        for (int i = 0; i < palavra.length(); i++) {
            list.add('_');
        }

        int acertos = 0;
        for (int i = 1; i <= 6 ; i++) {
            if (acertos == list.size()) {
                System.out.print("Você venceu!");
                break;
            }

            System.out.print("Digite uma palavra | Tentativa #" + i + ": ");
            char letra = sc.next().toLowerCase().charAt(0);

            if (listAcertos.contains(letra)) {
                System.out.println("Já possui essa letra");
            }
            else {
                for (int j = 0; j < palavra.length(); j++) {

                    char letraPalavra = palavra.charAt(j);

                    if (letraPalavra == letra) {
                        list.remove(j);
                        list.add(j, letra);
                        acertos += 1;
                        listAcertos.add(letra);
                    }
                }
            }
            System.out.println(list);
        }

        if (acertos < list.size()) {
            System.out.println("Você perdeu!");
            System.out.println(list);
        }

        sc.close();
    }
}

