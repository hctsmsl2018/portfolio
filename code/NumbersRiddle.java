/*
 * Activity 1.1.6
 */
public class NumbersRiddle
{
  public static void main(String[] args) {
    /* Choose any integer, double it, add six, 
    divide it in half, and subtract the number 
    you started with. The answer is always three! */
    
    // Test cases
    int positiveI = 2;
    int negativeI = -1;
    int zero = 0;
    int one = 1;
    double positiveD = 1.5;
    double negativeD = -0.5;
    
    // Run calculations for each value
    calculate(positiveI);
    calculate(negativeI);
    calculate(zero);
    calculate(one);
    calculate(positiveD);
    calculate(negativeD);
  }
  
  public static void calculate(double startingNumberChosen) {
    // print initial number
    System.out.println("Starting number: " + startingNumberChosen);
    // double number
    double doubleNumber = startingNumberChosen * 2;
    System.out.println(startingNumberChosen + " * 2 = " + doubleNumber);
    // add 6 to previous result
    double addSix = doubleNumber + 6;
    System.out.println(doubleNumber + " + 6 = " + addSix);
    // divide previous result by 2
    double divideHalf = addSix / 2;
    System.out.println(addSix + " / 2 = " + divideHalf);
    // subtract initial number from previous result
    double subtractStarting = divideHalf - startingNumberChosen;
    System.out.println(divideHalf + " - " + startingNumberChosen + " = " + subtractStarting  + "\n");
  }

  /* Output:

  Starting number: 2.0
  2.0 * 2 = 4.0 
  4.0 + 6 = 10.0
  10.0 / 2 = 5.0
  5.0 - 2.0 = 3.0      

  Starting number: -1.0
  -1.0 * 2 = -2.0      
  -2.0 + 6 = 4.0       
  4.0 / 2 = 2.0        
  2.0 - -1.0 = 3.0

  Starting number: 0.0
  0.0 * 2 = 0.0
  0.0 + 6 = 6.0
  6.0 / 2 = 3.0
  3.0 - 0.0 = 3.0

  Starting number: 1.0
  1.0 * 2 = 2.0
  2.0 + 6 = 8.0
  8.0 / 2 = 4.0
  4.0 - 1.0 = 3.0

  Starting number: 1.5
  1.5 * 2 = 3.0
  3.0 + 6 = 9.0
  9.0 / 2 = 4.5
  4.5 - 1.5 = 3.0

  Starting number: -0.5
  -0.5 * 2 = -1.0
  -1.0 + 6 = 5.0
  5.0 / 2 = 2.5
  2.5 - -0.5 = 3.0

  */
}