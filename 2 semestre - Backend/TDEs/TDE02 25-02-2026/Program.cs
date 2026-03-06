Console.WriteLine("---Calculadora---");

Console.Write("Digite o primeiro número: ");
double num1 = Convert.ToDouble(Console.ReadLine());

Console.Write("Digite o segundo número: ");
double num2 = Convert.ToDouble(Console.ReadLine());

Console.WriteLine();

double soma = num1 + num2;
double subtracao = num1 - num2;
double multiplicacao = num1 * num2;
double divisao = num1 / num2;

Console.WriteLine(num1 + " + " + num2 + " = " + soma + ".");
Console.WriteLine("{0} - {1} = {2}.", num1, num2, subtracao);
Console.WriteLine($"{num1} X {num2} = {multiplicacao}.");
Console.WriteLine($"{num1} / {num2} = {divisao}");