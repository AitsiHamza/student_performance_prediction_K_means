package entities;

public enum ParentalLevelOfEducation {
    somecollege,
    highschool,
    bachelorsdegree,
    associatedegree,
    someschool,
    somehighschool,
    associatesdegree,
    mastersdegree;

    public int getValue(ParentalLevelOfEducation value) {
        switch (value) {
            case somecollege: return 0;
            case highschool: return 1;
            case bachelorsdegree: return 2;
            case associatedegree: return 3;
            case someschool: return 4;
            case somehighschool: return 5;
            case associatesdegree: return 6;
            case mastersdegree: return 7;
        }
        return 0;
    }

}
