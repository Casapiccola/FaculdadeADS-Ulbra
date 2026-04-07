/* ATIVIDADE 1

int[] notas = { 1, 2, 3, 4, 5 };

for (int i = 0; i < notas.Length; i++)
{
    Console.WriteLine("Nota " + i + ": " + notas[i]);
}

*/

/* ATIVIDADE 2

double[] temperaturas = { 0.0, 15.5, 8.0, 24.0, 30.0, 12.5 };

double sum = 0.0;
for (int i = 0; i < temperaturas.Length; i++)
{
    sum += temperaturas[i]; 
}

Console.WriteLine($"Soma = {sum:F2}");
Console.WriteLine($"Média = {sum / temperaturas.Length:F2}");

*/

/* ATVIDADE 3

int[] numeros = { 1, 5, 20, 11, 0, 3, 5, 17 };

int maior = numeros[0];
foreach (int numero in numeros)
{
    if (numero > maior)
    {
        maior = numero;
    }
}

Console.WriteLine($"O maior número do array é: {maior}");

*/

/* ATIVIDADE 4

string[] palavras = { "C#", "é", "muito", "legal" };

for (int i = palavras.Length - 1; i >= 0 ; i--)
{
    Console.Write(palavras[i] + " ");
}

*/


/* ATIVIDADE 5

int[] numerosPares_Impares = { 1, 5, 20, 11, 0, 3, 5, 17, 9, 10 };

int numPares = 0;
int numImpares = 0;
int numNulos = 0;
for (int i = 0; i < numerosPares_Impares.Length; i++)
{
    if (numerosPares_Impares[i] == 0)
    {
        numNulos++;
    }
    else if (numerosPares_Impares[i] % 2 == 0)
    {
        numPares++;
    }
    else
    {
        numImpares++;
    }
}

Console.WriteLine("Números pares: " + numPares);
Console.WriteLine("Números impares: " + numImpares);
Console.WriteLine("Números nulos: " + numNulos);

*/


/* ATIVIDADE 6

List<string> compras = new List<string> {"Maça", "Chocolate", "Arroz"};

compras.Add("Banana");
compras.Add("Massa");

compras.Remove("Maça");

foreach (string item in compras)
{
    Console.Write(item + " ");
}

Console.WriteLine("\nTotal de itens: " + compras.Count);

*/


/* ATIVIDADE 7


List<int> numerosInteiros = new List<int> { 10, 20, 30, -100, -2, -10, 2, 4, -5, 29};

List<int> numerosInteirosPositivos = new List<int>();
List<int> numerosInteirosNegativos = new List<int>();

foreach (int numero in numerosInteiros)
{
    if (numero > 0)
    {
        numerosInteirosPositivos.Add(numero);
    }
    else
    {
        numerosInteirosNegativos.Add(numero);
    }
}

Console.WriteLine(string.Join(", ", numerosInteirosPositivos));
Console.WriteLine(string.Join(", ", numerosInteirosNegativos));

*/

/* ATIVIDADE 8

List<string> nomes = new List<string> { "Ana", "Carlos", "Ana", "Beatriz", "Carlos", "Diana", "Ana" };
List<string> nomesNaoRepetidos = new List<string>();

foreach (string nome in nomes)
{
    if (!nomesNaoRepetidos.Contains(nome))
    {
        nomesNaoRepetidos.Add(nome);
    }
}

Console.WriteLine(string.Join(", ", nomesNaoRepetidos));

*/


/* ATIVIDADE 9

List<string> alunos = new List<string>();

int resposta;
do
{
    Console.Write("MENU\n" +
"1 - Adicionar aluno\n" +
"2 - Remover aluno\n" +
"3 - Listar alunos\n" +
"4 - Buscar aluno por nome\n" +
"5 - Sair\n" +
"Escolha: ");
    resposta = Convert.ToInt32(Console.ReadLine());
    
    switch (resposta) {
        case 1:
            Console.Write("Digite o nome do aluno para adicionar: ");
            alunos.Add(Console.ReadLine());
            break;
        case 2:
             Console.Write("Digite o nome do aluno para remover: ");
            alunos.Remove(Console.ReadLine());
            break;
        case 3:
            alunos.ForEach(Console.WriteLine);
            break;
        case 4:
            Console.Write("Digite o nome para buscar: ");
            if (alunos.Contains(Console.ReadLine()))
            {
                Console.WriteLine("Nome encontrado na lista");
            }
            else
            {
                Console.WriteLine("Nome não encontrado na lista");
            }
            break;
        case 5:
            Console.WriteLine("Saindo...");
            break;
        default:
            Console.WriteLine("Selecione uma opção válida!");
            continue;
    }

} while (resposta != 5);

*/

