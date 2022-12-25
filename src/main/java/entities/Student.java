package entities;

public class Student {
//    private int id;
    private Gender gender;
    private Race race;
    private ParentalLevelOfEducation parentalLevelOfEducation;
    private Lunch lunch;
    private TestPreparationCourse testPreparationCourse;
    private int mathScore,readingScore,writingScore;

    @Override
    public String toString() {
        return "Student{" +
                "gender=" + gender.getValue(gender) +
                ", race=" + race.getValue(race) +
                ", parentalLevelOfEducation=" + parentalLevelOfEducation.getValue(parentalLevelOfEducation) +
                ", lunch=" + lunch.getValue(lunch) +
                ", testPreparationCourse=" + testPreparationCourse.getValue(testPreparationCourse) +
                ", mathScore=" + mathScore +
                ", readingScore=" + readingScore +
                ", writingScore=" + writingScore +
                '}';
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public ParentalLevelOfEducation getParentalLevelOfEducation() {
        return parentalLevelOfEducation;
    }

    public void setParentalLevelOfEducation(ParentalLevelOfEducation parentalLevelOfEducation) {
        this.parentalLevelOfEducation = parentalLevelOfEducation;
    }

    public Lunch getLunch() {
        return lunch;
    }

    public void setLunch(Lunch lunch) {
        this.lunch = lunch;
    }

    public TestPreparationCourse getTestPreparationCourse() {
        return testPreparationCourse;
    }

    public void setTestPreparationCourse(TestPreparationCourse testPreparationCourse) {
        this.testPreparationCourse = testPreparationCourse;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getReadingScore() {
        return readingScore;
    }

    public void setReadingScore(int readingScore) {
        this.readingScore = readingScore;
    }

    public int getWritingScore() {
        return writingScore;
    }

    public void setWritingScore(int writingScore) {
        this.writingScore = writingScore;
    }
/*   private static final long serialVersionUID = 1L;
    public String Gender,
            Race,
            ParentalLevelOfEducation,
            Lunch,
            TestPreparationCourse,
            MathScore,
            ReadingScore,
            WritingScore;

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getRace() {
        return Race;
    }

    public void setRace(String race) {
        Race = race;
    }

    public String getParentalLevelOfEducation() {
        return ParentalLevelOfEducation;
    }

    public void setParentalLevelOfEducation(String parentalLevelOfEducation) {
        ParentalLevelOfEducation = parentalLevelOfEducation;
    }

    public String getLunch() {
        return Lunch;
    }

    public void setLunch(String lunch) {
        Lunch = lunch;
    }

    public String getTestPreparationCourse() {
        return TestPreparationCourse;
    }

    public void setTestPreparationCourse(String testPreparationCourse) {
        TestPreparationCourse = testPreparationCourse;
    }

    public String getMathScore() {
        return MathScore;
    }

    public void setMathScore(String mathScore) {
        MathScore = mathScore;
    }

    public String getReadingScore() {
        return ReadingScore;
    }

    public void setReadingScore(String readingScore) {
        ReadingScore = readingScore;
    }

    public String getWritingScore() {
        return WritingScore;
    }

    public void setWritingScore(String writingScore) {
        WritingScore = writingScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Gender='" + Gender + '\'' +
                ", Race='" + Race + '\'' +
                ", ParentalLevelOfEducation='" + ParentalLevelOfEducation + '\'' +
                ", Lunch='" + Lunch + '\'' +
                ", TestPreparationCourse='" + TestPreparationCourse + '\'' +
                ", MathScore='" + MathScore + '\'' +
                ", ReadingScore='" + ReadingScore + '\'' +
                ", WritingScore='" + WritingScore + '\'' +
                '}';
    }*/
}
