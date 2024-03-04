import core.CoreLogic;
import model.BucketAndOverflow;
import utils.SearchLogic;

import java.util.Scanner;

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