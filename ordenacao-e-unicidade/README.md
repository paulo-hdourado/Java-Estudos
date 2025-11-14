# Estudo: Ordenação e Unicidade em Java (Streams)

Este projeto é um exercício prático para demonstrar os conceitos fundamentais de manipulação de coleções em Java.

## Conceitos Aplicados

1.  **Unicidade (`.distinct()`):**
    * Demonstra como o `.distinct()` de um Stream utiliza os métodos `.equals()` e `.hashCode()` para remover duplicatas.
    * Na classe `Pessoa`, a unicidade é definida pelo atributo `cpf`.

2.  **Ordenação (`.sorted()` vs. `List.sort()`):**
    * **`List.sort()`**: Mostra como este método modifica permanentemente a lista original.
    * **`stream().sorted()`**: Mostra como este método cria uma "visão" ordenada dos dados para o stream, sem alterar a lista original.

3.  **Expressões Lambda:**
    * Uso de Lambdas para criar instâncias de `Comparator` de forma limpa e rápida, permitindo ordenação por múltiplos critérios (nome e id).

4.  **`toString()` vs. Métodos de Impressão:**
    * Demonstra o uso do `@Override toString()` na classe `Pessoa` e como ele é invocado automaticamente pelo `System.out.println()`.