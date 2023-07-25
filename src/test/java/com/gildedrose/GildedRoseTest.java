package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

//    @Test
//    void foo() {
//        Item[] items = new Item[] { new Item("foo", 0, 0) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals("fixme", app.items[0].name);
//    }

    @Test
    void checkAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }


    @Test
    void checkAgedBrieQualityEquals50() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
}
