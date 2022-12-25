package entities;

public enum Gender {
    female,male;

    public int getValue(Gender value) {
        switch (value) {
            case female: return 0;
            case male: return 1;
        }
        return 0;
    }
}
