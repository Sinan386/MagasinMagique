package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items){
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) { // boucle for each pour ne pas oublier un item
        // for (int i = 0; i < items.length; i++)



            if (!item.name.equals("Comté")
                    && !item.name.equals("Pass VIP Concert")) {
                // tout ce qui est Normal

                if (item.quality > 0) { // jamais négatif
                    if (!item.name.equals("Kryptonite")) {
                        item.quality = item.quality - 1; // normal -1/jour
                    }
                }
            } else {
                if (item.quality < 50) {  // jamais > 50
                    item.quality = item.quality + 1; // base +1

                    if (item.name.equals("Pass VIP Concert")) {

                        if (item.sellIn < 11) { // 10 jours au moins
                            if (item.quality < 50) {
                                item.quality = item.quality + 1; // +1
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }


            // décrément du sellIn
            if (!item.name.equals("Kryptonite")) {
                item.sellIn = item.sellIn - 1;
            }
            // règle après expiration sellIn < 0
            if (item.sellIn < 0) {
                if (!item.name.equals("Comté")) {
                    if (!item.name.equals("Pass VIP Concert")) {

                        if (item.quality > 0) {
                            if (!item.name.equals("Kryptonite")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        // pass VIP : une fois la date passé, qualité = 0
                        item.quality = 0 ; // = items.quality - items.quality;
                    }
                } else {
                    // Comté après expiration
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
