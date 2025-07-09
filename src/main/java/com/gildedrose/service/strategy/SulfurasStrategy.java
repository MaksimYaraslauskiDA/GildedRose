package com.gildedrose.service.strategy;

import com.gildedrose.model.Item;

public class SulfurasStrategy implements QualityStrategy {
  @Override
  public void update(Item item) {
    //Legendary item, do nothing
  }
}
