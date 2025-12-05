import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramGeneratorTest {

    private final AnagramGenerator generator = new AnagramGenerator();

    /**
     * Caso de Teste 1: Caso de uso básico (exemplo do problema: {a, b, c} [cite: 8])
     */
    @Test
    public void testBasicCase() {
        String input = "abc";
        List<String> expected = List.of("abc", "acb", "bac", "bca", "cab", "cba");
        List<String> actual = generator.generateAnagrams(input);

        // Verifica se o número de anagramas é o esperado (n!). 3! = 6.
        assertEquals(expected.size(), actual.size());

        // Verifica se todos os anagramas esperados estão presentes no resultado.
        assertTrue(actual.containsAll(expected));
    }

    /**
     * Caso de Teste 2: Caso de borda - Entrada com um único caractere 
     */
    @Test
    public void testSingleLetterInput() {
        String input = "a";
        List<String> expected = List.of("a");
        List<String> actual = generator.generateAnagrams(input);

        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
    }

    /**
     * Caso de Teste 3: Caso de borda - Entrada vazia 
     */
    @Test
    public void testEmptyInput() {
        // Espera-se uma exceção para entrada vazia[cite: 11].
        assertThrows(IllegalArgumentException.class, () -> {
            generator.generateAnagrams("");
        }, "Deve lançar IllegalArgumentException para entrada vazia.");
    }

    /**
     * Caso de Teste Adicional: Entrada nula
     */
    @Test
    public void testNullInput() {
        // Espera-se uma exceção para entrada nula[cite: 11].
        assertThrows(IllegalArgumentException.class, () -> {
            generator.generateAnagrams(null);
        }, "Deve lançar IllegalArgumentException para entrada nula.");
    }

    /**
     * Caso de Teste Adicional: Entrada com caracteres não-letras
     */
    @Test
    public void testNonLetterInput() {
        // Espera-se uma exceção para entrada com caracteres não-letras[cite: 11].
        assertThrows(IllegalArgumentException.class, () -> {
            generator.generateAnagrams("ab1");
        }, "Deve lançar IllegalArgumentException para entrada com caracteres não-letras.");
    }

    /**
     * Caso de Teste Adicional: Entrada com 4 letras
     */
    @Test
    public void testFourLettersInput() {
        String input = "test"; // 't', 'e', 's'
        // Se a entrada fosse "abcd", 4! = 24.
        // Como o algoritmo lida com repetições (embora a regra fosse "distinct"), para 't', 'e', 's', 't'
        // ele geraria 24 strings, mas com 12 únicas.

        // Pelo requisito "distinct letters", vamos testar com "abcd" para garantir 24 resultados únicos.
        String distinctInput = "abcd";
        List<String> actual = generator.generateAnagrams(distinctInput);

        // 4! = 24.
        assertEquals(24, actual.size());
    }
}