package com.gildedrose.service.strategy;

import com.gildedrose.model.Item;

public class AgedBrieStrategy implements QualityStrategy {
  @Override
  public void update(Item item) {
    item.decrementSellIn();
    if (item.getQuality() < 50) {
      item.incrementQuality();
      if (item.getSellIn() < 0 && item.getQuality() < 50) {
        item.incrementQuality();
      }
    }
  }
}
