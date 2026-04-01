public class Pessoa
{
    private string nome;
    private int idade;
    
    public Pessoa(string nome, int idade)
    {
        this.nome = nome;
        this.idade = idade;
    }

    public string GetName()
    {
        return nome;
    }

    public void SetName(String nome)
    {
        this.nome = nome;
    }

    public int GetIdade()
    {
        return idade;
    }

    public void SetIdade(int idade)
    {
        this.idade = idade;
    }

    public void Falar()
    {
        Console.WriteLine($"Olá, meu nome é {nome}");
    }

}