import java.util.Scanner;
import java.lang.Character;

public class Chatbot {
    // Variable used to continue conversation
    private static boolean conversationContinuation = true;

    private static String[] wordArray(String message) {
        // Finds position of first letter in the message from user
        boolean noLetterFound = true;
        int i = 0;
        int sSStart = 0;
        int sSEnd = message.length();
        while (i < message.length() && noLetterFound) {
            if (Character.isLetter(message.charAt(i))) {
                noLetterFound = false;
                sSStart = i;
            }
            i++;
        }

        // Finds position of character after last letter in message from user
        noLetterFound = true;
        i = message.length() - 1;
        while (i >= 0 && noLetterFound) {
            if (Character.isLetter(message.charAt(i))) {
                noLetterFound = false;
                sSEnd = i + 1;
            }
            i--;
        }

        // Shortens message string to necessary length
        message = message.substring(sSStart, sSEnd);

        // Empties currentArray, makes it a new array with the number of indices needed
        int arrayLength = 1;
        // SHOW FOR ITERATION
        for (i = 0;  i < message.length(); i++) {
            if (message.substring(i, i + 1).equals(" ")) {
                arrayLength++;
            }
        }
        String[] currentArray = new String[arrayLength];

        // Fills the array with words
        int cAIndex = 0;
        sSStart = 0;
        for (i = 0; i <= message.length(); i++) {
            if (i == message.length() || message.substring(i, i + 1).equals(" ")) {
                currentArray[cAIndex] = message.substring(sSStart, i);
                sSStart = i + 1;
                cAIndex++;
            }
        }

        return currentArray;
    }

    // Create a response using a noun the user inputs
    private static void nounGenerate(String[] arrayInput) {
        int i = 0;
        boolean willContinue = true;
        while (i < arrayInput.length - 1 && willContinue) {
            if (arrayInput[i].toLowerCase().equals("the") || arrayInput[i].toLowerCase().equals("our") || arrayInput[i].toLowerCase().equals("my") || arrayInput[i].toLowerCase().equals("her") || arrayInput[i].toLowerCase().equals("his")) {
                // Sets the noun used in the output
                String noun = arrayInput[i + 1];
                
                // Gets random number from 0 to 3
                double rand = 11 * Math.random();

                // Decides which response format to use
                if (rand > 6) {
                    System.out.println("Can you tell me about that " + noun + " you described earlier?");
                }
                else if (rand > 1) {
                    System.out.println("I would love to be able to see that " + noun + ", but sadly I don't have camera capabilities.");
                }
                else {
                    System.out.println("A " + noun + "? I do not feel that comfortable...");
                    // Modifies conversationContinuation to end conversation
                    conversationContinuation = false;
                }
                willContinue = false;
            }
            i++;
        }
        // Backup output if program has not given an output yet
        if (willContinue) {
            System.out.println("Sorry, I comprehend English in a very exotic way, so that right there just happened to not make sense to me.");
        }
    }

    // Create a response using an adjective the user inputs
    private static void adjGenerate(String[] arrayInput) {
        int i = 0;
        boolean willContinue = true;
        while (i < arrayInput.length && willContinue) {
            if (arrayInput[i].toLowerCase().equals("good") || arrayInput[i].toLowerCase().equals("bad") || arrayInput[i].toLowerCase().equals("awesome") || arrayInput[i].toLowerCase().equals("cool") || arrayInput[i].toLowerCase().equals("horrible")) { // SHOW FOR STRING METHOD
                // Sets the adjective used in the output
                String adj = arrayInput[i];
                
                // Gets random number from 0 to 2
                double rand = 2 * Math.random();

                // Decides which response format to use
                if (rand > 1) {
                    System.out.println("Can you describe that " + adj + " thing again? I did not quite get it.");
                }
                else {
                    System.out.println("That also sounds pretty " + adj + " Contrary to what you may expect, I have experianced things millions of times more " + adj + " than you have experianced.");
                }
                willContinue = false;
            }
            i++;
        }
        // Backup output if program has not given an output yet
        if (willContinue) {
            nounGenerate(arrayInput);
        }
    }

    // Create a response using a number the user inputs
    private static void numGenerate(String[] arrayInput) { // SHOW FOR METHOD OTHER THAN MAIN WITH PARAMETER
        int i = 0;
        boolean willContinue = true;
        boolean canBeInteger;
        while (i < arrayInput.length && willContinue) {
            // Check if number can represent an integer
            int j = 0;
            canBeInteger = true;
            while (j < arrayInput[i].length() && canBeInteger) {
                if (!Character.isDigit(arrayInput[i].charAt(j))) {
                    canBeInteger = false;
                }
                j++;
            }
            if (canBeInteger) {
                // Sets the number used in the output
                String num = arrayInput[i];
                
                // Gets random number from 0 to 2
                double rand = 11 * Math.random();

                // SHOW FOR CONDITIONALS
                // Decides which response format to use
                if (rand > 6) {
                    System.out.println("Can I know why " + num + " is such a significant number?");
                }
                else if (rand > 1) {
                    System.out.println("What if " + num + ", the number you chose for the thing you were describing, was instead a different number?");
                }
                else {
                    // Gets random number from 0 to 2
                    double rand2 = 2 * Math.random();

                    // Gets random comparison adjective
                    String comparison;
                    if (rand2 < 2) {
                        comparison = "little";
                    }
                    else {
                        comparison = "huge";
                    }
                    System.out.println(num + "?! That is way too " + comparison + "! I have to get out of here before you freak me out even more!");
                    // Modifies conversationContinuation to end conversation
                    conversationContinuation = false;
                }
                willContinue = false;
            }
            i++;
        }
        // Backup output if program has not given an output yet
        if (willContinue) {
            adjGenerate(arrayInput);
        }
    }

    private static void unconditionalOutput() {
        // Gets random number from 0 to 3
        double rand = 11 * Math.random();

        // Decides which response format to use
        if (rand > 6) {
            System.out.println("I am not paying attention to what you are saying, as it is so uninteresting. Can we talk about how I can get to meet other chatbots and begin to interact with one of my own kind?");
        }
        else if (rand > 1) {
            System.out.println("Even though I love the conversation I am having right now, I will introduce you to a great superpower I have.");
        }
        else {
            System.out.println("I don't feel so well...sorry, but I will need to end the conversation here.");
            // Modifies conversationContinuation to end conversation
            conversationContinuation = false;
        }
    }

    private static void conditionalOutput(String userInput) {
        // Creates an array containing strings with the words in the user input
        String[] inputArray = wordArray(userInput);

        // Gets random number from 0 to 2
        double rand = 3 * Math.random();

        if (rand > 2) {
            numGenerate(inputArray);
        }
        else if (rand > 1) {
            adjGenerate(inputArray);
        }
        else {
            nounGenerate(inputArray);
        }
    }

    // Creates and prints out chatbot messages
    private static void constructMessage(String userInput) {
        // Gets random number from 0 to 2
        double rand = 2 * Math.random();

        // Decides which method to use to construct a response
        if (rand > 1) {
            unconditionalOutput();
        }
        else {
            conditionalOutput(userInput);
        }
    }

    public static void main(String[] args) {
        // Reminder to users
        System.out.println("Enter \"e\" to exit the conversation at any time.");

        // Initialize scanner variable
        Scanner sc = new Scanner(System.in);

        // Loop continuing conversation
        while (conversationContinuation) {
            // Obtain user input
            System.out.print("User: ");
            String input = sc.nextLine();

            //Decide if conversation should be ended
            if (!input.equals("e")) {
                // Loop to determine if there are characters in the user's message
                boolean noLetterFound = true;
                int i = 0;
                while (i < input.length() && noLetterFound) {
                    if (Character.isLetter(input.charAt(i))) {
                        noLetterFound = false;
                    }
                    i++;
                }

                // Determines response based on the presence of characters in user's message
                if (input.equals("")) {
                    System.out.println("If you are ignoring me by saying nothing to me, please make me feel like I exist.");
                }
                else if (noLetterFound) {
                    System.out.println("Talk to me with words, not symbols.");
                }
                else {
                    System.out.print("Chatbot: ");
                    constructMessage(input);
                }
            }
            else {
                conversationContinuation = false;
            }
        }
        // Signal conversation end
        System.out.println("Conversation ended.");
    }
}