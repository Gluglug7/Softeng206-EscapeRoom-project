package nz.ac.auckland.se206;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Items class that contains the items that are available and necessary to complete the room. The
 * items are stored in a set to ensure that there are no duplicates. The items are randomly selected
 * from the list of items.
 */
public class Items {
  /** 
   * Possible items the user can interact with in the room. Only the items in the available set
   * will be displayed to the user. The items in the necessary set are the items that are needed to
   * complete the room.
   */
  public enum Item {
    TAIL,
    INSECT_WINGS,
    FLOWER,
    SCALES,
    POWDER,
    TALON,
    CRYSTAL,
    BAT_WINGS,
    WREATH,
    FEATHER,
    BONE,
    FIRE,
    ROOT,
    BEETLE,
    UNICORN_HORN
  }

  public static List<Item> available;
  public static List<Item> necessary;
  private Item[] list =
      new Item[] {
        Item.TAIL,
        Item.INSECT_WINGS,
        Item.FLOWER,
        Item.SCALES,
        Item.POWDER,
        Item.TALON,
        Item.CRYSTAL,
        Item.BAT_WINGS,
        Item.WREATH,
        Item.FEATHER,
        Item.BONE,
        Item.FIRE,
        Item.ROOT,
        Item.BEETLE,
        Item.UNICORN_HORN
      };

  /**
   * Constructor that adds an appropriate number of random unique items to the available and
   * necessary sets. The available set contains all the items you can interact with within the room.
   * The necessary set contains the items that are needed to complete the room. ***********UPDATE
   * CHANGED TO A LIST INSTEAD OF A SET - ANDY 14/09/2023.
   *
   * @param n is the number of items needed to complete the room. Note that the number of items
   *     available is double those required to complete it. Currently, the maximum value for n is 5,
   *     given the number of items.
   */
  public Items(int n) {
    Random random = new Random();
    available = new ArrayList<>();
    necessary = new ArrayList<>();
    int i = 0;
    while (i < 2 * n) {
      Item item = list[random.nextInt(15)];
      if (!available.contains(item)) {
        available.add(item);
        if (necessary.size() < n) {
          necessary.add(item);
        }
        i++;
      }
    }
  }
}
