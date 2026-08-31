# SONORA FASE 2
O Sonora, funciona, compila, faz o cadastro rodar. Mas ele é ingênuo: se você mandar criar uma música com
duração negativa, ele obedece. Se o usuário digitar letra onde era para digitar número, o programa explode na
cara dele com aquela pilha de vermelho no console. Nesta fase a gente resolve isso.

## Implementações novas:
- Tratamento de exceções
- Try e catch
- Throw

## O que deve ter:
1. Tentar cadastrar uma música com título vazio e mostrar que a IllegalArgumentException foi lançada
e tratada (o programa avisa e continua vivo).

2. Tentar cadastrar uma música com duração zero ou negativa e mostrar o mesmo comportamento.

3. Tentar cadastrar um usuário com e-mail sem @ e mostrar a exceção sendo tratada.

4. Pedir getNaPosicao de uma posição que não existe e mostrar que agora vem
IndexOutOfBoundsException (tratada), e não null.

5. Encher a playlist e tentar adicionar a 101a, mostrando que adicionar ainda devolve false (isto continua
sendo retorno, não exceção).

6. Buscar uma música por um id que não existe e mostrar que ainda vem null (também continua retorno).

7. No menu, digitar uma letra onde se espera um número e mostrar que o programa avisa e pede de novo,
sem cair.

8. Disparar um bloco com múltiplos catch e provocar duas exceções diferentes para mostrar cada catch
agindo.

9. Mostrar o finally executando tanto num caso de sucesso quanto num caso de erro.
