package Day5;

import utils.InputReader;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day5Part1 {
    List<Long> seedsStart = new ArrayList<>();
    List<Long> minLoc = new ArrayList<>();

    public void result(){

        String input = InputReader.readInputAsString("inputs/inDay5.txt");

        String testInput = "seeds: 79 14 55 13\n" +
                "\n" +
                "seed-to-soil map:\n" +
                "50 98 2\n" +
                "52 50 48\n" +
                "\n" +
                "soil-to-fertilizer map:\n" +
                "0 15 37\n" +
                "37 52 2\n" +
                "39 0 15\n" +
                "\n" +
                "fertilizer-to-water map:\n" +
                "49 53 8\n" +
                "0 11 42\n" +
                "42 0 7\n" +
                "57 7 4\n" +
                "\n" +
                "water-to-light map:\n" +
                "88 18 7\n" +
                "18 25 70\n" +
                "\n" +
                "light-to-temperature map:\n" +
                "45 77 23\n" +
                "81 45 19\n" +
                "68 64 13\n" +
                "\n" +
                "temperature-to-humidity map:\n" +
                "0 69 1\n" +
                "1 0 69\n" +
                "\n" +
                "humidity-to-location map:\n" +
                "60 56 37\n" +
                "56 93 4";

        String[] splittedS =input.split("(?m)^\\s*$");

        dataSetup(splittedS);

    }
    public void dataSetup (String[] s){
        String[] seeds = s[0].split(":")[1].trim().split(" ");
        for(String seed :seeds){
            this.seedsStart.add(Long.parseLong(seed));
        }
        System.out.println(this.seedsStart);
        mapping(s);
    }

    public void mapping(String[] in){
        for(Long seed : this.seedsStart){
            Long current = seed;

            for(int i=1 ; i < 8; i++){
                current = convertSeed(in[i].split(":")[1].trim(),current);

            }
            this.minLoc.add(current);
        }

    }

    private Long convertSeed(String trim,Long seed) {

        for(String elem : trim.split("\n")){
            long destinationRangeStart = Long.parseLong(elem.split(" ")[0].trim());
            long sourceRangeStart = Long.parseLong(elem.split(" ")[1].trim());
            long rangeLenght = Long.parseLong(elem.split(" ")[2].trim());

            if(isWithinRange(seed, sourceRangeStart, sourceRangeStart + rangeLenght)){
               return (seed - sourceRangeStart) + destinationRangeStart;
            }
        }
        return seed;
    }
    public boolean isWithinRange(Long number, Long lowerBound, Long upperBound) {
        return number >= lowerBound && number < upperBound;
    }

    public static void main(String[] args) {
            Day5Part1 day5Part1 = new Day5Part1();
            day5Part1.result();
             System.out.println(Collections.min(day5Part1.minLoc));
        }
    }
