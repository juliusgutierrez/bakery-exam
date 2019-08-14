package ph.hexad.exam.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juliusgutierrez on 14/08/2019.
 */
public class Order {

  private List<Package> packageList = new ArrayList<>();

  public List<Package> getPackageList() {
    return packageList;
  }

  public void setPackageList(List<Package> packageList) {
    this.packageList = packageList;
  }

  public void addPackage(Package pack) {
    packageList.add(pack);
  }
}
