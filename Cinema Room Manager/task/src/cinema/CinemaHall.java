package cinema;

import java.util.Scanner;

public class CinemaHall {
    private static final int FRONT_ROW_TICKET_PRICE = 10;
    private static final int BACK_ROW_TICKET_PRICE = 8;
    private static final int MAX_ROWS = 9;
    private static final int MAX_SEATS_PER_ROW = 9;

    private static int totalIncome;
    private static int totalSeats;
    private static int numTicketsPurchased;
    private static int numRows;
    private static int numSeatsPerRow;
    private static String[][] cinemaStatus;

    static final Scanner sc = new Scanner(System.in);

    static void initializeCinemaLayout() {
        while (true) {
            System.out.println("Enter the number of rows (1-9):");
            numRows = sc.nextInt();

            if (numRows > 0 && numRows <= MAX_ROWS) {
                break;
            }

            System.out.println("Invalid input. The number of rows should be between 1 and 9.\n");
        }

        while (true) {
            System.out.println("Enter the number of seats in each row (1-9):");
            numSeatsPerRow = sc.nextInt();

            if (numSeatsPerRow > 0 && numSeatsPerRow <= MAX_SEATS_PER_ROW) {
                break;
            }

            System.out.println("Invalid input. The number of seats per row should be between 1 and 9.\n");
        }

        System.out.println();

        cinemaStatus = new String[numRows + 1][numSeatsPerRow + 1];

        for (int i = 0; i <= numRows; i++) {
            for (int j = 0; j <= numSeatsPerRow; j++) {
                if (i == 0 && j == 0) {
                    cinemaStatus[i][j] = " ";
                } else if (j == 0) {
                    cinemaStatus[i][j] = Integer.toString(i);
                } else if (i == 0) {
                    cinemaStatus[i][j] = Integer.toString(j);
                } else {
                    cinemaStatus[i][j] = "S";
                    totalSeats++;
                }
            }
        }
    }

    static void mainMenu() {
        CinemaHall cinemaHall = new CinemaHall();

        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            switch (sc.nextInt()) {
                case 0:
                    return;
                case 1:
                    CinemaHall.displayCinemaStatus();
                    break;
                case 2:
                    cinemaHall.pickSeatAndUpdateCinemaStatus();
                    cinemaHall.displayTicketPrice(cinemaHall.calculateTicketPrice(cinemaHall.rowNumChosen));
                    break;
                case 3:
                    CinemaHall.displayStatistics();
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }

    static void displayCinemaStatus() {
        System.out.println("\nCinema:");

        for (int i = 0; i <= numRows; i++) {
            for (int j = 0; j <= numSeatsPerRow; j++) {
                System.out.print(cinemaStatus[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    static void displayStatistics() {
        System.out.println("\nNumber of purchased tickets: " + numTicketsPurchased);
        System.out.printf("Percentage: %.2f%%\n", ((double) numTicketsPurchased / (double) totalSeats) * 100);
        System.out.println("Current income: $" + totalIncome);
        System.out.println("Total income: $" +
                ((numRows < 4)
                        ? (numRows * numSeatsPerRow * FRONT_ROW_TICKET_PRICE)
                        : (4 * numSeatsPerRow * FRONT_ROW_TICKET_PRICE) + ((numRows - 4) * numSeatsPerRow * BACK_ROW_TICKET_PRICE)));
        System.out.println();
    }


    int rowNumChosen;
    int seatNumInRowChosen;

    void pickSeatAndUpdateCinemaStatus() {
        while (true) {
            System.out.println("\nEnter a row number:");
            rowNumChosen = sc.nextInt();

            System.out.println("Enter a seat number in that row:");
            seatNumInRowChosen = sc.nextInt();

            if (!(rowNumChosen > 0 && rowNumChosen <= numRows && seatNumInRowChosen > 0 && seatNumInRowChosen <= numSeatsPerRow)) {
                System.out.println("Wrong input!");
            } else if (cinemaStatus[rowNumChosen][seatNumInRowChosen].equals("B")) {
                System.out.println("That ticket has already been purchased!");
            } else {
                break;
            }
        }

        cinemaStatus[rowNumChosen][seatNumInRowChosen] = "B";

        numTicketsPurchased++;
    }

    int calculateTicketPrice(int rowNum) {
        return rowNum <= 4 ? FRONT_ROW_TICKET_PRICE : BACK_ROW_TICKET_PRICE;
    }

    void displayTicketPrice(int ticketPrice) {
        totalIncome += ticketPrice;
        System.out.println("Ticket price: $" + ticketPrice + "\n");
    }
}

