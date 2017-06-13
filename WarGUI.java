package helloworld;

import javafx.*;

public class WarGUI extends Application {

  @Override
  public void start(Stage primaryStage)
  {
    Button btn = new Button();
    btn.setText("Welcome to the game of war");
    btn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event){
        System.out.println("TEST");
      }
    });

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    Scene scene = new Scene(root, 300, 250);
    primaryStage.setTitle("The Game Of War");
    primaryStage.setScene(scene);
    PrimaryStage.show();
  }

  public static void main(String[] args)
  {
    launch(args);
  }
}
