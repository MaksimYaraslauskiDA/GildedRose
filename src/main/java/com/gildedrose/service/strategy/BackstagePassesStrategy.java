package com.gildedrose.service.strategy;

import com.gildedrose.model.Item;

public class BackstagePassesStrategy implements QualityStrategy {
  @Override
  public void update(Item item) {
    item.decrementSellIn();
    int delta;
    if (item.getSellIn() < 0) {
      delta = 0;
    } else if (item.getSellIn() <= 5) {
      delta = Math.min(item.getQuality() + 3, 50);
    } else if (item.getSellIn() <= 10) {
      delta = Math.min(item.getQuality() + 2, 50);
    } else {
      delta = Math.min(item.getQuality() + 1, 50);
    }
    item.setQuality(delta);
  }
}
