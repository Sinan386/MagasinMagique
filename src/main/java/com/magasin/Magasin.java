package com.magasin;


class Magasin {
    Item[] items;

    public Magasin(Item[] items){
        this.items = items;
    }

    private void updateNormalItem(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }


    private void updateVipItem(Item item) {

        if (item.quality < 50) {
            item.quality = item.quality + 1;        // +1 de base
        }
        if (item.sellIn < 11 && item.quality < 50) { // si 10j ou moins +1
            item.quality = item.quality + 1;
        }
        if (item.sellIn < 6 && item.quality < 50) {  // si 5j ou moins +1
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        // après le concert: qualité tombe à 0
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }


        private void updateComte(Item item) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0 && item.quality < 50) {
                item.quality = item.quality + 1;
            }

        }

        private void updateKryptonite(Item item) {
            // rien ne change: ni quality ni sellIn
        }




    public void updateQuality() {
        for (Item item : items) {
            if ("Kryptonite".equals(item.name)) {
                updateKryptonite(item);
            } else if ("Comté".equals(item.name)) {
                updateComte(item);
            } else if ("Pass VIP Concert".equals(item.name)) {
                updateVipItem(item);
            } else {
                updateNormalItem(item);
            }
        }
    }
}
