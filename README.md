# Scribble App

This repository contains a very small Java Swing application that provides a
simple sketchpad for free‑hand drawing.  The user can click and drag the mouse
to draw continuous strokes on a blank canvas.  A **Reset** button clears
everything, returning the pad to its initial blank state.

## Features

* **Free‑hand drawing:** click and drag to draw smooth lines on the canvas.
* **Reset button:** quickly erase all your strokes and start over.
* **Resizable window:** the drawing area adjusts itself when you resize the
  window.

This project does not rely on any external libraries; it is built entirely
with standard Java (`javax.swing` and `java.awt`) classes, so it will run on
any system with a Java Runtime Environment (JRE) installed.

## How to build and run

You can compile and run the application from the command line using the
standard Java compiler (`javac`).  The following commands assume you have
Java 17 or later on your `PATH`.

```sh
# Navigate into the project directory
cd scribble-app

# Compile the source file (classes will be placed in the current directory)
javac -d out src/ScribbleApp.java

# Run the application using the compiled class files
java -cp out ScribbleApp
```

Alternatively, you can open the project in your favourite IDE (VS Code,
IntelliJ IDEA, Eclipse, etc.) and run it directly as a Java application.
To do this you should mark the `src` folder as the source directory and make
sure the IDE is configured with a compatible Java SDK (e.g. Java 17 or later).

When the window appears you can begin drawing immediately.  To clear the
canvas at any time, click the **Reset** button at the bottom of the window.
