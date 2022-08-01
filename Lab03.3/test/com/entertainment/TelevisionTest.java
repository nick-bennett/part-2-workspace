package com.entertainment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {

  private static final int INITIAL_VOLUME = 50;

  private Television television;

  @Before
  public void setUp() throws Exception {
    television = new Television("Sony", INITIAL_VOLUME, DisplayType.OLED);
  }

  @Test
  public void getBrand() {
    fail("Not yet implemented");
  }

  @Test
  public void setBrand() {
    fail("Not yet implemented");
  }

  @Test
  public void getVolume() {
    assertEquals(INITIAL_VOLUME, television.getVolume());
  }

  @Test
  public void setVolume_valid() {
    television.setVolume(Television.MIN_VOLUME + 1);
    assertEquals(Television.MIN_VOLUME + 1, television.getVolume());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setVolume_invalid() {
    television.setVolume(Television.MIN_VOLUME - 1);
  }

  @Test
  public void getCurrentChannel() {
    fail("Not yet implemented");
  }

  @Test
  public void changeChannel() {
    fail("Not yet implemented");
  }

  @Test
  public void getDisplay() {
    fail("Not yet implemented");
  }

  @Test
  public void setDisplay() {
    fail("Not yet implemented");
  }

  @Test
  public void compareTo() {
    fail("Not yet implemented");
  }

  @Test
  public void testHashCode() {
    fail("Not yet implemented");
  }

  @Test
  public void testEquals() {
    fail("Not yet implemented");
  }

}