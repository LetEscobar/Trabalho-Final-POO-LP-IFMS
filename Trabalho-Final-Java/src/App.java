
// import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ConnectionFactory.createConnection();
        Arvore arvore = new Arvore();

        int opcao = 0;
        do {
            Scanner lerOpcao = new Scanner(System.in);
            Scanner lerNumero = new Scanner(System.in);

            System.out.println("\n--------------------------------------------");
            System.out.println(" 1 - Inserir números na árvore binária");
            System.out.println(" 2 - Imprimir árvore binária");
            System.out.println(" 0 - Sair");
            System.out.println("--------------------------------------------");
            System.out.print("Escolha uma das opções: ");
            opcao = lerOpcao.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
                case 1:
                    System.out.println("\nInforme os números que deseja inserir e digite 0 para encerrar: ");
                    int numero;
                    do {
                        System.out.print("Digite um número: ");
                        numero = lerNumero.nextInt();
                        if (numero != 0) {
                            arvore.insert(numero, arvore.root);
                            arvore.inserirNoBanco(numero);
                        }
                    } while (numero != 0);
                    break;
                case 2:
                    System.out.print("\nÁrvore binária:");
                    System.out.println("\n Pré-ordem::");
                    arvore.preOrdem(arvore.root);

                    System.out.println("\n In-ordem:");
                    arvore.inOrdem(arvore.root);

                    System.out.println("\n Pós-ordem:");
                    arvore.posOrdem(arvore.root);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}
