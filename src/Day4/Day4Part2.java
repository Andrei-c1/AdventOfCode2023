package Day4;

import utils.InputReader;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day4Part2 {
    int[] integerArray = new int[195];
    AtomicInteger atomicInt = new AtomicInteger(0);
    public Day4Part2() {
        Arrays.fill(this.integerArray,0);
    }

    public int findMatch(String s){
        atomicInt.incrementAndGet();
        int count = 0;
        Set<String> winningNumbers = new HashSet<>(List.of(s.split("\\|")[0].trim().replace("  ", " ").split(" ")));
        Set<String> numbers = new HashSet<>(List.of(s.split("\\|")[1].trim().replace("  ", " ").split(" ")));

        for(String elem:numbers){
            if(winningNumbers.contains(elem)){
                count++;
            }
        }
        return count;
    }


    public void result(){
        List<String> input = InputReader.readInputByLine("inputs/inDay4.txt");

        List<String> inputTest = new ArrayList<>();
        inputTest.add("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53\n");
        inputTest.add("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19\n");
        inputTest.add("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1\n");
        inputTest.add("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83\n");
        inputTest.add("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36\n");
        inputTest.add("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11\n");

        input.stream()
                .map(s-> s.split(":")[1].trim())
                .map(this::findMatch)
                .forEach(this::convertPoints);
        }

    public void convertPoints(int nrMatches) {
        int game = atomicInt.get();
        this.integerArray[game]++;
        int stars = integerArray[game];

        for(int i=1;i<=nrMatches;i++){
            this.integerArray[game+i] = this.integerArray[game+i] +stars;
        }

    }

    public static void main(String[] args) {
            Day4Part2 day4Part1 = new Day4Part2();
            day4Part1.result();
            int sum = 0;
            for(int i=0;i<195;i++){
                sum = sum + day4Part1.integerArray[i];
            }
            System.out.println(sum);
        }
    }
