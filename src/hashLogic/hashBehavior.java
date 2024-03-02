package hashLogic;

public class hashBehavior {

    public static int hash(String word, int bucketQuantity){

        long hash = 0;
        int prime = 6007 * 7079;
        for (int i = 0; i < word.length(); i++) {
            hash += word.charAt(i);
        }


        hash *= prime;
        hash %= bucketQuantity;

        return (int) hash;
    }

    //bucket quantity e a quantidade de buckets que foram gerados
    //para limitar o

}
