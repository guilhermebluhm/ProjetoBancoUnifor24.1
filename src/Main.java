import core.CoreLogic;
import model.Bucket;
import model.BucketAndOverflow;
import model.BucketOverflowType;
import utils.SearchLogic;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

        public static void main(String[] args) {

            String bckSeach;
            Scanner sc = new Scanner(System.in);
            CoreLogic core = new CoreLogic();
            BucketAndOverflow behavior = core.behavior();
            SearchLogic src = new SearchLogic();

            System.out.println("qual bucket quer localizar: ");
            bckSeach = sc.nextLine();
            src.searchBehaviour(behavior,bckSeach);
        }
}