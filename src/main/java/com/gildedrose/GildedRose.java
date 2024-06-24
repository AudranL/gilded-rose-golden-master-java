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
            if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                updateNumberOfRemainingSellInDays(i);
                if (items[i].name.equals(BACKSTAGE_PASSES)) {
                    updateBackstagePassesQuality(i);
                } else if (items[i].name.equals(AGED_BRIE)) {
                    updateAgedBrieQuality(i);
                } else {
                    updateQualityForOtherItems(i);
                }
            }
        }
    }

    private void updateQualityForOtherItems(int i) {
        if (items[i].quality > 0) {
            items[i].quality--;
        }
        if (items[i].sellIn < 0 && items[i].quality > 0) {
            items[i].quality--;
        }
    }

    private void updateAgedBrieQuality(int i) {
        if (items[i].quality < 50) {
            items[i].quality++;
        }
        if (items[i].sellIn < 0 && items[i].quality < 50) {
            items[i].quality++;
        }
    }

    private void updateBackstagePassesQuality(int i) {
        if (items[i].quality < 50) {
            items[i].quality++;
            if (items[i].sellIn < 10 && items[i].quality < 50) {
                items[i].quality++;
            }
            if (items[i].sellIn < 5 && items[i].quality < 50) {
                items[i].quality++;
            }
        }
        if (items[i].sellIn < 0) {
            items[i].quality = 0;
        }
    }

    private void updateNumberOfRemainingSellInDays(int i) {
        items[i].sellIn--;
    }
}
