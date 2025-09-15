package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    /*@Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }
     */
    @Test
    void normal_item_expiration(){
        Item[]  items = {
            new Item("Normal", 1, 10),
                    new Item("Normal", 0, 10)
        };
        Magasin magasin = new Magasin(items);

        magasin.updateQuality();

        assertEquals(0, items[0].sellIn);
        assertEquals(9, items[0].quality);

        assertEquals(-1, items[1].sellIn);
        assertEquals(8, items[1].quality);

    }

}
