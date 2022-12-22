package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Student {
//    private int id;
    private Gender gender;
    private Race race;
    private ParentalLevelOfEducation parentalLevelOfEducation;
    private Lunch lunch;
    private TestPreparationCourse testPreparationCourse;
    private int mathScore,readingScore,writingScore;

    private int cluster_number = 0;
    public static int size;


    public void setCluster(int n) {
        this.cluster_number = n;
    }

    public int getCluster() {
        return this.cluster_number;
    }

    //Calculates the distance between two points.
    public static double distance(Student s, Student centroid) {
        double dis = 0;

        for(int start=0;start<s.getList().size();start++){
            dis=dis+Math.pow(s.getList().get(start)-centroid.getList().get(start),2);
        }
        dis=Math.sqrt(dis);
        return dis;
    }

    public List<Integer> getList(){
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(gender.getValue(gender),
                race.getValue(race),
                parentalLevelOfEducation.getValue(parentalLevelOfEducation),
                lunch.getValue(lunch),
                testPreparationCourse.getValue(testPreparationCourse),
                mathScore,
                readingScore,
                writingScore));
        return list;
    }
    public Student() {
    }

    public Student(Gender gender, Race race, ParentalLevelOfEducation parentalLevelOfEducation, Lunch lunch, TestPreparationCourse testPreparationCourse, int mathScore, int readingScore, int writingScore) {
        this.gender = gender;
        this.race = race;
        this.parentalLevelOfEducation = parentalLevelOfEducation;
        this.lunch = lunch;
        this.testPreparationCourse = testPreparationCourse;
        this.mathScore = mathScore;
        this.readingScore = readingScore;
        this.writingScore = writingScore;
    }

    public Student randomStudent(){
        Student student = new Student();
        student.setGender(Math.random()>0.5?Gender.female:Gender.male);
        student.setRace(Math.random()>0.5?Race.groupA:Race.groupB);
        student.setParentalLevelOfEducation(Math.random()>0.5?ParentalLevelOfEducation.associatedegree:ParentalLevelOfEducation.mastersdegree);
        student.setTestPreparationCourse(Math.random()>0.5?TestPreparationCourse.completed:TestPreparationCourse.none);
        Random random = new Random();
        student.setMathScore(random.nextInt(100));
        student.setReadingScore(random.nextInt(100));
        student.setWritingScore(random.nextInt(100));
        student.setLunch(Math.random()>0.5?Lunch.freereduced:Lunch.standard);
        return student;
    }
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
