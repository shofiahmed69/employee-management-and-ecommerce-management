public class Employe {
    private String EmployeID;
    private String Name;
    private String Department;
    private double salary;
    private String email;
    public Employe(String employeID, String Name, String Department, double salary, String email){
      
        this.EmployeID = employeID;
        this.Name = Name;
        this.Department = Department;
        this.email = email;
        SetSalary(salary);
    }
    public String getEmployeID(){
        return EmployeID;
    }
    public void setEmployeID(String EmployeID){
        this.EmployeID = EmployeID;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getDepartment(){
        return Department;
    }
    public void setDepartment(String Department){
        this.Department = Department;
    }
    public String getemail(){
        return email;
    }
    public void setemail(String email){
        this.email = email;
    }
    public double getsalay(){
        return salary;
    }
    public void SetSalary(double salary){
        if(salary > 0)
            this.salary = salary;
        else 
        throw new IllegalArgumentException("salary must be positive");
    }
    @Override
    public String toString(){
        return EmployeID + "," + Name + "," + Department + "," + salary + "," + email;
    }
    public static Employe fromString(String line){
        String[] parts = line.split(",");
        return new Employe(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), parts[4]);
    }
}