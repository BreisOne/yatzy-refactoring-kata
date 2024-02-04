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
        int [] tallies = new int[6];

        for(int die:dice){
            tallies[die-1]++;
        }
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;

        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] t;
        t = new int[6];
        t[d1-1]++;
        t[d2-1]++;
        t[d3-1]++;
        t[d4-1]++;
        t[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



