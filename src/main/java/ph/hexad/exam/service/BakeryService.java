package ph.hexad.exam.service;

import ph.hexad.exam.common.ProductType;
import ph.hexad.exam.exceptions.InvalidOrderException;
import ph.hexad.exam.model.Order;
import ph.hexad.exam.model.Pack;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by juliusgutierrez on 14/08/2019.
 */
public class BakeryService {

  public Order processOrder(int quantity, String productCode) {

    ProductType productType = ProductType.getProductBy(productCode);
    List<Pack> packs = processPackaging(quantity, productType);

    if (packs != null && packs.size() > 0) {
      Order order = new Order();
      order.setProductCode(productCode);
      order.setQuantity(quantity);
      order.setTotalOrder(computePrice(packs));
      order.setBreakDownOrder(createBreakDownOrder(packs));
      return order;
    } else {
      throw new InvalidOrderException();
    }

  }

  private BigDecimal computePrice(List<Pack> packs) {
    return packs.stream().map(Pack::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private List<String> createBreakDownOrder(List<Pack> packs) {
    List<String> breakDownMsg = new ArrayList<>();
    int previousQty = 0;
    for (int index = 0; index < packs.size(); index++) {

      if (previousQty == packs.get(index).getQuantity()) {
        //skip the current when qty is already filtered
        continue;
      }

      final Pack pack1 = packs.get(index);
      List<Pack> p = packs
          .stream()
          .filter(pack -> pack.getQuantity() == pack1.getQuantity())
          .collect(Collectors.toList());

      BigDecimal price = p.get(0).getPrice();
      int qty = p.get(0).getQuantity();
      String breakdown = String.format("%d x %d $%.2f", p.size(), qty, price.floatValue());
      breakDownMsg.add(breakdown);
      previousQty = packs.get(index).getQuantity();
    }

    return breakDownMsg;
  }

  private List<Pack> processPackaging(int quantity, ProductType productType) {
    List<Pack> packs = productType.getPacks();
    List<Pack> combinationsPacks = new ArrayList<>();
    boolean isStop = false;
    for (int outerIndex = 0; outerIndex < packs.size(); outerIndex++) {
      if (isStop) {
        //stop the packaging
        break;
      }

      combinationsPacks = new ArrayList<>();
      int temp = quantity;
      int remainder;
      for (int innerIndex = outerIndex; innerIndex < packs.size(); innerIndex++) {
        Pack currentPack = packs.get(innerIndex);
        int productQty = currentPack.getQuantity();
        remainder = temp % productQty;

        if (remainder == 0 || (remainder < productQty && remainder > 1)) {
          int multiplier = temp / productQty;
          temp = temp - (productQty * multiplier);
          while (multiplier != 0) {
            combinationsPacks.add(currentPack);
            multiplier--;
          }
        } else if (remainder == 1) {
          //skip the current and proceed to next possible pack
          continue;
        }

        if (remainder == 0) {
          isStop = true;
        }
      }
    }

    return combinationsPacks;
  }


}
