package ph.hexad.exam.model;

import java.math.BigDecimal;

/**
 * Created by juliusgutierrez on 14/08/2019.
 */
public class Package {

  private int quantity;
  private BigDecimal price;

  //no arg constructor
  public Package() {
  }

  public Package(int quantity, BigDecimal price) {
    this.quantity = quantity;
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Package{" +
        "quantity=" + quantity +
        ", price=" + price +
        '}';
  }
}
