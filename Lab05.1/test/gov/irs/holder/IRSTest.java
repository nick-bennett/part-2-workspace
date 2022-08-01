/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package gov.irs.holder;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.javatunes.corp.Corporation;
import gov.irs.holder.IRS;

public class IRSTest {
  
  @Test
  public void testNormalClientUsage() {
    IRS irs = IRS.getInstance();
    irs.register(new Corporation("JavaTunes"));
    irs.collectTaxes();
  }

  /**
   * TODO: verify that two calls to IRS.getInstance() return the same instance.
   */
  @Test
  public void testSingleton() {
    IRS irs1 = IRS.getInstance();
    IRS irs2 = IRS.getInstance();
    assertSame(irs1, irs2);
  }
  
  @Test
  public void testClassLoading() {
    // TODO: call IRS.touch() and note the output - the call to IRS.getInstance() should be commented out for this
    
    // TODO: call IRS.getInstance() and note the output - the call to IRS.touch() should be commented out for this
    
  }
}