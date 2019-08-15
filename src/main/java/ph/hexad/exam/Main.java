package ph.hexad.exam;

import ph.hexad.exam.model.Order;
import ph.hexad.exam.service.BakeryService;


/**
 * Created by juliusgutierrez on 14/08/2019.
 */
public class Main {

  public static void main(String[] args) {
    BakeryService service = new BakeryService();
    Order order = service.processOrder(parseQty(args[0]), args[1]);
    System.out.println(order);
  }

  private static int parseQty(String qty) {
    return Integer.parseInt(qty);
  }


}
