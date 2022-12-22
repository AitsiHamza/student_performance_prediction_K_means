package kmeans;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import entities.Student;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvToList {
    public List<Student> getAllStudents()
    {

        // Hashmap to map CSV data to
        // Bean attributes.
        Map<String, String> mapping = new
                HashMap<String, String>();
  /*      mapping.put("gen_ 'der", "Gender");
        mapping.put("race", "Race");
        mapping.put("parentallevelofeducation", "ParentalLevelOfEducation");
        mapping.put("lunch", "Lunch");
        mapping.put("testpreparationcourse", "TestPreparationCourse");
        mapping.put("mathscore", "MathScore");
        mapping.put("readingscore", "ReadingScore");
        mapping.put("writingscore", "WritingScore");
*/
        mapping.put("gender", "gender");
        mapping.put("race", "race");
        mapping.put("parentallevelofeducation", "parentalLevelOfEducation");
        mapping.put("lunch", "lunch");
        mapping.put("testpreparationcourse", "testPreparationCourse");
        mapping.put("mathscore", "mathScore");
        mapping.put("readingscore", "readingScore");
        mapping.put("writingscore", "writingScore");

        // HeaderColumnNameTranslateMappingStrategy
        // for Student class
        HeaderColumnNameTranslateMappingStrategy<Student> strategy =
                new HeaderColumnNameTranslateMappingStrategy<Student>();
        strategy.setType(Student.class);
        strategy.setColumnMapping(mapping);

        // Create castobaen and csvreader object
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader
                    ("C:\\Users\\LenOvO\\Desktop\\project\\tester\\src\\main\\resources\\data\\StudentsPerformance.csv"),',');
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());;
        }
        CsvToBean csvToBean = new CsvToBean();

        // call the parse method of CsvToList
        // pass strategy, csvReader to parse method
        List<Student> list = csvToBean.parse(strategy, csvReader);

        // print details of Bean object
        /*for (Student e : list) {
            System.out.println(e);
        }*/
        return list;
    }
}
