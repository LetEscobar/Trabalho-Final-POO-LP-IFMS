
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
            System.out.println(" 2 - Buscar por um número na árvore binária");
            System.out.println(" 3 - Imprimir árvore binária completa");
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
                        }
                    } while (numero >= 0 && numero != 0);
                    break;
                case 2:
                    System.out.print("\nInforme o número que deseja procurar: ");
                    numero = lerNumero.nextInt();
                    System.out.println("\n BUSCA");
                    break;
                case 3:
                    System.out.println("Árvore binária completa:");
                    System.out.println("\n PRE-ORDEM:");
                    arvore.preOrdem(arvore.root);

                    System.out.println("\n IN-ORDEM:");
                    arvore.inOrdem(arvore.root);

                    System.out.println("\n POS-ORDEM:");
                    arvore.posOrdem(arvore.root);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}
