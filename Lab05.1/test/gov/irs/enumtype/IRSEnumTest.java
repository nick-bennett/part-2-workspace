/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package gov.irs.enumtype;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.javatunes.corp.Corporation;
import gov.irs.holder.IRS;

public class IRSEnumTest {
  
  @Test
  public void testNormalClientUsage() {
    IRS irs = IRS.getInstance();
    irs.register(new Corporation("JavaTunes"));
    irs.collectTaxes();
  }

  /**
   * TODO: verify that two calls to IRSEnum.getInstance() return the same instance.
   */
  @Test
  public void testSingleton() {
    IRS irs1 = IRS.getInstance();
    IRS irs2 = IRS.getInstance();
    assertSame(irs1, irs2);
  }
  
  @Test
  public void testClassLoading() {
    // TODO: call IRSEnum.touch() and note the output - the call to IRSEnum.getInstance() should be commented out for this
    IRSEnum.touch();

    // TODO: call IRSEnum.getInstance() and note the output - the call to IRSEnum.touch() should be commented out for this
    IRS.getInstance();

  }
}