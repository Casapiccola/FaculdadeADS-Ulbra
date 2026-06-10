import entities.Carro;
import entities.Moto;
import entities.Veiculo;

import static services.VeiculoService.executarRotina;

void main() {

    Veiculo veiculo = new Veiculo();
    Carro carro = new Carro();
    Moto moto = new Moto();

    System.out.println("VEICULO GERAL");
    executarRotina(veiculo);
    System.out.println("\n");

    System.out.println("CARRO");
    executarRotina(carro);
    System.out.println("\n");

    System.out.println("MOTO");
    executarRotina(moto);
    System.out.println("\n");

}
