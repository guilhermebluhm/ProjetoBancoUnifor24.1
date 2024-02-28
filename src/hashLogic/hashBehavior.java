package hashLogic;

public class hashBehavior {

    public static int hash(String word, int bucketQuantity){

        /*
            requer testes e revisao por parte do lorenzo, caso necessario
         */

        int hash = 0;
        for (int i = 0; i < word.length(); i++) {
            hash += (int) word.charAt(i);
        }

        hash *= hash;
        hash *= 2.7182818284;
        hash %= bucketQuantity;
        return hash;

    }

    //bucket quantity e a quantidade de buckets que foram gerados
    //para limitar o

}
