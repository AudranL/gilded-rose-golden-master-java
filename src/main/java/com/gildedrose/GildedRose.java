package com.gildedrose;

class GildedRose {
    private final Item[] items;

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateNumberOfRemainingSellInDays(i);

            if (items[i].name.equals(BACKSTAGE_PASSES)) {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                    if (items[i].sellIn < 10 && items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }

                    if (items[i].sellIn < 5 && items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }

                }
                if (items[i].sellIn < 0) {
                    items[i].quality = 0;
                }
            }

            if (items[i].name.equals(AGED_BRIE)) {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                }
                if (items[i].sellIn < 0 && items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                }

            }


            if (!items[i].name.equals(AGED_BRIE)
                    && !items[i].name.equals(BACKSTAGE_PASSES)) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        items[i].quality = items[i].quality - 1; // +5 Dexterity Vest, Elixir of the Mongoose, Conjured Mana Cake
                    }
                }
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(AGED_BRIE)) {
                    if (!items[i].name.equals(BACKSTAGE_PASSES)) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                items[i].quality = items[i].quality - 1; // +5 Dexterity Vest, Elixir of the Mongoose, Conjured Mana Cake
                            }
                        }
                    }
                }
            }
        }
    }

    private void updateNumberOfRemainingSellInDays(int i) {
        if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            items[i].sellIn = items[i].sellIn - 1;
        }
    }
}
