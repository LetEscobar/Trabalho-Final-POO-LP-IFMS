import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Arvore {
    No root = null;
    private Connection conn = null;

    // Inserindo os elementos:
    void insert(int valor, No no) {
        if (no == null) {
            root = new No(valor);
            inserirNoBanco(valor);
        }

        else if (valor < no.valor) {
            if (no.esquerda == null) {
                no.esquerda = new No(valor);
                inserirNoBanco(valor);
            } else {
                insert(valor, no.esquerda);
            }
        }

        else if (valor > no.valor) {
            if (no.direita == null) {
                no.direita = new No(valor);
                inserirNoBanco(valor);
            } else {
                insert(valor, no.direita);
            }
        }

        else if (valor == no.valor) {
            System.out.println("Esse número já foi inserido.");
        }

    }

    public void inserirNoBanco(int valor) {
        this.conn = ConnectionFactory.createConnection();
        String noSQL = "INSERT INTO tree (node) VALUES (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(noSQL);
            ps.setInt(1, valor);

            ps.executeUpdate();

            System.out.println("Valor inserido no banco!");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // public No getOne(int valor) {
    // String sql = "SELECT * FROM tree WHERE node = ?";
    // No node = new No(valor);

    // try {
    // PreparedStatement ps = this.conn.prepareStatement(sql);
    // ps.setInt(1, valor);

    // ResultSet result = ps.executeQuery(sql);

    // while (result.next()) {
    // u.setId(rs.getInt("id"));
    // }

    // } catch (SQLException e) {
    // System.out.println("Error: Não foi possível encontrar o valor!");
    // }

    // return node;
    // }

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
