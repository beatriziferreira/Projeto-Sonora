package SonoraFase01;
public class App {
    public static void main(String[] args) {
        Musica musica1 = new Musica("Song 1", "Artist 1", 180);
        System.out.println("ID: " + Musica.getId());

        Musica musica2 = new Musica("Song 2", "Artist 2", 240);
        System.out.println("ID: " + Musica.getId());

        Musica musica3 = new Musica("Song 3", "Artist 3", 300);
        System.out.println("ID: " + Musica.getId());
    }
}
