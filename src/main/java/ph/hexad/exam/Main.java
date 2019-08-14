package ph.hexad.exam;

import com.sun.tools.corba.se.idl.constExpr.Or;
import ph.hexad.exam.common.ProductType;
import ph.hexad.exam.model.Order;
import ph.hexad.exam.model.Package;
import java.util.List;

/**
 * Created by juliusgutierrez on 14/08/2019.
 */
public class Main {

  public static void main(String[] args) {

    String[] input = "15 VS5".split(" ");

    ProductType productType = ProductType.getProductBy(input[1]);
    System.out.println(productType.getCode());

    //reverse sort by quantity
    Order order = new Order();
    int quantity = Integer.parseInt(input[0]);
    int ctr = 0;

    List<Package> packages = productType.getPacks();

    int divisible = quantity % packages.get(ctr).getQuantity();
    System.out.println(packages.get(ctr).getQuantity());
    System.out.println(divisible);

    while (quantity != 0) {
      //process packaging of customer
      List<Package> packags = productType.getPacks();

      Package pack = packags.get(ctr);
      int d = quantity % pack.getQuantity();

      if (d == 0) {
        quantity = quantity - pack.getQuantity();
        order.addPackage(pack);
      }


    }

    System.out.println(order);


  }

}
