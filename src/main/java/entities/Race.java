package entities;

public enum Race {
    groupA,groupB,groupC,groupD,groupE;

    public int getValue(Race value) {
        switch (value) {
            case groupA: return 0;
            case groupB: return 1;
            case groupC: return 2;
            case groupD: return 3;
            case groupE: return 4;
        }
        return 0;
    }
}
