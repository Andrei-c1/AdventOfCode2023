package Day14;

import utils.InputReader;
import utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day14Part1 {

    public static void main(String[] args) {
        Day14Part1 day4Part1 = new Day14Part1();
        day4Part1.result();
    }

    private void result() {

        List<String> input = InputReader.readInputByLine("inputs/inDay14.txt");
        List<String> inputTranspose = transposeList(input);
        List<String> tilted = tilt(inputTranspose,inputTranspose.get(0).length());


    }
    public String sortString(String s){
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        reverseArray(charArray);

        return Arrays.toString(charArray);
    }
    private static void reverseArray(char[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;


            left++;
            right--;
        }
    }
    private List<String> tilt(List<String> inputTranspose, int length) {
        List<Pair<Character,Integer>> listConstruction = new ArrayList<>();
        int tot = 0;
        for(String s:inputTranspose) {
            String x = Arrays.stream(s.split("#"))
                    .map(this::sortString)
                    .collect(Collectors.joining("#"));


            String col = x.replaceAll(",","").replaceAll(" ","").replaceAll("\\[", "").replaceAll("\\]", "");
            int scale = length;
            for(int o = 0; o<col.length();o++){
                if(col.charAt(o) == 'O'){
                    tot = tot+scale;
                }
                scale--;
            }
        }
        System.out.println(tot);

        return inputTranspose;
    }


    private static List<String> transposeList(List<String> originalList) {

        int maxLength = originalList.stream()
                .map(String::length)
                .max(Integer::compareTo)
                .orElse(0);


        return IntStream.range(0, maxLength)
                .mapToObj(i -> originalList.stream()
                        .filter(s -> i < s.length())
                        .map(s -> Character.toString(s.charAt(i)))
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());
    }
}


