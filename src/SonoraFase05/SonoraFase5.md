# SONORA FASE 5
Um detalhe que você já percebeu usando streaming: a plataforma não toca só música. Tem podcast, tem
audiolivro, tem vários tipos de conteúdo convivendo no mesmo app. No fundo, uma música e um podcast têm
muita coisa em comum: os dois têm título, duração, um id, e os dois podem ser reproduzidos.

Nesta fase o Sonora vai reconhecer mais de um tipo de conteúdo, e você vai modelar isso com herança. A ideia
é ter uma superclasse Conteudo, que concentra o que é comum a qualquer conteúdo, e duas subclasses que a
especializam: Musica e Podcast. Assim você reaproveita código e deixa cada subclasse cuidar só do que a torna
diferente.

## Implementações novas:
- Herança

## O que deve ter:
• Herança com extends e a relação "é um(a)".

• Superclasse e subclasse, e a leitura da hierarquia de herança.

• Membros protected e o símbolo # na UML.

• Sobrescrita de método com @Override.

• Reuso do método da superclasse com super.metodo().

• Encadeamento de construtores com super(...).

• A classe Object e a sobrescrita de toString()