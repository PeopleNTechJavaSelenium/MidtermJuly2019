package codelab.status;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvReader {

    public static void main(String[] args) {
        /*
         Coma Separated Value(CSV) of your CodeLab status is downloaded and it parsed.
         Based on number of solution you solved, message is generated for you.
         You need to find the average score of the class.
         */

        String csvFilePath = System.getProperty("user.dir") + "/src/codelab/status/roster-file-09-07-2019.csv";
        String line = "";
        String cvsSplitBy = ",";
        BufferedReader br = null;
        List<Trainee> roster = new ArrayList<Trainee>();

        try {
            br = new BufferedReader(new FileReader(csvFilePath));
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                if(lineNumber == 0) {
                    lineNumber++;
                    continue;
                }
                String[] name = line.split(cvsSplitBy);
                roster.add(new Trainee(name[5].replace("\"", ""), name[4].replace("\"",
                        ""), Integer.parseInt(name[10])));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(roster);
        for(Trainee student:roster) {
            if (student.getNumberOfExercisesSolved()>=600) {
                System.out.print("You did pretty good-->                    ");
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getNumberOfExercisesSolved());
            } else if (student.getNumberOfExercisesSolved()>=500 && student.getNumberOfExercisesSolved()<600) {
                System.out.print("You could do little better-->             ");
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getNumberOfExercisesSolved());
            }else if (student.getNumberOfExercisesSolved()>=400 && student.getNumberOfExercisesSolved()<500) {
                System.out.print("You could do better-->                    ");
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getNumberOfExercisesSolved());
            }else if (student.getNumberOfExercisesSolved()>=300&& student.getNumberOfExercisesSolved()<400) {
                System.out.print("You should have done more-->              ");
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getNumberOfExercisesSolved());
            }else if (student.getNumberOfExercisesSolved()>=200&&student.getNumberOfExercisesSolved()<300) {
                System.out.print("You haven't done enough-->                 ");
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getNumberOfExercisesSolved());
            }else if (student.getNumberOfExercisesSolved()>=100&&student.getNumberOfExercisesSolved()<200) {
                System.out.print("You did not take this course seriously-->   ");
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getNumberOfExercisesSolved());
            }else if (student.getNumberOfExercisesSolved()<100) {
                System.out.print("Shame on You !-->                           ");
                System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getNumberOfExercisesSolved());
            }
        }

    }

}
