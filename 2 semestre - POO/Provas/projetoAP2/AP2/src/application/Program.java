import services.GeneroService;
import services.LivroService;

void main() {

    GeneroService generoService = new GeneroService();
    LivroService livroService = new LivroService(generoService);

    Integer escolha = null;
    do {

        livroService.menu();
        escolha = Integer.parseInt(IO.readln("Escolha: "));




    } while (escolha != 0);

}
