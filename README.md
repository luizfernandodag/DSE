# Gerador de Anagramas em Java

Este projeto implementa uma classe **AnagramGenerator** responsável por
gerar todos os anagramas possíveis de uma string composta por letras
distintas. O projeto também inclui uma suíte de testes unitários
utilizando **JUnit**.

------------------------------------------------------------------------

## 📌 Funcionalidades

-   Geração de **todas as permutações possíveis** (anagramas) de uma
    string.
-   Validação de entrada:
    -   Não permite `null`
    -   Não permite string vazia
    -   Aceita apenas letras (`a-z`, case insensitive)
-   Implementação baseada em **backtracking recursivo**.
-   Suporte automático a inputs com letras repetidas (embora o problema
    original assuma letras distintas).

------------------------------------------------------------------------

## 🧠 Lógica Principal

A classe `AnagramGenerator` segue este fluxo:

1.  **Valida a entrada**
    -   Remove espaços
    -   Converte para minúsculas
    -   Verifica se contém somente letras
    -   Opcionalmente verifica se são distintas
2.  **Gera anagramas**
    -   Converte a string para um array de caracteres
    -   Utiliza backtracking com permutação clássica
    -   Armazena cada permutação completa em uma lista de resultados

------------------------------------------------------------------------

## 🧪 Testes Unitários

Os testes validam:

### ✔ Caso básico

-   Entrada: `"abc"`
-   Saída: 6 anagramas (`3!`)

### ✔ Entrada com um caractere

-   Deve retornar lista contendo somente o mesmo caractere.

### ✔ Entrada nula ou vazia

-   Deve lançar `IllegalArgumentException`

### ✔ Entrada com caracteres inválidos

-   `"ab1"` → exceção esperada

### ✔ Entrada de 4 letras distintas

-   `"abcd"` → deve gerar exatamente **24** anagramas (`4!`)

------------------------------------------------------------------------

## 📂 Estrutura do Projeto

    src/
     ├── main/
     │   └── java/
     │       └── AnagramGenerator.java
     └── test/
         └── java/
             └── AnagramGeneratorTest.java

------------------------------------------------------------------------

## ▶ Como Executar

1.  Compile o projeto:

``` bash
javac AnagramGenerator.java
```

2.  Execute os testes (via Maven, Gradle ou JUnit no IDE):

``` bash
mvn test
```

------------------------------------------------------------------------

## 📄 Licença

Projeto de uso livre para fins acadêmicos, didáticos e portfólio.
