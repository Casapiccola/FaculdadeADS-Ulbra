decimal saldo = 1000.0m;

int escolha = 0;
do
{
    Console.WriteLine("[1] Ver saldo\n[2] Depositar\n[3] Sacar\n[4] Sair");
    Console.Write("Escolha: ");
    escolha = Convert.ToInt32(Console.ReadLine());

    switch (escolha)
    {
        case 1:
            Console.WriteLine(saldo);
            break;
            
        case 2:
            try
            {
                Console.Write("Qual valor deseja depositar? R$");
                decimal valor = Convert.ToDecimal(Console.ReadLine());
                if (valor < 0)
                    {
                        throw new Exception("Não é possível depositar um valor negativo");
                    }
                saldo += valor;  
                break;
            } catch (Exception)
            {
                Console.WriteLine("Não é possível depositar um valor negativo");
                continue;
            }
            
        case 3:
            if (saldo <= 0)
            {
                Console.WriteLine($"Saldo insuficiente para sacar! Saldo: {saldo}");
                Console.Clear();
                break;
            }

            Console.Write("Quanto deseja sacar R$");
            decimal saque = Convert.ToDecimal(Console.ReadLine());

            if ((saldo - saque) < 0)
            {
                Console.WriteLine($"Valor de saque maior que saldo da conta! saldo:R${saldo} | saque:R${saque}");
                continue;
            }
            
            saldo -= saque;
            break;
        case 4:
            Console.WriteLine("Saindo...");
            break;
        default:
            Console.WriteLine("Opção inválida! Digite uma opção válida.");
            continue;
    }

} while (escolha != 4);