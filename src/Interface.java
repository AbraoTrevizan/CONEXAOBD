package llk;

import java.util.Scanner;

public class Interface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        // esse vai estar fazendo o loop do menu
        boolean rodando = true;

        while (rodando) {
            // vai estar mostrando as opçoes que o usuario pode estar escolhendo
            System.out.println("\n===== Menu =====");
            System.out.println("1. Inserir Aluno");
            System.out.println("2. Mostrar Alunos");
            System.out.println("3. Atualizar Aluno");
            System.out.println("4. Excluir Aluno");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            // vai ler a opçao que o usuario escolheu
            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                continue;
            }

            // vai carregar a opçao que foi escolhida 
            switch (opcao) {
                case 1:
                    // Vai Inserir dados
                    InserirDados.inserirAluno(scanner);
                    break;
                case 2:
                    // Vai Ler os dados que foram fornecidos
                    LerDados.lerAlunos();
                    break;
                case 3:
                    // Atualiza os dados dos alunos
                    AtualizarDados.atualizarAluno(scanner);
                    break;
                case 4:
                    // deleta dados dos alunos
                    DeletarDados.deletarAluno(scanner);
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    rodando = false;  // vai fechar o loop
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}

