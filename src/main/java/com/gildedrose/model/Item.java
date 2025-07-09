package com.gildedrose.model;

public class Item {

  private final String name;

  private int sellIn;

  private int quality;

  public void decrementSellIn() {
    this.sellIn--;
  }

  public void incrementQuality() {
    this.quality++;
  }

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }

  public String getName() {
    return name;
  }

  public int getSellIn() {
    return sellIn;
  }

  public int getQuality() {
    return quality;
  }

  public void setSellIn(int sellIn) {
    this.sellIn = sellIn;
  }

  public void setQuality(int quality) {
    this.quality = quality;
  }
}
