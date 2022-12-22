package kmeans;

import entities.Student;

import java.util.ArrayList;
import java.util.List;

public class Cluster {

    public List<Student> students;
    public Student centroid;
    public int id;

    //Creates a new test.Cluster
    public Cluster(int id) {
        this.id = id;
        this.students = new ArrayList<>();
        this.centroid = null;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void setPoints(List<Student> students) {
        this.students = students;
    }

    public Student getCentroid() {
        return centroid;
    }

    public void setCentroid(Student centroid) {
        this.centroid = centroid;
    }

    public int getId() {
        return id;
    }

    public void clear() {
        students.clear();
    }

    public String PerformanceEq(double perf){

        if(perf>=70)
            return "Excellent";
        else if(perf>=60)
            return "Very Good";
        else if(perf>=50)
            return "Good";
        else if(perf>=45)
            return "Very Fair";
        else if(perf>=40)
            return "Fair";
        else
            return "Poor";
    }

    public double Performance(){
        double overall_perf=0;
        double perf=0;
        for(Student s: students){
            perf=0;
            for(int start=0;start<s.getList().size();start++){
                perf=perf + s.getList().get(start);
            }
            overall_perf=overall_perf+(perf/s.getList().size());
        }
        return overall_perf/students.size();
    }

    public List<Student> plotCluster() {
        System.out.println("[test.Cluster: " + id+"]");
        System.out.println("[Centroid: " + centroid + "]");
        System.out.println("[Points: \n");
        for(Student s : students) {
            System.out.println(s);
        }
        System.out.println("]");
        System.out.println("Overall Performance of test.Cluster "+id+": "+(int)Performance()+"("+PerformanceEq(Performance())+")");
        return students;
    }

}

