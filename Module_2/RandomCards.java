/*
 * Name: Luis Rodriguez
 * Course: CSD-420
 * Assignment: Random Playing Cards
 * Date: October 25, 2026
 *
 * This JavaFX application displays four randomly selected playing cards.
 * The Refresh button selects a new set of four unique cards.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RandomCards extends Application {
    private final HBox cardRow = new HBox(15);
    private List<Integer> previousCards = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        cardRow.setAlignment(Pos.CENTER);

        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(event -> showRandomCards());

        VBox root = new VBox(20, cardRow, refreshButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(25));
        root.setStyle("-fx-background-color: #176b3a;");

        showRandomCards();

        Scene scene = new Scene(root, 560, 250);
        stage.setTitle("Random Playing Cards");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void showRandomCards() {
        List<Integer> selected = new ArrayList<>();

        // Shuffle all 52 card numbers and choose four unique cards.
        do {
            selected.clear();
            List<Integer> deck = new ArrayList<>();
            for (int i = 1; i <= 52; i++) {
                deck.add(i);
            }
            Collections.shuffle(deck);
            selected.addAll(deck.subList(0, 4));
        } while (!previousCards.isEmpty() && selected.stream().anyMatch(previousCards::contains));

        cardRow.getChildren().clear();

        for (int cardNumber : selected) {
            File cardFile = new File("cards" + File.separator + cardNumber + ".png");
            Image image = new Image(cardFile.toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(145);
            imageView.setPreserveRatio(true);
            cardRow.getChildren().add(imageView);
        }

        previousCards = new ArrayList<>(selected);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
