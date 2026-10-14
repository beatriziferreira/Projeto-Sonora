package SonoraFase07;

import java.util.ArrayList;

public class User {
    private String nome;
    private String email;
    private int id;
    private ArrayList<User> seguindo = new ArrayList<>();
    private static int contador;
    private Plano plano;

    public User(String nome, String email) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("O nome do usuário não pode ser nulo ou vazio.");
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("O e-mail deve apresentar @.");
        this.nome = nome; this.email = email; this.id = ++contador; this.plano = new PlanoGratuito();
    }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public int getId() { return id; }
    public Plano getPlano() { return plano; }
    public void assinar(Plano novoPlano) {
        if (novoPlano == null) throw new IllegalArgumentException("O plano não pode ser nulo.");
        this.plano = novoPlano;
    }
    public void seguir(User usuario) {
        if (usuario == null) throw new IllegalArgumentException("Usuário inválido.");
        if (!seguindo.contains(usuario)) { seguindo.add(usuario); System.out.println("Você está seguindo " + usuario.getNome() + "."); }
        else System.out.println("Você já está seguindo este usuário.");
    }
    public void deixarDeSeguir(User usuario) {
        if (seguindo.remove(usuario)) System.out.println("Você deixou de seguir " + usuario.getNome() + ".");
        else System.out.println("Você não está seguindo este usuário.");
    }
    public ArrayList<User> getSeguindo() { return new ArrayList<>(seguindo); }
    public void exibirPerfil(User usuario) {
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("E-mail: " + usuario.getEmail());
        System.out.println("ID: " + usuario.getId());
        System.out.println("Seguindo:");
        if (usuario.getSeguindo().isEmpty()) System.out.println(usuario.getNome() + " não está seguindo nenhum usuário.");
        else for (User u : usuario.getSeguindo()) System.out.println("- " + u.getNome());
    }
}
