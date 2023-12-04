package Day1;


import utils.InputReader;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day1Part2 {

    Set<Character> numSet = new HashSet<>(Set.of('1', '2', '3','4','5','6','7','8','9'));
    Map<String,String> numMap = new HashMap<>(Map.of("one", "one1one", "two", "two2two",
            "three", "three3three", "four", "four4four", "five", "five5five",
            "six", "six6six", "seven", "seven7seven", "eight", "eight8eight", "nine", "nine9nine"));



    public String stringDigitsConverter(String s){
        for(Map.Entry<String,String> e : numMap.entrySet()){
            s = s.replace(e.getKey(),e.getValue());
        }
        return s;
    }
    public String firstNLastDigits(String s){
        String f = null;
        String l = null;

        for(int i=0 ; i <= s.length() -1 ; i++) {
            if (f != null && l != null) {
                break;
            }
            if (numSet.contains(s.charAt(i)) && f == null) {
                f = String.valueOf(s.charAt(i));
            }
            if (numSet.contains(s.charAt(s.length() - 1 - i)) && l == null) {
                l = String.valueOf(s.charAt(s.length() - 1 - i));
            }
        }

        return f + l ;
    }
    public int result(){

        List<String> input = InputReader.readInputByLine("inputs/inDay1.txt");
        return input.stream()
                .map(this::stringDigitsConverter)
                .map(this::firstNLastDigits)
                .map(Integer::parseInt)
                .reduce(0,Integer::sum);

    }

    public static void main(String[] args) {
        Day1Part2 day1Part2 = new Day1Part2();
        System.out.println(day1Part2.result());
        }

    }
