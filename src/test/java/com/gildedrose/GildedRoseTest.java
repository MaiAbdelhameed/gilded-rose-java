package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    //////////////////// Aged Brie ////////////////////
    @Test // 1) quality increase as sellIn decreases
    void checkAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 12, 0 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test // 2) quality equals 50
    void checkAgedBrieQualityEquals50() {
        Item[] items = new Item[] { new Item("Aged Brie", 12, 50 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test // 3) sellIn equals zero, quality increase by 2
    void checkAgedBrieSellInEqualsZero(){
        Item[] items = new Item[] { new Item("Aged Brie", 0, 2 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }
    @Test // 4) sellIn negative, still quality increases by 2
    void checkAgedBrieWithNegativeSellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 5 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }


    //////////////////// Backstage Passes ////////////////////
    @Test // 1) test quality increases when sellIn more than 10 decrease
    void checkBackstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 5 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test // 2) quality increase by 3 when sell in less than 6
    void checkBackstagePassesSellInLessThan6() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 2, 5 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test // 3) quality increase by 2 when sellIn less than 11
    void checkBackstagePassesSellInLessThan11() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test // 4) quality drops to zero when sellIn equals 0
    void checkBackstagePassesSellInLessThanOrEqualsTo0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0 ),
                new Item("Backstage passes to a TAFKAL80ETC concert", -2, 5 ),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        assertEquals(-3, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);

        assertEquals(-1, app.items[2].sellIn);
        assertEquals(0, app.items[2].quality);
    }

    @Test // 5) quality never increase more than 50 whether sellIn less than 11 or less than 6
     void checkBackstagePassesQualityMoreThan50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50 ),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

        assertEquals(4, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);
    }

    //////////////////// Sulfuras ////////////////////
    @Test // 1) quality and sellIn never changes
    void checkSulfuras() { // check that sulfuras quality value never changes
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros",5 , 5 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
    }

    @Test // 2) quality more than 50 and still neither quality nor sellIn change
    void checkSulfuraseQualityMoreThan50() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros",5 , 100 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(100, app.items[0].quality);
    }

    //////////////////// Regular Items ////////////////////
    @Test // 1) test quality and sellIn decrease of regular items
    void checkRegularItems() {
        Item[] items = new Item[] { new Item("Regular Items",1 , 5 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test // 2) quality decrease by 2 when sellIn less than or equals to 0
    void checkRegularItemsSellInLessThanOrEqualToZero() {
        Item[] items = new Item[] { new Item("Regular Items",-1 , 5 ),
                new Item("Regular Items",0 , 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-2, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);

        assertEquals(-1, app.items[1].sellIn);
        assertEquals(2, app.items[1].quality);
    }

    @Test // 3) quality is never negative
    void checkRegularItemQualityNeverNegative() {
        Item[] items = new Item[] { new Item("Regular Item",9 , 0 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(8, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

    }


    ////////////////// Conjured Items ////////////////////
    @Test // 1) quality twice as regular items when sellIn more than 0
    void checkConjured() {
        Item[] items = new Item[] { new Item("Conjured",9 , 5 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(8, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);

    }

    @Test // 2) quality decrease by 2 when sellIn equals or less than 0
    void checkConjuredSellInLessThanOrEqualToZero() {
        Item[] items = new Item[] { new Item("Conjured",-1 , 5 ),
                new Item("Conjured",0 , 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-2, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);

        assertEquals(-1, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);
    }

    @Test // 3) quality is never negative
    void checkConjuredQualityNeverNegative() {
        Item[] items = new Item[] { new Item("Conjured",9 , 0 ),
                new Item("Conjured",9 , 1 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(8, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        assertEquals(8, app.items[1].sellIn);
        assertEquals(1, app.items[1].quality);

    }
}
