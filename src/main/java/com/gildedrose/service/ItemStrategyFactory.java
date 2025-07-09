package com.gildedrose.service;

import com.gildedrose.model.Item;
import com.gildedrose.service.strategy.*;

public class ItemStrategyFactory {
  public static QualityStrategy getStrategy(Item item) {
    String itemName = item.getName();
    if (itemName.contains("Conjured")) {
      return new ConjuredItemStrategy();
    }
    if (itemName.contains("Aged Brie")) {
      return new AgedBrieStrategy();
    }
    if (itemName.contains("Sulfuras")) {
      return new SulfurasStrategy();
    }
    if (itemName.contains("Backstage passes")) {
      return new BackstagePassesStrategy();
    }
    return new NormalItemStrategy();
  }
}
