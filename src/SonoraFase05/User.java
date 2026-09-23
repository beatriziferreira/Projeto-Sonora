package SonoraFase05;

import java.util.ArrayList;

public class User {
    private String nome;
    private String email;
    private int id;
    ArrayList<User> seguindo = new ArrayList<User>();
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

    public void seguir(User usuario) {
        if (!seguindo.contains(usuario)) {
            seguindo.add(usuario);
            System.out.println("Você está seguindo " + usuario.getNome() + ".");
        } else {
            System.out.println("Você já está seguindo este usuário.");
        }
    }

    public void deixarDeSeguir(User usuario) {
        if (seguindo.contains(usuario)) {
            seguindo.remove(usuario);
            System.out.println("Você deixou de seguir " + usuario.getNome() + ".");
        } else {
            System.out.println("Você não está seguindo este usuário.");
        }
    }

    public ArrayList<User> getSeguindo() {
        return seguindo;
    }

    public void exibirPerfil(User usuario) {
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("E-mail: " + usuario.getEmail());
        System.out.println("ID: " + usuario.getId());
        System.out.println("Seguindo:");
        if (usuario.getSeguindo().isEmpty()) {
            System.out.println(usuario.getNome() + " não está seguindo nenhum usuário.");
        } else {
            for (User user : usuario.getSeguindo()) {
                System.out.println("- " + user.getNome());
            }
        }
    }
}
