import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random rand = new Random();
        Arvore arvore = new Arvore();

        for (int i = 0; i < 10; i++) {
            arvore.insert(rand.nextInt(100), arvore.root);
        }

        System.out.println("\n PRE-ORDEM:");
        arvore.preOrdem(arvore.root);

        System.out.println("\n IN-ORDEM:");
        arvore.inOrdem(arvore.root);

        System.out.println("\n POS-ORDEM:");
        arvore.posOrdem(arvore.root);
    }
}
