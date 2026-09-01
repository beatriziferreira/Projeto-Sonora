package SonoraFase02;

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
        if (this.nome == null){
            throw new IllegalArgumentException("O nome do usuário não pode ser nulo.");
        }
        if (this.email == null || !this.email.contains("@")){
            throw new IllegalArgumentException("O e-mail do usuário não pode ser nulo e deve apresentar o @.");
        }
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
