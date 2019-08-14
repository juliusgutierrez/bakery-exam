package ph.hexad.exam;

import ph.hexad.exam.common.ProductType;
import ph.hexad.exam.model.Order;
import ph.hexad.exam.model.Package;
import java.util.List;

/**
 * Created by juliusgutierrez on 14/08/2019.
 */
public class Main {

  public static void main(String[] args) {

    String[] input = "14 MB11".split(" ");

    ProductType productType = ProductType.getProductBy(input[1]);
    System.out.println(productType.getCode());


    Order order = new Order();
    int quantity = Integer.parseInt(input[0]);
    int ctr = 0;

    List<Package> packages = productType.getPacks();

    int multiplier = 0;
    while (quantity != 0) {
      //process packaging of customer
      Package pack = packages.get(ctr);
      int d = quantity % pack.getQuantity();

      if (d == 0) {
        multiplier = quantity / pack.getQuantity();
        System.out.println(multiplier);
        quantity = quantity - (pack.getQuantity() * multiplier);
        while (multiplier != 0) {
          order.addPackage(pack);
          multiplier--;
        }
      } else if (quantity >= pack.getQuantity()) {
        quantity = quantity - pack.getQuantity();
        order.addPackage(pack);
      } else {
        ctr++;
        continue;
      }
    }

    System.out.println(order);

  }

}
