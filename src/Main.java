import core.CoreLogic;
import model.BucketAndOverflow;

public class Main {

        public static void main(String[] args) {

            CoreLogic core = new CoreLogic();
            BucketAndOverflow behavior = core.behavior();

            for(String v : behavior.getOverflowType().keySet()){
                System.out.println(v);
            }

        }
}