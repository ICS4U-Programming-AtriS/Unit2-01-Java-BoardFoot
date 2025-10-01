import java.util.InputMismatchException;
// Scanner for user input
import java.util.Scanner;

/**
* This program, given the width and height of a Board Foot,
* will solve and calculate for the length of the Board Foot.
*
* @author  Atri Sarker
* @version 1.0
* @since   2025-10-01
*/
public final class BoardFoot {
  /**
   * Constant that defines how many cubic inches are within a Board Foot.
   */
  public static final double VOLUME = 144.0;
  /**
   * Private constructor to satisfy style checker.
   * @exception IllegalStateException for the utility class.
   * @see IllegalStateException
   */
  private BoardFoot() {
    // Prevents illegal states.
    throw new IllegalStateException("Utility class.");
  }

  /**
   * Function that solves and returns the length of a Board Foot,
   * given the width and height.
   *
   * @param width  The width of the Board Foot.
   * @param height The height of the Board Foot.
   * @return The length of the Board Foot.
   */
  public static double calculateBoardFoot(final double width,
      final double height) {
    // Calculate the length
    final double length = VOLUME / (width * height);
    return length;
  }

  /**
   * Entrypoint of the program.
   * @param args UNUSED.
   */
  public static void main(final String[] args) {
    // Welcome message
    System.out.print("This program figures out the length of a ");
    System.out.println("wooden board that is 1 board foot in dimension. ");
    System.out.printf("One board foot is %d inches\u00B3", VOLUME);
    // Initialize Scanner for user input.
    Scanner scanner = new Scanner(System.in);
    try {
      // Get width
      System.out.print("Enter the width [inches]: ");
      final double width = scanner.nextDouble();
      // Get height
      System.out.print("Enter the height [inches]: ");
      final double height = scanner.nextDouble();
      // Check if the inputs are greater than 0
      if (width <= 0 && height <= 0) {
        // If they aren't, give an error message
        // Error message for non-existent dimensions. [IN RED]
        System.out.println("\033[0;31mERROR: INPUTS MUST BE GREATER THAN 0.");
      } else {
        // Call the function to solve for length
        final double length = calculateBoardFoot(width, height);
        // Display the length [IN BLUE]
        System.out.printf("\033[0;33m Solved Length: %.6f", length);
        System.out.println(" inches.");
      }

    } catch (InputMismatchException error) {
      // Error message for non-numeric dimensions. [IN RED]
      System.out.println("\033[0;31mERROR: INPUT MUST BE NUMERIC.");
    }
    // Close scanner
    scanner.close();
  }
}
