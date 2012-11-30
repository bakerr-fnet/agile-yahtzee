package yahtzee;

public enum Category {

    CHANCE {
        public int calculateScore(int... dice) {
            int score = 0;
            for (int die : dice) {
                score += die;
            }
            return score;
        }
    },
    YAHTZEE {
        public int calculateScore(int... dice) {
            return -1;
        }
    },

    ONES {
        public int calculateScore(int... dice) {
            int score = 0;
            for (int die : dice) {
                if (die == 1) score += die;
            }
            return score;
        }
    },

    TWOS {
        public int calculateScore(int... dice) {
            return -1;
        }
    },
    THREES {
        public int calculateScore(int... dice) {
            return -1;
        }
    },
    FOURS {
        public int calculateScore(int... dice) {
            return -1;
        }
    },
    FIVES {
        public int calculateScore(int... dice) {
            return -1;
        }
    },
    SIXES {
        public int calculateScore(int... dice) {
            return -1;
        }
    },
    PAIR {
        public int calculateScore(int... dice) {

            int[] res = getInstanceCount(dice);
            for(int i = 5; i >=0; i--)
            {
                if(res[i]>1)
                    return (i+1)*2;
            }

            return 0;
        }
    },
    TWO_PAIRS {
        public int calculateScore(int... dice) {
            int ret = 0;
            int pairCount = 0;

            int[] res = getInstanceCount(dice);
            for(int i = 5; i >=0 && pairCount<2; i--)
            {
                if(res[i]>1)
                {
                    pairCount++;
                    ret +=  (i+1)*2;
                    res[i]-=2;
                    i++;
                }
            }
            if(pairCount==2)
                return ret;
            return 0;
        }
    },
    THREE_OF_A_KIND{
        public int calculateScore(int... dice) {

            int[] res = getInstanceCount(dice);
            for(int i = 5; i >=0; i--)
            {
                if(res[i]>2)
                    return (i+1)*3;
            }

            return 0;
        }
    },
    FOUR_OF_A_KIND {
        public int calculateScore(int... dice) {

            int[] res = getInstanceCount(dice);
            for(int i = 5; i >=0; i--)
            {
                if(res[i]>3)
                    return (i+1)*4;
            }

            return 0;
        }
    },
    SMALL_STRAIGHT {
        public int calculateScore(int... dice) {
            return -1;
        }
    },
    LARGE_STRAIGHT {
        public int calculateScore(int... dice) {
            return -1;
        }
    },
    FULL_HOUSE {
        public int calculateScore(int... dice) {
            return -1;
        }
    };

    abstract public int calculateScore(int... dice);

    private static int[] getInstanceCount(int... dice){
        int[] instanceCount = new int[] {0,0,0,0,0,0};

        for(int c = 0; c < dice .length; c++)
        {
            instanceCount[dice[c]-1]++;
        }
        return instanceCount;
    }

}
