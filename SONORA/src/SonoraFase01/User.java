package SonoraFase01;

public class User {
    private String nome;
    private String email;
    private static int id;

    public User(String nome, String email) {
        this.nome = nome;
        this.email = email;
        id++;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public static int getId() {
        return id;
    }
}
