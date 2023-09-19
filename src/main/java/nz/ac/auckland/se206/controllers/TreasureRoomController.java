package nz.ac.auckland.se206.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import nz.ac.auckland.se206.CountdownTimer;
import nz.ac.auckland.se206.SceneManager;
import nz.ac.auckland.se206.SceneManager.AppUi;
import nz.ac.auckland.se206.TransitionAnimation;

public class TreasureRoomController extends ItemRoomController {
  @FXML
  private Pane pane;
  @FXML
  private Polygon leftShpe;
  @FXML
  private ImageView itemSixImg;
  @FXML
  private ImageView itemSevenImg;
  @FXML
  private ImageView itemEightImg;
  @FXML
  private ImageView itemNineImg;
  @FXML
  private ImageView itemTenImg;

  @FXML
  private Label timerLabel;

  private CountdownTimer countdownTimer;

  /**
   * Setting the appropriate fields and listeners when scene is initialised.
   * This includes initialising whether an item is clicked or already added
   * to the inventory, whether an item is ready to be added, whether the bag
   * is already opened, initialising the countdown timer and diabling the
   * mouseTrackRegion appropriately.
   */
  public void initialize() {
    // Initialising everything from the superclass
    genericInitialise("Treasure", itemSixImg, itemSevenImg, itemEightImg, itemNineImg, itemTenImg, leftShpe);
    countdownTimer = MainMenuController.getCountdownTimer();
    countdownTimer.setRightTimerLabel(timerLabel);
  }

  /**
   * Changing scenes to the cauldron room
   */
  @FXML
  public void goLeft(MouseEvent event) {
    System.out.println("TREASURE_ROOM -> CAULDRON_ROOM");
    // Resetting appropriate fields before changing scenes
    setText("", false, false);
    readyToAdd = false;
    itemScroll.setOpacity(0);
    bagOpened = false;
    SceneManager.setTimerScene(AppUi.CAULDRON_ROOM);
    TransitionAnimation.changeScene(pane, AppUi.CAULDRON_ROOM, false);
  }

  /** Chaning scenes to book view */
  @FXML
  public void openBook() {
    BookController bookController = SceneManager.getBookControllerInstance();
    if (bookController != null) {
      bookController.updateBackground();
    }
    // Transitioning to the book scene with the appropriate fade animation
    System.out.println("TREASURE_ROOM -> BOOK");
    SceneManager.currScene = AppUi.TREASURE_ROOM;
    TransitionAnimation.changeScene(pane, AppUi.BOOK, false);
  }
}
