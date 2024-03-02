package hashLogic;

public class hashBehavior {

    public static int hash(String word, int bucketQuantity) {
        long hash = 0;
        int prime = 31; // Escolha de um número primo, pode ajustar conforme necessário.

        for (int i = 0; i < word.length(); i++) {
            hash = (hash * prime) + word.charAt(i);
        }

        hash = Math.abs(hash); // Certifique-se de que o hash é não-negativo.
        return (int) (hash % bucketQuantity);
    }

}
