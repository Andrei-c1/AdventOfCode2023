package Day11;

import Day10.Position;
import utils.InputReader;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day11Part1 {

    List<List<Character>> space ;
    List<Pair<Integer,Integer>> galaxies = new ArrayList<>();

    

    public static void main(String[] args) {
        Day11Part1 day4Part1 = new Day11Part1();
        day4Part1.result();
    }

    private void result() {

        List<String> input = InputReader.readInputByLine("inputs/inDa88.txt");
        System.out.println(input);
        space =input.stream()
                .map(line -> line.chars().mapToObj(c -> (char) c).toList())
                .toList();
        
        findGalaxies();
        System.out.println(galaxies.size());
        System.out.println((450*449)/2);
        calulateDistance();

    }

    private int manhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    private void calulateDistance() {
        long result = 0;
        int t = 0;
        for (int i = 0; i < galaxies.size(); i++) {
            for (int j = i+1; j < galaxies.size(); j++) {
               t++;

               result = result + manhattanDistance(galaxies.get(i).getKey(),galaxies.get(i).getValue(),galaxies.get(j).getKey(),galaxies.get(j).getValue());
               long x = findExpansion(galaxies.get(i),galaxies.get(j));
                System.out.println(x);
               result = result + x ;
            }
        }
        System.out.println(result);
        System.out.println(t);
    }

    private int findExpansion(Pair<Integer, Integer> g1, Pair<Integer, Integer> g2) {
        int exp = 0;
        int x1 = Math.min(g1.getKey(), g2.getKey());
        int x2 = Math.max(g1.getKey(), g2.getKey());
        int y1 = Math.min(g1.getValue(), g2.getValue());
        int y2 = Math.max(g1.getValue(), g2.getValue());

        for(int i=y1; i<=y2;i++){
            if(!space.get(i).contains('#'))
                exp++;
        }

        for(int i=x1; i<=x2;i++){
            boolean e = true;
            for(int j=0; j<space.size();j++){
                if(space.get(j).get(i) == '#')
                    e = false;
            }
            if(e)
                exp++;
        }
     return  exp;
    }

    private void findGalaxies() {
        for(int i = 0 ; i < space.size();i++ ){
            for(int j = 0 ; j< space.get(0).size(); j++){
                if(space.get(j).get(i) == '#'){
                   galaxies.add(new Pair<>(i,j));
                }
            }
        }
    }

}


