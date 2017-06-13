import javafx.*;

public class WarGUI extends Application {

  @Override
  public void start(Stage primaryStage)
  {
    Button btn = new Button();
    btn.setText("Start new game");
    btn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event){
        System.out.println("TEST");
      }
    });

    //will need to merge this and War.java
    Label p1 = new Label("Player one has " + playerOne.size() + " cards.");
    Label p2 = new Label("Player two has " + playerTwo.size() + " cards.");

    //here we need to display the next card. Will need to be integratred with
    //input
    

    StackPane root = new StackPane();
    root.getChildren().add(btn);
    root.getChildren().add(p1);
    root.getChildren().add(p2);

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
