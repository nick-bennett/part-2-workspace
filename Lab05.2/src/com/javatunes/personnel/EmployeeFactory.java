/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;
import java.util.Set;

public final class EmployeeFactory {

  private static final Set<String> VALID_EMPLOYEE_TYPES = Set.of("HE", "SE");

  // prevent direct instantiation - this is an all-static factory class
  private EmployeeFactory() {
  }

  /**
   * TODO: given the input map, create and return the correct object (with its properties set).
   * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a
   * suitable message.
   */
  public static Employee createEmployee(Map<String, String> inputMap)
      throws IllegalArgumentException {
    // return value
    Employee emp = null;
    String type = inputMap.get("type");
    if (!VALID_EMPLOYEE_TYPES.contains(type)) {
      throw new IllegalArgumentException(String.format("\"%s\" is not a valid employee type.", type));
    }
    String name = inputMap.get("name");
    Date hireDate = Date.valueOf(inputMap.get("hireDate"));
    switch (type) {
      case "SE":
        Double salary = Double.valueOf(inputMap.get("salary"));
        emp = new SalariedEmployee(name, hireDate, salary);
        break;
      case "HE":
        Double rate = Double.valueOf(inputMap.get("rate"));
        Double hours = Double.valueOf(inputMap.get("hours"));
        emp = new HourlyEmployee(name, hireDate, rate, hours);
        break;
    }
    return emp;
  }
}