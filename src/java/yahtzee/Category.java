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
            return -1;
        }
    },
    TWO_PAIRS {
        public int calculateScore(int... dice) {
            return -1;
        }
    },
    THREE_OF_A_KIND {
        public int calculateScore(int... dice) {
            return -1;
        }
    },
    FOUR_OF_A_KIND {
        public int calculateScore(int... dice) {
            return -1;
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

}
