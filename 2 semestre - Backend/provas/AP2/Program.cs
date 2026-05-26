using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddDbContext<AppDbContext>(options =>
    options.UseSqlite("Data Source=funcionarios.db"));

var app = builder.Build();

using (var scope = app.Services.CreateScope())
{
    var db = scope.ServiceProvider.GetRequiredService<AppDbContext>();
    db.Database.EnsureCreated();
}

app.MapGet("/", () =>
{
    return Results.Ok("API de Funcionários - Minimal API com .NET");
});

app.MapGet("/status", () =>
{
    return Results.Ok(new
    {
        status = "online",
        mensagem = "API funcionando",
        dataHora = DateTime.Now
    });
});

// Listar todos os funcionários
app.MapGet("/funcionarios", async (AppDbContext db) =>
{
    var funcionarios = await db.Funcionarios.ToListAsync();
    return Results.Ok(funcionarios);
});

// Buscar funcionário por ID
app.MapGet("/funcionarios/{id}", async (int id, AppDbContext db) =>
{
    var funcionario = await db.Funcionarios.FindAsync(id);

    if (funcionario == null)
        return Results.NotFound("Funcionário não encontrado.");

    return Results.Ok(funcionario);
});

// Cadastrar funcionário
app.MapPost("/funcionarios", async (Funcionario funcionario, AppDbContext db) =>
{
    if (string.IsNullOrWhiteSpace(funcionario.Nome))
        return Results.BadRequest("O nome é obrigatório.");

    db.Funcionarios.Add(funcionario);
    await db.SaveChangesAsync();

    return Results.Created($"/funcionarios/{funcionario.Id}", funcionario);
});

// Atualizar funcionário
app.MapPut("/funcionarios/{id}", async (int id, Funcionario dadosAtualizados, AppDbContext db) =>
{
    var funcionario = await db.Funcionarios.FindAsync(id);

    if (funcionario == null)
        return Results.NotFound("Funcionário não encontrado.");

    funcionario.Nome = dadosAtualizados.Nome;
    funcionario.Cargo = dadosAtualizados.Cargo;
    funcionario.Salario = dadosAtualizados.Salario;
    funcionario.Ativo = dadosAtualizados.Ativo;
    funcionario.DataAdmissao = dadosAtualizados.DataAdmissao;

    await db.SaveChangesAsync();

    return Results.Ok(funcionario);
});

// Excluir funcionário
app.MapDelete("/funcionarios/{id}", async (int id, AppDbContext db) =>
{
    var funcionario = await db.Funcionarios.FindAsync(id);

    if (funcionario == null)
        return Results.NotFound("Funcionário não encontrado.");

    db.Funcionarios.Remove(funcionario);

    await db.SaveChangesAsync();

    return Results.NoContent();
});

app.Run();
