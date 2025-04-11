
import java.util.ArrayList;
import java.util.List;


public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		AnagramGenerator anagramas = new AnagramGenerator();
		
		System.out.println(anagramas.generateAnagrams("abc"));
	}
}

class AnagramGenerator {

    /**
     * Gera todos os anagramas possíveis a partir de um conjunto de letras distintas.
     * 
     * @param input String com letras distintas (ex: "abc")
     * @return Lista com todos os anagramas possíveis
     * @throws IllegalArgumentException se a entrada for vazia ou contiver caracteres não alfabéticos
     */
    public static List<String> generateAnagrams(String input) {
        // Validação de entrada
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("A entrada não pode ser vazia.");
        }

        if (!input.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("A entrada deve conter apenas letras.");
        }

        List<String> result = new ArrayList<>();
        char[] chars = input.toCharArray();
        backtrack(chars, 0, result);
        return result;
    }

    // Algoritmo de permutação usando backtracking
    private static void backtrack(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            backtrack(chars, index + 1, result);
            swap(chars, i, index); // desfaz a troca
        }
    }

    // Troca dois caracteres de posição no array
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
