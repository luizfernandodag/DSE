import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

public class AnagramGenerator {

    /**
     * Gera todos os anagramas possíveis a partir de um grupo de letras distintas.
     * * @param input Uma string contendo o grupo de letras distintas.
     * @return Uma lista de strings, onde cada string é um anagrama.
     * @throws IllegalArgumentException Se a entrada for nula, vazia ou contiver
     * caracteres não-letras.
     */
    public List<String> generateAnagrams(String input) {
        // Validação básica [cite: 11]
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("A entrada não pode ser vazia ou nula.");
        }

        // Converte para minúsculas e remove espaços para simplificar a validação e o processamento
        String cleanInput = input.trim().toLowerCase();

        if (!cleanInput.matches("[a-z]+")) {
            throw new IllegalArgumentException("A entrada deve conter apenas letras.");
        }

        // Validação de letras distintas (assumindo que o problema exige a verificação)
        // O problema original diz "distinct letters" no input, mas o algoritmo funciona mesmo com repetições.
        // Se a validação estrita for necessária:
        if (new HashSet<>(Arrays.asList(cleanInput.split(""))).size() != cleanInput.length()) {
            // Dependendo da interpretação da regra, este erro pode ser ativado ou não.
            // O algoritmo de permutação abaixo gera anagramas (considerando repetições),
            // mas o requisito explicitava "distinct letters".
            // Para ser estrito, poderia-se lançar um erro ou remover duplicatas.
            // Neste exemplo, focaremos na geração de permutação.

            //throw new IllegalArgumentException("A entrada deve conter apenas letras distintas.");

        }

        List<String> result = new ArrayList<>();
        char[] arr = cleanInput.toCharArray();

        // Chamada da função recursiva de permutação.
        permute(arr, 0, arr.length - 1, result);

        return result;
    }

    /**
     * Lógica recursiva para gerar permutações (anagramas) usando a técnica de Backtracking.
     * * A cada nível da recursão, fixamos um caractere na posição 'left' e permutamos
     * os caracteres restantes no subarray (left+1 até right).
     * * @param arr O array de caracteres a ser permutado.
     * @param left O índice inicial da sub-string atual.
     * @param right O índice final da sub-string atual.
     * @param result A lista onde os anagramas gerados são armazenados.
     */
    private void permute(char[] arr, int left, int right, List<String> result) {
        // Caso Base: Se 'left' é igual a 'right', uma permutação completa foi formada.
        if (left == right) {
            result.add(String.valueOf(arr));
        } else {
            // Passo Recursivo: Itera através dos elementos restantes para trocar com a posição 'left'.
            for (int i = left; i <= right; i++) {
                // 1. Ação: Troca o caractere atual (arr[i]) com o caractere na posição 'left'.
                swap(arr, left, i);

                // 2. Chamada Recursiva: Chama a função para o restante do array (left + 1).
                permute(arr, left + 1, right, result);

                // 3. Backtrack: Desfaz a troca para restaurar o estado original e tentar
                //    a próxima permutação na iteração do loop.
                swap(arr, left, i);
            }
        }
    }

    /**
     * Função auxiliar para trocar dois caracteres em um array.
     */
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}