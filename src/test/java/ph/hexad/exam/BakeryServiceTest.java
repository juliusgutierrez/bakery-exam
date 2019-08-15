package ph.hexad.exam;

import org.junit.Assert;
import org.junit.Test;
import ph.hexad.exam.exceptions.InvalidOrderException;
import ph.hexad.exam.model.Order;
import ph.hexad.exam.service.BakeryService;

/**
 * Created by juliusgutierrez on 15/08/2019.
 */
public class BakeryServiceTest {

  private BakeryService service = new BakeryService();

  @Test
  public void process_order_success_test() {
    Order order = service.processOrder(14, "MB11");
    Assert.assertEquals("54.80", order.getTotalOrder().toString());

  }

  @Test(expected = InvalidOrderException.class)
  public void process_order_success_fail() {
    service.processOrder(1, "MB11");
  }

}
