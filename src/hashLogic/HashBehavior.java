package hashLogic;

public class HashBehavior {

    public static int hash(String word, int bucketQuantity) {
        long hash = 0;
        int prime = 31;

        for (int i = 0; i < word.length(); i++) {
            hash = (hash * prime) + word.charAt(i);
        }

        hash = Math.abs(hash);
        return (int) (hash % bucketQuantity);
    }

}
