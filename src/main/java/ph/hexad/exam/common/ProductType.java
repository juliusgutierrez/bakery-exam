package ph.hexad.exam.common;

import ph.hexad.exam.model.Package;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by juliusgutierrez on 14/08/2019.
 */
public enum ProductType {

  VEGEMITE_SCROLL("VS5") {
    @Override
    public List<Package> createPackages() {
      List<Package> packages = new ArrayList<Package>();
      packages.add(new Package(3, new BigDecimal("6.99")));
      packages.add(new Package(5, new BigDecimal("8.99")));
      return packages;
    }
  },

  BLUE_BERRY_MUFFIN("MB11") {
    @Override
    public List<Package> createPackages() {
      List<Package> packages = new ArrayList<Package>();
      packages.add(new Package(2, new BigDecimal("9.95")));
      packages.add(new Package(5, new BigDecimal("16.95")));
      packages.add(new Package(8, new BigDecimal("24.95")));
      return packages;
    }
  },

  CROISSANT("CF") {
    @Override
    public List<Package> createPackages() {
      List<Package> packages = new ArrayList<Package>();
      packages.add(new Package(3, new BigDecimal("5.95")));
      packages.add(new Package(5, new BigDecimal("9.95")));
      packages.add(new Package(9, new BigDecimal("16.99")));
      return packages;
    }
  }
  ;

  private String code;
  private static Map<String, ProductType> MAP = new HashMap<>();

  static {
    Stream.of(ProductType.values()).forEach(product -> MAP.put(product.getCode(), product));
  }

  ProductType(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public abstract List<Package> createPackages();

  public List<Package> getPacks() {
    List<Package> packages = createPackages();

    //reverse sort by quantity
    packages.sort((Package p1, Package p2) -> p2.getQuantity() - p1.getQuantity());
    return packages;
  }

  public static ProductType getProductBy(String code) {
    ProductType productType = MAP.get(code);
    if (productType == null) {
      throw new RuntimeException("Cannot find the product with code of " + code);
    }
    return productType;
  }
}
