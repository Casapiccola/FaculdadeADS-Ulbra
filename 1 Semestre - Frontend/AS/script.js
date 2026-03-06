function formatarData() {
    const agora = new Date();
    return agora.toLocaleString("pt-BR");
}
    
document.getElementById("btnAdd").addEventListener("click", function () {

    const nome = document.getElementById("nome-tarefa").value;
    const prioridade = document.getElementById("prioridade").value;

    if (nome.trim() === "") {
        alert("Digite um nome para a tarefa!");
        return;
    }

    const lista = document.getElementById("listaPendentes");

    const tarefa = document.createElement("div");
    tarefa.classList.add("tarefa-item");

    let classePrioridade = "";
    if (prioridade === "alta") classePrioridade = "bg-red";
    if (prioridade === "media") classePrioridade = "bg-yellow";
    if (prioridade === "baixa") classePrioridade = "bg-green";

    tarefa.classList.add(classePrioridade);

    const dataCriacao = formatarData();

    tarefa.innerHTML = `
        <div>
            <strong>${nome}</strong><br>
            <small>Criada em: ${dataCriacao}</small>
        </div>

        <div>
            <button class="concluir">✔</button>
            <button class="remover">✘</button>
        </div>
    `;

    tarefa.querySelector(".remover").addEventListener("click", function () {
        tarefa.remove();
    });

    tarefa.querySelector(".concluir").addEventListener("click", function () {
        const listaConc = document.getElementById("listaConcluidas");

        const tarefaConcluida = document.createElement("div");
        tarefaConcluida.classList.add("tarefa-item", classePrioridade);

        tarefaConcluida.innerHTML = `
            <div>
                <strong>${nome}</strong><br>
                <small>Criada em: ${dataCriacao}</small><br>
                <small>Concluída em: ${formatarData()}</small>
            </div>
        `;

        listaConc.appendChild(tarefaConcluida);
        tarefa.remove();
    });

    lista.appendChild(tarefa);

    document.getElementById("nome-tarefa").value = "";
});
