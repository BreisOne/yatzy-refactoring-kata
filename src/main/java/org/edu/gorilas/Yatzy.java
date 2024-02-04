package org.edu.gorilas;
public class Yatzy {

    public static int chance(int... dice)
    {
        int total = 0;
        for (int die:dice){
            total += die;
        }
        return total;
    }

    public static int yatzy(int... dice)
    {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public static int ones(int... dice) {
        int sum = 0;
        for (int die:dice){
            if(die==1){
              sum+=die;
            }
        }
        return sum;
    }

    public static int twos(int... dice) {
        int sum = 0;
        for (int die:dice){
            if (die==2){
                sum+=die;
            }
        }
        return sum;
    }

    public static int threes(int...dice) {
        int sum = 0;
        for (int die:dice){
            sum+= die==3? 3 : 0;
        }
        return sum;
    }

    protected int[] dice;
    public Yatzy(int... dice)
    {
        this.dice = new int[5];

        for (int die = 0; die < dice.length; die++) {
            this.dice[die] = dice[die];
        }
    }

    public int fours()
    {
        int sum = 0;
        for (int die:dice) {
            sum += die == 4? 4: 0;
        }
        return sum;
    }

    public int fives()
    {
        int sum = 0;
        for (int die:dice) {
            sum += die == 5? 5: 0;
        }
        return sum;
    }

    public int sixes()
    {
        int sum = 0;
        for (int die:dice)
            sum += die == 6 ? 6 : 0;

        return sum;
    }

    public static int score_pair(int... dice)
    {
        int[] counts = new int[6];
        for(int die: dice){
            counts[die-1]++;
        }
        for (int i = 5; i >=0; i--)
            if (counts[i] >= 2)
                return (i+1)*2;
        return 0;
    }

    public static int two_pair(int... dice)
    {
        int[] counts = new int[6];
        for(int die:dice){
            counts[die-1]++;
        }
        int contTwos = 0;
        int score = 0;
        for (int i = 5; i >= 0; i--)
            if (counts[5-i] >= 2) {
                score += (6-i)*2;
                contTwos++;
            }
        return contTwos==2 ? score : 0;
    }

    public static int four_of_a_kind(int... dice)
    {
        int [] counts = new int[6];

        for(int die:dice){
            counts[die-1]++;
        }
        for (int i = 0; i < 6; i++)
            if (counts[i] >= 4)
                return (i+1) * 4;

        return 0;
    }

    public static int three_of_a_kind(int... dice)
    {
        int[] counts = new int[6];
        for(int die: dice){
            counts[die-1]++;
        }
        for (int i = 0; i < 6; i++)
            if (counts[i] >= 3)
                return (i+1) * 3;

        return 0;
    }

    public static int smallStraight(int... dice)
    {
        int[] counts = new int[6];
        int scores = 0;
        for(int die:dice){
            counts[die-1]++;
        }
        for (int i = 0; i < 5; i++){
            scores += counts[i] == 1? 1: 0;
        }
        return scores == 5 ? 15 : 0;
    }

    public static int largeStraight(int... dice)
    {
        int[] counts = new int[6];
        int scores = 0;
        for(int die:dice){
            counts[die-1]++;
        }
        for (int i = 1; i < 6; i++) {
            scores += counts[i] == 1 ? 1 : 0;
        }
        return scores == 5 ? 20 : 0;
    }

    public static int fullHouse(int... dice)
    {
        int[] counts = new int[6];
        boolean isPair = false;
        int sumTwos = 0;
        boolean isTrio = false;
        int sumThrees = 0;

        for(int die:dice){
            counts[die-1]++;
        }
        for (int i = 0; i < 6; i ++)
            if (counts[i] == 2) {
                isPair = true;
                sumTwos = (i+1)*2;
            }
        for (int i = 0; i < 6; i ++)
            if (counts[i] == 3) {
                isTrio = true;
                sumThrees = (i+1)*3;
            }
        return isPair && isTrio ? sumTwos + sumThrees: 0;
    }
}



