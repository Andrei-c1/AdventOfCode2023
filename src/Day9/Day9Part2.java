package Day9;

import utils.InputReader;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day9Part2 {

    public static void main(String[] args) {
        Day9Part2 day4Part1 = new Day9Part2();
        day4Part1.result();
    }

    public int x (List<String[]> o){
        return 1;
    }

    private void result() {
        List<String> input = InputReader.readInputByLine("inputs/inDay9.txt");
        Optional<Integer> x =input.stream()
                .map(this::idk)
                .map(this::getSpecialNumber)
                .reduce(Integer::sum);
        System.out.println(x);
    }

    public int getSpecialNumber(List<int[]> numbers) {
        int sum = 0;

        for (int i = numbers.size() - 2; i >= 0; i--) {
            sum =  numbers.get(i)[0] - sum;
        }
        System.out.println("THE SUM IS =============> : "+sum);
        return  sum;


    }
    boolean allZeros (int[] array){
        for(int num : array){
            if(num != 0)
                return false;
        }
        return true;
    }

    public List<int[]> idk(String s){
        //List<int[]> list = new ArrayList<>();
        List<int[]> list = new Stack<>();
        int lenght = s.split(" ").length;

        int[]  p = new int[lenght];
        for(int i=0;i<s.split(" ").length;i++){
            p[i] = Integer.parseInt(s.split(" ")[i]);
        }
        list.add(p);
        int sum = IntStream.of(p).sum();
        boolean allZero = allZeros(p);

        while( !allZero){
            lenght--;
            int[] x = new int[lenght];
            for(int i=0 ; i<list.get(list.size()-1).length-1;i++){
                x[i] = list.get(list.size()-1)[i+1] - list.get(list.size()-1)[i];
            }
            list.add(x);
            allZero = allZeros(x);

        }
        for (int[] elem: list) {
            System.out.println(Arrays.toString(elem));
        }
        return list;
    }

}


