package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
//    public void updateQuality() {
//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Aged Brie")
//                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Aged Brie")) {
//                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                    } else {
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//        }
//    }


    /* To refactor the above code:
    - used for-each loop instead of loop using indices
    - use switch case
    - remove nested if's
    - merge if's into one condition
    - remove "quantity = quantity - quantity" with quantity = 0
    - create update quality fns for each type of items
 */

    public void updateQuality() {
        for (Item currItem: items){
            switch (currItem.name) {
                case "Aged Brie":
                    updateAgedBrieQuality(currItem);
                    updateSellIn(currItem);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    updateQBackstagePassesQuality(currItem);
                    updateSellIn(currItem);
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    break;

                case "Conjured":
                    updateConjuredQuality(currItem);
                    updateSellIn(currItem);
                    break;

                default:
                    updateDefaultQuality(currItem);
                    updateSellIn(currItem);
                    break;
            }
        }
    }

    public void updateSellIn(Item item){
        item.sellIn--;
    }

    public void updateAgedBrieQuality(Item item){
        if (item.sellIn <= 0 && item.quality < 50)
            item.quality+=2;

        else if (item.quality < 50)
            item.quality++;

    }

    public void updateQBackstagePassesQuality(Item item){
        if (item.sellIn <= 0)
            item.quality = 0;

        else if (item.sellIn < 6 && item.quality < 50)
            item.quality+=3;

        else if (item.sellIn < 11 && item.quality < 50)
            item.quality+=2;

        else if (item.quality < 50)
            item.quality++;

    }

    public void updateDefaultQuality(Item item){
        if (item.quality > 0)
            item.quality--;

        if (item.sellIn <= 0 && item.quality > 0)
            item.quality--;

    }

    public void updateConjuredQuality(Item item) {
        if (item.quality >= 2)
            item.quality-=2;

        if (item.sellIn <= 0 && item.quality >= 2)
            item.quality-=2;
    }
}