package com.gildedrose.service;

import com.gildedrose.model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

  private Item item;
  private GildedRose app;

  private void initItem(String name, int sellIn, int quality) {
    item = new Item(name, sellIn, quality);
    app = new GildedRose(new Item[]{item});
  }

  @Test
  public void testNormalItem() {
    initItem("Elixir", 5, 10);
    app.updateQuality();
    assertEquals(4, item.getSellIn());
    assertEquals(9, item.getQuality());

    // after the end
    for (int i = 0; i < 5; i++) app.updateQuality();
    assertEquals(3, item.getQuality()); // Не может быть ниже 0
  }

  @Test
  public void testAgedBrie() {
    initItem("Aged Brie", 2, 10);
    app.updateQuality();
    assertEquals(1, item.getSellIn());
    assertEquals(11, item.getQuality());

    // after the end
    app.updateQuality();
    assertEquals(0, item.getSellIn());
    assertEquals(12, item.getQuality());
  }

  @Test
  public void testSulfuras() {
    initItem("Sulfuras", 0, 80);
    app.updateQuality();
    assertEquals(0, item.getSellIn());
    assertEquals(80, item.getQuality());
  }

  @Test
  public void testBackstagePasses() {
    initItem("Backstage passes", 15, 20);
    app.updateQuality();
    assertEquals(14, item.getSellIn());
    assertEquals(21, item.getQuality());

    // < 10 days
    for (int i = 0; i < 5; i++) app.updateQuality();
    assertEquals(9, item.getSellIn());
    assertEquals(28, item.getQuality());

    // < 5 days
    for (int i = 0; i < 5; i++) app.updateQuality();
    assertEquals(4, item.getSellIn());
    assertEquals(40, item.getQuality());

    // after the end
    for (int i = 0; i < 5; i++) app.updateQuality();
    assertEquals(0, item.getQuality());
  }

  @Test
  public void testConjuredItem() {
    initItem("Conjured Mana Cake", 3, 6);
    app.updateQuality();
    assertEquals(2, item.getSellIn());
    assertEquals(4, item.getQuality());

    // after the end
    for (int i = 0; i < 3; i++) app.updateQuality();
    assertEquals(-1, item.getSellIn());
    assertEquals(0, item.getQuality()); // >= 0
  }
}
