package nz.ac.auckland.se206;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class CountdownTimer {
  private static int minutes;
  private static int initialSeconds;
  private static int currentSeconds;
  private Timeline timeline;
  private Label cauldronTimerLabel;
  private Label leftTimerLabel;
  private Label rightTimerLabel;
  private Label bookTimerLabel;

  public CountdownTimer(String timeLimit) {
    String[] time = timeLimit.split(":");
    minutes = Integer.parseInt(time[0]);
    initialSeconds = Integer.parseInt(time[1]);
    currentSeconds = Integer.parseInt(time[1]);

    setupTimeline();
  }

  public static void setTimerLimit(String timeLimit) {
    String[] time = timeLimit.split(":");
    minutes = Integer.parseInt(time[0]);
    initialSeconds = Integer.parseInt(time[1]);
    currentSeconds = Integer.parseInt(time[1]);
  }

  // Set up the timer to count down every second
  public void setupTimeline() {
    timeline =
        new Timeline(
            new KeyFrame(
                Duration.seconds(1),
                event -> {
                  try {
                    oneSecondPassed();
                  } catch (IOException e) {
                    e.printStackTrace();
                  }
                  updateTimerLabel();
                }));
    timeline.setCycleCount(Timeline.INDEFINITE);
  }

  public void oneSecondPassed() throws IOException {
    if (currentSeconds == 0 && minutes == 0) {
      handleTimeOut();
      timeline.stop();
    } else if (currentSeconds == 0) {
      minutes--;
      currentSeconds = 60;
    }
    currentSeconds--;
  }

  // Start the timer
  public void start() {
    currentSeconds = initialSeconds;
    updateTimerLabel();
    timeline.play();
  }

  // Stop the timer
  public void stop() {
    timeline.stop();
    currentSeconds = initialSeconds;
    updateTimerLabel();
  }

  // Logic that occurs every second that updates the timer label. Make sure to name the timer labels
  // timerLabel!!!
  private void updateTimerLabel() {
    Parent currentSceneRoot = SceneManager.getUiRoot(SceneManager.getTimerScene());
    // System.out.println(
    //     "currentSceneRoot = "
    //         + currentSceneRoot
    //         + "  ||  current scene = "
    //         + SceneManager.getTimerScene()
    //         + "  ||  sec = "
    //         + currentSeconds
    //         + "  || cauldron timer = "
    //         + cauldronTimerLabel);

    if (currentSceneRoot != null) {

      Label timerLabel =
          (Label) currentSceneRoot.lookup("#timerLabel"); // Assuming the ID is "timerLabel"

      if (timerLabel != null) {
        timerLabel.setText(formatTimerText());
      }

      if (cauldronTimerLabel != null) {
        cauldronTimerLabel.setText(formatTimerText());
      }

      if (leftTimerLabel != null) {
        leftTimerLabel.setText(formatTimerText());
      }

      if (rightTimerLabel != null) {
        rightTimerLabel.setText(formatTimerText());
      }

      if (bookTimerLabel != null) {
        bookTimerLabel.setText(formatTimerText());
      }
    }
  }

  public String formatTimerText() {
    if (currentSeconds < 10) {
      return String.format("Time left: %d" + ":" + "0" + "%d", minutes, currentSeconds);
    } else {
      return String.format("Time left: %d" + ":" + "%d", minutes, currentSeconds);
    }
  }

  // Getters and setters
  public void setCauldronTimerLabel(Label cauldronTimerLabel) {
    this.cauldronTimerLabel = cauldronTimerLabel;
  }

  public void setLeftTimerLabel(Label leftTimerLabel) {
    this.leftTimerLabel = leftTimerLabel;
  }

  public void setRightTimerLabel(Label rightTimerLabel) {
    this.rightTimerLabel = rightTimerLabel;
  }

  public void setBookTimerLabel(Label bookTimerLabel) {
    this.bookTimerLabel = bookTimerLabel;
  }

  // Logic that occurs when the timer reaches 0 - sets the scene to the game over scene
  private void handleTimeOut() throws IOException {
    System.out.println("GAME_OVER");
    App.setRoot("you-lose"); // use App.setRoot() so that game over occurs in all scenes
  }
}
