# SONORA FASE 3
Até agora, você testou o Sonora manualmente: executava o menu, digitava algumas entradas e verificava se a
saída parecia correta. Isso funciona no início, mas não acompanha o crescimento do projeto. Conforme o
sistema evolui, repetir todos os testes à mão a cada alteração se torna trabalhoso, e um erro antigo pode
voltar sem ser percebido.

Teste unitário e o checklist antes de lançar o foguete: um conjunto de verificações automáticas que roda em
segundos e te avisa na hora se alguma coisa quebrou. Nesta fase você vai transformar aquele testar no olho
em testes de verdade, escritos em JUnit 6, que comprovam o comportamento das suas classes, incluindo as
exceções que você adicionou na Fase 02.

E tem um detalhe honesto: se algum teste seu falhar, pode ser que ele tenha achado um bug que estava
escondido na sua Fase 02. Ótimo. Era exatamente para isso que ele serve.

## Implementações novas:
- Plano de testes

## O que deve ter:
1. Use @Test em cada método e @DisplayName com a descrição do caso (o texto da coluna Descrição).
Assim o relatório de testes fica legível e amarra o código ao plano.

2. Casos normais: use assertEquals, assertTrue, assertFalse, assertNull ou assertNotNull, conforme o caso.

3. Casos de exceção: use assertThrows, verificando o tipo exato da exceção. Não basta estourar, tem que
estourar a exceção certa.

4. Use @BeforeEach para montar o cenário base que se repete (por exemplo, uma Plataforma já com
algumas músicas e um usuário cadastrados), em vez de repetir esse preparo em cada método.
