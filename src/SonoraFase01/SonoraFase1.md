# SONORA FASE 1

## Implementações:
- Classes e métodos
- Encapsulamento de dados
- Getters e setters
- Membros de classe (static) para gerar identificadores
- Sobrecarga de métodos


## O que deve ter:
1. Cadastrar três músicas e listar o acervo, mostrando os ids saindo 1, 2, 3.

2. Reproduzir uma música três vezes e mostrar getReproducoes() retornando 3.

3. Mostrar getDuracaoFormatada() para 354, 65 e 600 segundos.

4. Cadastrar um usuário, criar uma playlist para ele, adicionar músicas e mostrar
getQuantidade() e getDuracaoTotalSegundos().

5. Encher uma playlist até 100 músicas e tentar adicionar a 101ª, mostrando que
adicionar devolve false e a quantidade continua 100.

6. Remover uma música do meio da playlist e mostrar que não ficou buraco (as
posições seguintes andaram para trás).

7. Buscar uma música por um id que existe e por um id que não existe (o segundo
devolve null).

8. Buscar uma música por título (a versão sobrecarregada).

9. Chamar reproduzirTudo() e mostrar que a contagem de reproduções de todas
as músicas da playlist subiu.