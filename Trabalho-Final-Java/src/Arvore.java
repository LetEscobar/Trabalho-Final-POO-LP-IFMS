import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Arvore {
    No root = null;
    private Connection conn = null;

    // Inserindo os elementos:
    void insert(int valor, No no) {
        // se o nó raiz estiver vazio, vou inserir o elemento nele
        if (no == null) {
            root = new No(valor);
        }
        // se o valor a ser inserido for MENOR que o valor do nó,
        // eu devo inserir à esquerda:
        else if (valor < no.valor) {
            if (no.esquerda == null) {
                no.esquerda = new No(valor);
            } else {
                insert(valor, no.esquerda);
            }
        }
        // se o valor a ser inserido for MAIOR que o valor do nó,
        // eu devo inserir à direita:
        else if (valor > no.valor) {
            if (no.direita == null) {
                no.direita = new No(valor);
            } else {
                insert(valor, no.direita);
            }
        }

        // Salvando os números inseridos no banco
        this.conn = ConnectionFactory.createConnection();
        String noSQL = "INSERT INTO tree (node) VALUES (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(noSQL);
            ps.setInt(1, valor);

            ps.executeUpdate();

            System.out.println("Nó inserido!");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // imprimindo preOrdem
    // raiz - esquerda - direita
    void preOrdem(No no) {
        System.out.print(" " + no.valor);
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
        System.out.print(" " + no.valor);
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
        System.out.print(" " + no.valor);
    }
}
