package Day7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Hand implements Comparable<Hand> {

    static int FIVE_OF_A_KIND = 6;
    static int FOUR_OF_A_KIND = 5;
    static int FULL_HOUSE = 4;
    static int THREE_OF_A_KIND = 3;
    static int TWO_PAIR = 2;
    static int ONE_PAIR = 1;
    static int HIGH_CARD = 0;

    private int bid;

    public int getBid() {
        return bid;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + Arrays.toString(cards) +
                ", type=" + type +
                '}';
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int[] getCards() {
        return cards;
    }

    public void setCards(int[] cards) {
        this.cards = cards;
    }

    public HashMap<Integer, Integer> getSingleCardCount() {
        return singleCardCount;
    }

    public void setSingleCardCount(HashMap<Integer, Integer> singleCardCount) {
        this.singleCardCount = singleCardCount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int[] cards = new int[5];
    private HashMap<Integer,Integer> singleCardCount = new HashMap<>();
    private int type = -1;

    public Hand(String s){


        this.bid = Integer.parseInt(s.split(" ")[1]);
        int i=0;
        for (String c :s.split(" ")[0].split("")){
            System.out.println(c);
            switch (c) {
                case "A" -> {
                    cards[i] = 14;
                    this.singleCardCount.put(14,this.singleCardCount.getOrDefault(14,0) + 1);
                }
                case "K" -> {
                    cards[i] = 13;
                    this.singleCardCount.put(13,this.singleCardCount.getOrDefault(13,0) + 1);

                }
                case "Q" -> {
                    cards[i] = 12;
                    this.singleCardCount.put(12,this.singleCardCount.getOrDefault(12,0) + 1);

                }
                case "J" -> {
                    cards[i] = 11;
                    this.singleCardCount.put(11,this.singleCardCount.getOrDefault(11,0) + 1);

                }
                case "T" -> {
                    cards[i] = 10;
                    this.singleCardCount.put(10,this.singleCardCount.getOrDefault(10,0) + 1);

                }
                case "9" -> {
                    cards[i] = 9;
                    this.singleCardCount.put(9,this.singleCardCount.getOrDefault(9,0) + 1);

                }
                case "8" -> {
                    cards[i] = 8;
                    this.singleCardCount.put(8,this.singleCardCount.getOrDefault(8,0) + 1);

                }
                case "7" -> {
                    cards[i] = 7;
                    this.singleCardCount.put(7,this.singleCardCount.getOrDefault(7,0) + 1);

                }
                case "6" -> {
                    cards[i] = 6;
                    this.singleCardCount.put(6,this.singleCardCount.getOrDefault(6,0) + 1);

                }
                case "5" -> {
                    cards[i] = 5;
                    this.singleCardCount.put(5,this.singleCardCount.getOrDefault(5,0) + 1);

                }
                case "4" -> {
                    cards[i] = 4;
                    this.singleCardCount.put(4,this.singleCardCount.getOrDefault(4,0) + 1);

                }
                case "3" -> {
                    cards[i] = 3;
                    this.singleCardCount.put(3,this.singleCardCount.getOrDefault(3,0) + 1);

                }
                case "2" -> {
                    cards[i] = 2;
                    this.singleCardCount.put(2,this.singleCardCount.getOrDefault(2,0) + 1);

                }
            }
            i++;
        }
        findType(s.split(" ")[0]);
    }


    private void findType(String s) {
        for (Map.Entry<Integer, Integer> entry : singleCardCount.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        int size = this.singleCardCount.size();
        System.out.println("Size = "+size);
        if(size == 1){
            this.type = FIVE_OF_A_KIND;
        }
        if(size == 5){
            this.type = HIGH_CARD;
        }
        if(size == 4){
            this.type = ONE_PAIR;
        }
        if(size == 3){
            if(this.singleCardCount.containsValue(3)){
                this.type = THREE_OF_A_KIND;
            }else {
                this.type = TWO_PAIR;
            }

        }
        if(size == 2){
            if(this.singleCardCount.containsValue(4)){
                this.type = FOUR_OF_A_KIND;
            }else{
                this.type = FULL_HOUSE;
            }
        }
    }


    @Override
    public int compareTo(Hand o) {
        if(o.type !=  this.type){
            return Integer.compare(this.type,o.type);
        }
        for(int i=0;i<this.cards.length;i++){
            if(o.cards[i] != this.cards[i]){
                return Integer.compare(this.cards[i],o.cards[i]);
            }
        }
        return 0;
    }

}
