package com.gildedrose.service;

import com.gildedrose.model.Item;
import com.gildedrose.service.strategy.QualityStrategy;

public class GildedRose {
  private final Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public Item[] getItems() {
    return items;
  }

  public void updateQuality() {
    for (Item item : items) {
      QualityStrategy strategy = ItemStrategyFactory.getStrategy(item);
      strategy.update(item);
    }
  }
}
