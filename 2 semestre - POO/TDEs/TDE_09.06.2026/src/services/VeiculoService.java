package services;

import entities.Carro;
import entities.interfaces.Manutivel;
import entities.Moto;
import entities.Veiculo;

public class VeiculoService {

    public static void executarRotina(Manutivel veiculo) {

        veiculo.realizarManutencao();
        veiculo.verificarStatus();

        if (veiculo instanceof Veiculo v) {
            v.acelerar();
            v.frear();
        }

        if (veiculo instanceof Carro c) {
            c.abrirPorta();
            c.ligarAr();
        }

        if (veiculo instanceof Moto m) {
            m.empinar();
            m.trocarmarcha();

            m.conectarBluetooth();
            m.sincronizarDados();
        }

    }
}