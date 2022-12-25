package entities;

public enum TestPreparationCourse {
    none,completed;

    public int getValue(TestPreparationCourse value) {
        switch (value) {
            case none: return 0;
            case completed: return 1;
        }
        return 0;
    }
}
