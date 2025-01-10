# Maze Program

## Overview

The Maze Program is a Java application that allows users to navigate through a maze. It provides both a 2D and a 3D view of the maze, with the ability to toggle between these views dynamically using the spacebar. The program tracks and displays the number of steps taken by the player, which are updated as the player moves through the maze.

## Features

- **Dynamic View Toggle:** Switch between 2D and 3D views of the maze using the spacebar.
- **Interactive Controls:** Use keyboard arrow keys to navigate through the maze.
- **Step Counter:** Tracks the number of steps the player takes as they navigate the maze.
- **Directional Indicators:** Visual indicators show the current facing direction of the hero (N, S, E, W).
- **Customizable Maze:** The maze layout can be modified by editing the "Maze.txt" file.

## How It Works

The application renders the maze using a 2D array where the maze's walls and paths are defined. In 3D mode, walls are rendered with perspective to provide a sense of depth. The player's movements are tracked, and the display updates to reflect the current state of the maze and the player's position.

## Setup and Running the Application

### Prerequisites

- Java Development Kit (JDK) installed on your machine.
- Basic knowledge of running Java applications.

### Running the Game

1. **Compile the Java File:**
   - Navigate to the directory containing `MazeProgram.java`.
   - Compile the file using the command:
     ```bash
     javac MazeProgram.java
     ```
2. **Run the Compiled Class:**
   - Start the application using the command:
     ```bash
     java MazeProgram
     ```
   - The game window will open, displaying the maze. Use the arrow keys to navigate and the spacebar to toggle the view.

## Controls

- **Arrow Keys:** Move the hero through the maze.
- **Spacebar:** Toggle between 2D and 3D views.

## Customization

- **Maze Configuration:** Modify the "Maze.txt" file to change the layout of the maze. Ensure the format of the maze remains consistent with the application's parsing logic.

## Conclusion

Enjoy exploring different maze configurations and challenge yourself to find the exit using the fewest steps possible. Whether you prefer a top-down view or an immersive 3D experience, the Maze Program offers a fun and engaging way to test your puzzle-solving skills.
