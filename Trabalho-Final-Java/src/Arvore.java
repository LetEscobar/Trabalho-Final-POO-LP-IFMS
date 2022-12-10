public class Arvore {
    No root = null;

    // Inserindo elementos
    void insert(int info, No local) {
        // se o nó estiver vazio:
        if (local == null) {
            System.out.print(" " + info);
            root = new No(info);
        }
        // se o valor a ser inserido for MENOR que o valor do nó,
        // eu devo inserir à esquerda:
        else if (info < local.info) {
            if (local.esquerda == null) {
                System.out.print(" " + info);
                local.esquerda = new No(info);
            } else {
                insert(info, local.esquerda);
            }
        }
        // se o valor a ser inserido for MAIOR que o valor do nó,
        // eu devo inserir à direita:
        else if (info > local.info) {
            if (local.direita == null) {
                System.out.print(" " + info);
                local.direita = new No(info);
            } else {
                insert(info, local.direita);
            }
        }
    }

    // imprimindo em preOrdem
    void preOrdem(No local) {
        System.out.print(" " + local.info);
        if (local.esquerda != null) {
            preOrdem(local.esquerda);
        }
        if (local.direita != null) {
            preOrdem(local.direita);
        }
    }

    // imprimindo inOrdem
    void inOrdem(No local) {
        if (local.esquerda != null) {
            inOrdem(local.esquerda);
        }
        System.out.print(" " + local.info);
        if (local.direita != null) {
            inOrdem(local.direita);
        }
    }

    // imprimindo posOrdem
    void posOrdem(No local) {
        if (local.esquerda != null) {
            posOrdem(local.esquerda);
        }
        if (local.direita != null) {
            posOrdem(local.direita);
        }
        System.out.print(" " + local.info);
    }
}
