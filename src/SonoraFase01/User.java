package SonoraFase01;

public class User {
    private String nome;
    private String email;
    private int id;
    private static int contador;

    public User(String nome, String email) {
        this.nome = nome;
        this.email = email;
        contador++;
        id = contador;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
