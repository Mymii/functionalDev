package streams.model;

public class Department {
    String employeeId;


    public Department() {
    }

    public Department(String employeeId) {
        this.employeeId = employeeId;

    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    @Override
    public String toString() {
        return "Department{" +
                "employeeId='" + employeeId + '\'' +
                '}';
    }
}
