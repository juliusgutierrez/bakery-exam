package ph.hexad.exam.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by juliusgutierrez on 14/08/2019.
 */
public class Order {

  private BigDecimal totalOrder;
  private int quantity;
  private String productCode;
  private List<String> breakDownOrder;

  public BigDecimal getTotalOrder() {
    return totalOrder;
  }

  public void setTotalOrder(BigDecimal totalOrder) {
    this.totalOrder = totalOrder;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public List<String> getBreakDownOrder() {
    return breakDownOrder;
  }

  public void setBreakDownOrder(List<String> breakDownOrder) {
    this.breakDownOrder = breakDownOrder;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append(quantity)
        .append(" ")
        .append(productCode)
        .append(" $")
        .append(totalOrder)
        .append("\n\t");
    breakDownOrder.forEach(str -> {
      sb.append(str);
      sb.append("\n\t");
    });
    return sb.toString();

  }
}
