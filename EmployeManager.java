import java.io.*;
import java.util.*;
public class EmployeManager {
    private static final String File_Name = "employee.txt";
    public static void addEmploye(Employe employe) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(File_Name, true));
        writer.write(employe.toString());
        writer.newLine();
        writer.close();
    }
    public static List<Employe> getallEmploye() throws IOException{
        List<Employe> list = new ArrayList<>();
        File file = new File(File_Name);
        if (!file.exists()) return list;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(Employe.fromString(line));
        }
        reader.close();
        return list;
    }
    public static void updateEmploye(Employe updatedemploye) throws IOException {
        List<Employe> employees = getallEmploye();
        BufferedWriter writer = new BufferedWriter(new FileWriter(File_Name));
        for (Employe p : employees) {
            if (p.getEmployeID().equals(updatedemploye.getEmployeID())) {
                writer.write(updatedemploye.toString());
            } else {
                writer.write(p.toString());
            }
            writer.newLine();
        }
        writer.close();
    }

    public static void deleteemployee(String EmployeID) throws IOException {
        List<Employe> employees = getallEmploye();
        BufferedWriter writer = new BufferedWriter(new FileWriter(File_Name));
        for (Employe p : employees) {
            if (!p.getEmployeID().equals(EmployeID)) {
                writer.write(p.toString());
                writer.newLine();
            }
        }
        writer.close();
    }

}
