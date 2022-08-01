/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

public enum Location {

  USA {
    @Override
    public TaxCalculator getTaxCalculator() {
      return new USATax();
    }
  },
  EUROPE {
    @Override
    public TaxCalculator getTaxCalculator() {
      return new EuropeTax();
    }
  },
  ONLINE {
    @Override
    public TaxCalculator getTaxCalculator() {
      return new OnlineTax();
    }
  };

  public abstract TaxCalculator getTaxCalculator();

}