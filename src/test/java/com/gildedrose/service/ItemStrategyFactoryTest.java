package com.gildedrose.service;

import com.gildedrose.model.Item;
import com.gildedrose.service.strategy.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemStrategyFactoryTest {

  @Test
  public void testStrategySelection() {
    assertEquals(AgedBrieStrategy.class, getStrategy("Aged Brie").getClass());
    assertEquals(SulfurasStrategy.class, getStrategy("Sulfuras").getClass());
    assertEquals(BackstagePassesStrategy.class, getStrategy("Backstage passes").getClass());
    assertEquals(ConjuredItemStrategy.class, getStrategy("Conjured Mana Cake").getClass());
    assertEquals(NormalItemStrategy.class, getStrategy("Potion").getClass());
  }

  private QualityStrategy getStrategy(String name) {
    return ItemStrategyFactory.getStrategy(new Item(name, 0, 0));
  }
}
