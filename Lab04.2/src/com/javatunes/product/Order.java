/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

public class Order {

  private static final String HEADER_ROW_FORMAT = "%1$-20s%2$12s%n%3$s%n";
  private static final String FOOTER_ROW_FORMAT = "%3$s%n%1$-20s%2$12.2f%n";
  private static final String SEPARATOR_LINE = "-".repeat(32);
  private static final String CODE_COLUMN_HEADER = "Product code";
  private static final String PRICE_COLUMN_HEADER = "Price";
  private static final String PRICE_COLUMN_FOOTER = "Total";
  private static final String ITEM_ROW_FORMAT = "%1$-20s%2$12.2f%n";

  private String id;
  
  public Order(String id) {
    this.id = id;
  }
  
  /**
   * TODO:
   * get the items from the cart and iterate over them, print each item's product code
   * get cart total and print
   */
  public void processCart(ShoppingCart<?> cart) {
    System.out.printf(HEADER_ROW_FORMAT, CODE_COLUMN_HEADER, PRICE_COLUMN_HEADER, SEPARATOR_LINE);
    for (Product item : cart.allItems()) {
      System.out.printf(ITEM_ROW_FORMAT, item.getCode(), item.getPrice());
    }
    System.out.printf(FOOTER_ROW_FORMAT, PRICE_COLUMN_FOOTER, cart.total(), SEPARATOR_LINE);
  }
  
  public String getId() {
    return id;
  }
}