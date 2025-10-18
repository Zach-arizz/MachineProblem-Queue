import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class SupportSystem {
    public static void main(String[] args) {
        // Initializes the Queue to hold Ticket objects.
        Queue<Ticket> ticketQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the IT Support Ticketing System!");
        System.out.println("\n--- Enter Ticket Details ---");

        // Loop runs 3 times to collect and enqueue tickets.
        for (int i = 1; i <= 3; i++) {
            System.out.println("Please enter details for ticket " + i + " of 3.");

            System.out.print("Enter your name: ");
            String userName = scanner.nextLine();

            System.out.print("Describe your issue: ");
            String issueDescription = scanner.nextLine();

            Ticket newTicket = new Ticket(userName, issueDescription);
            // offer() adds the new ticket to the rear of the queue.
            ticketQueue.offer(newTicket);
            System.out.println();
        }

        System.out.println("-------------------------------------------");
        System.out.println("All tickets have been logged.");
        System.out.println("There are " + ticketQueue.size() + " tickets waiting in the queue.");
        System.out.println("-------------------------------------------");
        System.out.println("\n--- Processing Tickets ---");

        // Loop processes the first two tickets in the queue.
        for (int i = 0; i < 2; i++) {
            // poll() retrieves and removes the ticket from the front of the queue (FIFO).
            Ticket currentTicket = ticketQueue.poll();

            if (currentTicket != null) {
                System.out.println("Resolving: " + currentTicket);
            }
        }
        System.out.println("-------------------------------------------");

        System.out.println("\nAll done for now.");
        // Prints the list of remaining tickets.
        System.out.println("Remaining tickets in queue: " + ticketQueue);

        scanner.close();
    }
}