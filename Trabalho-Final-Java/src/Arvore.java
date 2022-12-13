public class Arvore {
    No root = null;

    // Inserindo os elementos:
    void insert(int info, No no) {
        // se o nó raiz estiver vazio, vou inserir o elemento nele
        if (no == null) {
            root = new No(info);
        }
        // se o valor a ser inserido for MENOR que o valor do nó,
        // eu devo inserir à esquerda:
        else if (info < no.info) {
            if (no.esquerda == null) {
                no.esquerda = new No(info);
            } else {
                insert(info, no.esquerda);
            }
        }
        // se o valor a ser inserido for MAIOR que o valor do nó,
        // eu devo inserir à direita:
        else if (info > no.info) {
            if (no.direita == null) {
                no.direita = new No(info);
            } else {
                insert(info, no.direita);
            }
        }
    }

    // imprimindo preOrdem
    // raiz - esquerda - direita
    void preOrdem(No no) {
        System.out.print(" " + no.info);
        if (no.esquerda != null) {
            preOrdem(no.esquerda);
        }
        if (no.direita != null) {
            preOrdem(no.direita);
        }
    }

    // imprimindo inOrdem
    // esquerda - raiz - direita
    void inOrdem(No no) {
        if (no.esquerda != null) {
            inOrdem(no.esquerda);
        }
        System.out.print(" " + no.info);
        if (no.direita != null) {
            inOrdem(no.direita);
        }
    }

    // imprimindo posOrdem
    // esquerda - direita - raiz
    void posOrdem(No no) {
        if (no.esquerda != null) {
            posOrdem(no.esquerda);
        }
        if (no.direita != null) {
            posOrdem(no.direita);
        }
        System.out.print(" " + no.info);
    }
}
