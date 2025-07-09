package com.gildedrose.service.strategy;

import com.gildedrose.model.Item;

public class ConjuredItemStrategy implements QualityStrategy {
  @Override
  public void update(Item item) {
    item.decrementSellIn();
    int decrease = item.getSellIn() < 0 ? 4 : 2;
    item.setQuality(Math.max(item.getQuality() - decrease, 0));
  }
}
