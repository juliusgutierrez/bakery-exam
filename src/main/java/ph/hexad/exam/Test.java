package ph.hexad.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juliusgutierrez on 14/08/2019.
 */
public class Test {

  public static void main(String[] args) {
    //int given = 10;
    //int[] packaginglist = new int[] {5, 3};

    //int given = 13;
    //int[] packaginglist = new int[] {9, 5, 3};

    int given = 14;
    int[] packaginglist = new int[] {8, 5, 2};
    List<Integer> combinations = null;
    int d = 1; //default value
    for(int x = 0; x < packaginglist.length; x++) {

      if (d == 0) {
        break; // stop since there is no left to package
      }

      combinations = new ArrayList<>();
      System.out.println("x" + x);
      int temp = given;
      int tempd;
      for (int j = x; j < (packaginglist.length); j++) {
        System.out.println("j" + j);
        System.out.println("package list : " + packaginglist[j]);
        d = temp % packaginglist[j];
        tempd = d;
        if (d == 0 || (d < packaginglist[j] && d > 1)) {
          int m = temp / packaginglist[j];
          temp = temp - (packaginglist[j] * m);
          while (m != 0) {
            combinations.add(packaginglist[j]);
            m--;
          }
        } else if (d == 1) {
          System.out.println("break");
          d = tempd;
          continue;
        }
      }
    }

    System.out.println(combinations);
    System.out.println(d);
  }


}
