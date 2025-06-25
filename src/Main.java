import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> musicas = new ArrayList<>();
        int opcao;

        //Cadastro 5 musicas
        System.out.println("Digite suas 5 músicas favoritas:");
        for(int i = 0; i < 5; i++) {
            System.out.print("Música " + (i + 1) + ":");
            musicas.add(scanner.nextLine());
        }

        //Menu interativo
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Ver lista de musicas");
            System.out.println("2 - Mudar posição de uma música");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); //limpar buffer

            switch (opcao) {
                case 1:
                    //mostrar lista com indice começando em 1
                    System.out.println("\nSua lista de músicas:");
                    for (int i = 0; i < musicas.size(); i++){
                        System.out.println((i +1) + " - " + musicas.get(i));
                    }
                    break;

                case 2:
                    //Mostrar lista para usuário escolher
                    System.out.println("\nLista atual:");
                    for (int i = 0; i < musicas.size(); i++){
                        System.out.println((i +1) + " - " + musicas.get(i));
                    }

                    System.out.println("\nDigite o número da musica que deseja mover (1 a 5): ");
                    int origem = scanner.nextInt() - 1;
                    System.out.println("Digite a nova posição para essa musica (1 a 5): ");
                    int destino = scanner.nextInt() -1;
                    scanner.nextLine(); // limpar o buffer

                    // Verifica se os índices são válidos
                    if (origem >= 0 && origem < musicas.size() &&
                    destino >= 0 && destino < musicas.size()) {

                        String musica = musicas.get(origem);
                        musicas.remove(origem);
                        musicas.add(destino, musica);

                        System.out.println("\nMusica reposicionada com sucesso!");
                    }else {
                        System.out.println("Índices inválidos. Tente novamente");
                    }
                    break;

                case 0:
                    System.out.println("Encerrandop o programa até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Escolha novamente");

            }
        } while (opcao != 0);

        scanner.close();
    }
}