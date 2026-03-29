import java.util.ArrayList;

public class ListaPalavras {

    public static ArrayList<String> separarPalavras(String linha) {

        ArrayList<String> palavras = new ArrayList<>();

        String[] partes = linha.split(" ");

        for (String palavra : partes) {

            if (!palavra.trim().isEmpty()) {
                String palavraLimpa = palavra.replaceAll("[^\\p{L}0-9]", "");
                if (!palavraLimpa.isEmpty()) {
                    palavras.add(palavraLimpa);
                }
            }

        }

        return palavras;
    }
}