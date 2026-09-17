# SONORA FASE 4
Até agora o Sonora guardou tudo em vetores de tamanho fixo: a Playlist tem espaço para 100 músicas, a
Plataforma para 500 músicas e 500 usuários. Além disso, as relações entre as classes existiam de forma
implícita, escondidas dentro desses vetores e de atributos soltos. Nesta fase você vai fazer duas coisas que
andam juntas: primeiro desenhar, em UML, como as classes do Sonora se relacionam de verdade, com todos
os adornos(papel, nome, multiplicidade e navegabilidade) ; depois trocar os vetores por ArrayList, que é a
estrutura que o Java oferece para guardar uma quantidade que cresce sozinha.

O pulo do gato é perceber que as duas coisas conversam. Quando você modela um relacionamento como um
para muitos, aquele lado muitos vira, no código, uma coleção. É aí que o ArrayList entra

## Implementações novas:
- Array List

## O que deve ter:
• Playlist. O array de músicas vira ArrayList<Musica>. Os métodos adicionar, getNaPosicao,
removerNaPosicao, getDuracaoTotalSegundos e reproduzirTudo passam a usar add, get, remove e size.
A contagem manual de quantidade sai de cena: quem responde isso agora é o size().

• Plataforma. Os arrays de músicas e de usuários viram ArrayList<Musica> e ArrayList<Usuario>. As buscas
percorrem a lista com for ou for-each.

• Usuario. Ganha a coleção da associação reflexiva: um ArrayList<Usuario> com os usuários que este
usuário segue.

• seguir(Usuario outro) - adiciona outro à lista de seguindo. Um usuário não deve seguir a si mesmo nem
seguir duas vezes o mesmo usuário.

• deixarDeSeguir(Usuario outro) - remove outro da lista de seguindo.

• getQuantidadeSeguindo() - retorna quantos usuários este usuário segue.

No App, adicione ao menu as opções para um usuário seguir e deixar de seguir outro, e para listar quem um
usuário segue. Trate as entradas inválidas com o que você já aprendeu sobre exceções.