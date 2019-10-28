package ee.carlr.order;

public class OrderItem {

  private final String name;
  private final Double price;

  public OrderItem(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }
}
