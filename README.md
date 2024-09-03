# Cinema Room Manager (Huge thanks to Hyperskill)

## Description

**Cinema Room Manager** is a console-based Java application that helps manage a cinema theatre. It allows users to visualize the seating arrangement, buy tickets, and view sales statistics. This project was created to learn and apply core Java concepts such as input/output operations, handling arrays, creating functions, and using loops and conditional statements.

## Features

- Visualize the seating arrangement.
- Buy tickets by selecting specific seats.
- View cinema statistics, including the number of tickets sold, percentage of seats sold, current income, and potential total income.
- Handle user input errors gracefully.

## Technologies Used

- Java

## Project Structure

The project consists of the following main components:

- `Cinema` class: The entry point of the application.
- `CinemaHall` class: Handles the core functionality, such as displaying the seating arrangement, managing ticket purchases, and calculating statistics.

## How to Run the Project

1. ```bash
   git clone https://github.com/alibnaqvi/cinema_room_manager.git
   ```

2. ```bash
   cd cinema-room-manager
   ```

3. ```bash
   javac cinema/Cinema.java
   ```

4. ```bash
   java cinema.Cinema
   ```

## Usage 

After running the program, you will be prompted to enter the number of rows and seats per row for the cinema:

```
Enter the number of rows (1-9):
5
Enter the number of seats in each row (1-9):
6
```

The main menu will then be displayed:

```
1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
```

a. Option 1: Displays the current seating arrangement. Available seats are marked with 'S', and sold seats are marked with 'B'.
b. Option 2: Allows you to buy a ticket by selecting a specific row and seat number. The ticket price is determined by the row number.
c. Option 3: Displays the cinema statistics, such as the number of purchased tickets, the percentage of occupancy, current income, and potential total income.
d. Option 0: Exits the application.

## Example

Here is an example of the program in action:

### 1. Display the seating arrangement

1. Show the seats

```
Cinema:
 1 2 3 4 5 6 
1 S S S S S S 
2 S S S S S S 
3 S S S S S S 
4 S S S S S S 
5 S S S S S S 
```

### 2. Buy a ticket

2. Buy a ticket

```
Enter a row number:
3
Enter a seat number in that row:
2
Ticket price: $10
```

### 3. View statistics

3. Statistics

```
Number of purchased tickets: 1
Percentage: 3.33%
Current income: $10
Total income: $270
```

## Contact

If you spot anything wrong with the program or would like to suggest improvements, feel free to email me at ali.b.naqvi@berkeley.edu. Thanks!
 
