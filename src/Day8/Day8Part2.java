package Day8;

import utils.InputReader;
import utils.Pair;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day8Part2 {

    List<String> instructions = new ArrayList<>();
    Map<String, Pair<String,String>> directions = new HashMap<>();
    List<String> starts = new ArrayList<>();
    List<Integer> cycles = new ArrayList<>();
    public static void main(String[] args) {
        Day8Part2 day4Part1 = new Day8Part2();
        day4Part1.result();
    }

    private void result() {
        List<String> input = InputReader.readInputByLine("inputs/inDay8.txt");
        dataSetUp(input);
        //escape();
        for(String elem :this.starts){
            findCycles(elem);
        }
   }

    private void findCycles(String current) {
        String firstZ = null;
        int currentStep = 0;
        int count = 0;

        while(true){
            if(currentStep == instructions.size()){
                currentStep = 0;
            }
            if(firstZ != null){
                count++;
            }

            current = (Objects.equals(this.instructions.get(currentStep), "L")) ? this.directions.get(current).getKey()
                                                                              : this.directions.get(current).getValue();
            if(current.equals(firstZ)){
                break;
            }

            if(firstZ == null && current.matches(".{2}Z$")){

                firstZ = current;
            }


            currentStep += 1;
        }

        this.cycles.add(count);
        System.out.println(count);

    }

    private void dataSetUp(List<String> input) {
        String dir = input.get(0);
        instructions.addAll(Arrays.asList(dir.split("")));

        int i = 2;

        while(i<input.size()){
            String first = input.get(i).split("=")[0].trim();
            String left = input.get(i).split("=")[1].trim().split(",")[0].replace("(","").trim();
            String right = input.get(i).split("=")[1].trim().split(",")[1].replace(")","").trim();
            directions.put(first,new Pair<>(left,right));
            if(first.matches(".{2}A$"))
                starts.add(first);
            i++;
        }
    }
}


