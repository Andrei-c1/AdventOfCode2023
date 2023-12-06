package Day3;

import utils.InputReader;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day3Part2 {

    int sum = 0;

    public void calculateSum(List<Integer> twoNums){
        int mult = 1;
        for(int nums :twoNums){
            mult = mult * nums;
        }
        this.sum = sum+mult;
    }

    public void findNumber(List<String> input,int line,int col){

        List<Integer> twoNumbers = new ArrayList<>();

        for(int x= line-1; x<=line+1 ; x++){
            for(int y= col-1;y <= col+1;y++){
                 if((x>=0) && (x<input.size()) && (y>=0) && (y<input.size())){
                    if(Character.isDigit(input.get(x).charAt(y))){
                        twoNumbers.add(retriveNumber(input,x,y));
                    }
                }
            }
        }
        if(twoNumbers.size()== 2){
            calculateSum(twoNumbers);
        }
    }

    private int retriveNumber(List<String> input, int x, int y) {
        while(y<input.size() - 1  && Character.isDigit(input.get(x).charAt(y+1)) ){
            y++;
        }
        int num = 0;
        int p =0;

        while(y>=0 & Character.isDigit(input.get(x).charAt(y))){
            int currentDigit = input.get(x).charAt(y) - '0';
            num = (int) (num  + currentDigit * Math.pow(10, p));
            p++;
            eliminateNumberFromInput(input, x, y);
            y--;
            if(y==-1){
                break;
            }
        }
        return num;
    }

    private static void eliminateNumberFromInput(List<String> input, int x, int y) {
        String originalLine = input.get(x);
        StringBuilder modifiedLine = new StringBuilder(originalLine);
        modifiedLine.setCharAt(y, '.');
        input.set(x,modifiedLine.toString());
    }


    public void findSpecial(List<String> input){
        int currentLine=0;
        for(String line:input){
            for(int i=0; i<input.size();i++){
                char c = line.charAt(i);
                if(c == '*'){
                   findNumber(input,currentLine,i);
                }
            }
            currentLine++;
        }
    }




    public void result(){
        List<String> input = InputReader.readInputByLine("inputs/inDay3.txt");
        findSpecial(input);
        }

    public static void main(String[] args) {
            Day3Part2 day3Part1 = new Day3Part2();
            day3Part1.result();
            System.out.println(day3Part1.sum);

        }

    }
