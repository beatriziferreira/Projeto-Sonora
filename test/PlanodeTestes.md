# Planos de Teste — Sonora Fase 3

## PL03 — Playlist.adicionar(música)

| Caso | Cenário | Entrada | Resultado esperado |
|---|---|---|---|
| PL03.01 | Adicionar uma música com espaço disponível | Playlist vazia + 1 música | Retorna `true` e a quantidade de músicas aumenta para 1 |
| PL03.02 | Adicionar várias músicas | Playlist com espaço + várias músicas diferentes | Retorna `true` para cada música e a quantidade aumenta corretamente |
| PL03.03 | Adicionar música duplicada | Playlist contendo a música + tentativa de adicioná-la novamente | Retorna `false` e a quantidade permanece a mesma |
| PL03.04 | Adicionar música com playlist cheia | Playlist com 100 músicas + tentativa de adicionar a 101ª | Retorna `false` e a quantidade permanece em 100 |

## PL04 — Playlist.getNaPosicao(indice)

| Caso | Cenário | Entrada | Resultado esperado |
|---|---|---|---|
| PL04.01 | Consultar posição válida | Índice de uma música existente | Retorna a música correspondente |
| PL04.02 | Consultar posição negativa | Índice `-1` | Lança `IndexOutOfBoundsException` |
| PL04.03 | Consultar posição além da quantidade | Índice maior ou igual à quantidade de músicas | Lança `IndexOutOfBoundsException` |
| PL04.04 | Consultar última posição válida | Índice da última música da playlist | Retorna corretamente a última música |

## PL05 — Playlist.removerNaPosicao(indice)

| Caso | Cenário | Entrada | Resultado esperado |
|---|---|---|---|
| PL05.01 | Remover a primeira música | Índice `0` | Música é removida e as demais são reorganizadas |
| PL05.02 | Remover uma música do meio | Índice de uma posição intermediária | Música é removida e as posteriores ocupam os espaços corretamente |
| PL05.03 | Remover usando índice negativo | Índice `-1` | Lança `IndexOutOfBoundsException` |
| PL05.04 | Remover usando índice além da quantidade | Índice maior ou igual à quantidade de músicas | Lança `IndexOutOfBoundsException` |

## PL06 — Plataforma.buscarMusica()

| Caso | Cenário | Entrada | Resultado esperado |
|---|---|---|---|
| PL06.01 | Buscar música por título existente | Título de uma música cadastrada | Retorna a música encontrada |
| PL06.02 | Buscar música por título inexistente | Título que não foi cadastrado | Retorna `null` |
| PL06.03 | Buscar música por ID existente | ID de uma música cadastrada | Retorna a música encontrada |
| PL06.04 | Buscar música por ID inexistente | ID que não corresponde a nenhuma música | Retorna `null` |

## PL07 — Musica.reproduzir()

| Caso | Cenário | Entrada | Resultado esperado |
|---|---|---|---|
| PL07.01 | Reproduzir uma vez | Chamar `reproduzir()` uma vez | Contador de reproduções aumenta em 1 |
| PL07.02 | Reproduzir duas vezes | Chamar `reproduzir()` duas vezes | Contador de reproduções aumenta em 2 |
| PL07.03 | Reproduzir cinco vezes | Chamar `reproduzir()` cinco vezes | Contador de reproduções aumenta em 5 |
| PL07.04 | Verificar incremento individual | Realizar chamadas sucessivas a `reproduzir()` | A cada chamada, o contador aumenta exatamente em 1 |

## PL08 — Contadores de ID (Bônus)

| Caso | Cenário | Entrada | Resultado esperado |
|---|---|---|---|
| PL08.01 | Verificar IDs sequenciais das músicas | Criar duas músicas consecutivamente | O ID da segunda música é igual ao ID da primeira + 1 |
| PL08.02 | Verificar sequência após várias músicas | Criar várias músicas consecutivamente | Os IDs são atribuídos em sequência |
| PL08.03 | Verificar independência entre usuários e músicas | Criar uma música e um usuário | Os contadores de ID são independentes |
| PL08.04 | Criar usuário não altera sequência de músicas | Criar uma música, um usuário e outra música | O ID da segunda música continua seguindo a sequência das músicas |
