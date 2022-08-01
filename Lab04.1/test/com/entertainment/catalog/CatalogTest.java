/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;

import com.entertainment.DisplayType;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {
  
  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void testFindByBrandNoMatches() {
    checkNoMatchResult(Catalog.findByBrand("NO-MATCHES"));
  }

  @Test
  public void testFindByBrandWithMatches() {
    checkSonyResult(Catalog.findByBrand("Sony"));
  }

  @Test
  public void testFindByBrandsNone() {
    Map<String, Collection<Television>> tvs = Catalog.findByBrands();
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandsSome() {
    Map<String, Collection<Television>> tvs = Catalog.findByBrands("Sony", "NO-MATCHES");
    assertEquals(2, tvs.size());
    checkNoMatchResult(tvs.get("NO-MATCHES"));
    checkSonyResult(tvs.get("Sony"));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testGetInventoryRemoveUnsupported() {
    Collection<Television> tvs = Catalog.getInventory();
    int count = 0;
    Television candidate = null;
    for (Television tv : tvs) {
      if (candidate == null || Math.random() < 1.0 / ++count) {
        candidate = tv;
      }
    }
    tvs.remove(candidate);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testGetInventoryAddUnsupported() {
    Catalog.getInventory().add(new Television("Sony", Television.MIN_VOLUME));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testGetInventoryClearUnsupported() {
    Catalog.getInventory().clear();
  }

  @Test
  public void getInventoryWithDuplicatesRemoved() {
    Collection<Television> inventory = Catalog.getInventory();
    Set<Television> distinctInventory = new HashSet<>(inventory);
    assertEquals(7, inventory.size() - distinctInventory.size());
  }

  @Test
  public void getLoudestTelevision() {
    Television loudest = Catalog
        .getInventory()
        .stream()
        .max(Comparator.comparing(Television::getVolume))
        .orElseThrow();
    Television expected = new Television("Sony", 94);
    assertEquals(expected, loudest);
  }

  private void checkNoMatchResult(Collection<Television> tvs) {
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  private void checkSonyResult(Collection<Television> tvs) {
    assertNotNull(tvs);
    assertEquals(7, tvs.size());
    for (Television tv: tvs) {
      assertEquals("Sony", tv.getBrand());
    }
  }

}