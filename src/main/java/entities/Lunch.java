package entities;

public enum Lunch {
    freereduced,standard;

    public int getValue(Lunch value) {
        switch (value) {
            case freereduced: return 0;
            case standard: return 1;
        }
        return 0;
    }
}
