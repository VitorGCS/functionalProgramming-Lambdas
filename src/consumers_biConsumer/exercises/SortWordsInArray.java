package consumers_biConsumer.exercises;

import java.util.Arrays;
import java.util.Optional;

public class SortWordsInArray {

    public static void main(String[] args) {
/*        System.out.print("Please, enter 7 words separated by space: ");
        //create the Scanner
        Scanner terminalInput = new Scanner(System.in, "UTF-8");

        //read input
        String s = terminalInput.nextLine();*/
        //String s = "microsoft windows oracle apple Apple zpple";
        String userInput = "apple windows oracle microsoft Apple z]pple";

        String[] words = userInput.split("\\s+");

        Arrays.sort(words, (s1, s2) -> {
            int result = s2.length() - s1.length();
            if (result == 0) {
                result = s1.compareToIgnoreCase(s2);
            }
            return result;
        });
        Optional<String> result = Arrays.stream(words).reduce((a,b) -> a+" "+b);
        System.out.println(result.get());
    }
}

