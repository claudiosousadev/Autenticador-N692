import java.util.ArrayList;
import java.util.Stack;

public class main {
    public static void main(String[] args) {

        String caminho = "src/main/resources/texto.txt";
        ArrayList<String> linhas = LeitorArquivo.lerArquivo(caminho);

        Stack<ArvoreAVL> pilhaDeArvores = new Stack<>();

        // Passo 2, 3 e 4: Ler linha, montar lista dinâmica, inserir reverso na AVL, e empilhar a árvore
        for (String linha : linhas) {
            ArrayList<String> palavras = ListaPalavras.separarPalavras(linha);

            if (palavras.isEmpty()) {
                continue; // Linhas vazias são solenemente ignoradas
            }

            ArvoreAVL arvore = new ArvoreAVL();

            for (int i = palavras.size() - 1; i >= 0; i--) {
                arvore.inserir(palavras.get(i));
            }
            
            if (arvore.raiz != null) {
                pilhaDeArvores.push(arvore);
            }
        }

        System.out.println("Lista de Hashes de Autenticação gerados por linha (LIFO):");
        
        // Passo 5 e 6: Desempilhar, gerar o hash recursivo e exibir separado por quebra de linha
        while (!pilhaDeArvores.isEmpty()) {
            ArvoreAVL a = pilhaDeArvores.pop();
            a.computarHash(a.raiz);
            System.out.println(a.raiz.hash);
        }
    }
}