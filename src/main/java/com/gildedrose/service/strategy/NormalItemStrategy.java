package com.gildedrose.service.strategy;

import com.gildedrose.model.Item;

public class NormalItemStrategy implements QualityStrategy {
  @Override
  public void update(Item item) {
    item.decrementSellIn();
    int decrease = item.getSellIn() < 0 ? 2 : 1;
    item.setQuality(Math.max(item.getQuality() - decrease, 0));
  }
}
