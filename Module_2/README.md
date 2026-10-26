# CSD-420 — Random Playing Cards

## Contents
- `RandomCards.java`: JavaFX application using a lambda expression for the Refresh button.
- `cards/1.png` through `cards/52.png`: the 52 playing-card images.

## Requirements
- A JDK
- JavaFX SDK (JavaFX is not bundled with most modern JDK installations)

## Run from this directory
Replace `/path/to/javafx-sdk/lib` with the actual `lib` directory inside your JavaFX SDK.

```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls RandomCards.java
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls RandomCards
```

Keep the `cards` folder beside `RandomCards.java` and run the commands from this project directory.

## Features
- Displays four randomly selected, unique cards.
- The Refresh button uses a lambda expression.
- Refresh selects four cards that do not overlap with the immediately previous set.

## Submission reminder
Capture your own screenshots showing the application running and your Java/JavaFX setup, then combine them in a Word document with your name, date, and assignment number. Add your GitHub repository URL in the assignment comments.
