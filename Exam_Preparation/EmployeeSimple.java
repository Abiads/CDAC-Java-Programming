import java.util.ArrayList;

class EmployeeSimple {
    int id;
    int salary;

    // Constructor
    public EmployeeSimple(int id, int salary) {
        this.id = id;
        this.salary = salary;
    }

    public static void main(String[] args) {
        ArrayList<EmployeeSimple> list = new ArrayList<>();

        // CREATE
        list.add(new EmployeeSimple(101, 50000));

        // READ
        for (EmployeeSimple e : list) {
            System.out.println(e.id + " " + e.salary);
        }

        // SEARCH
        for (EmployeeSimple e : list) {
            if (e.id == 101) {
                System.out.println("Found");
            }
        }

        // UPDATE
        for (EmployeeSimple e : list) {
            if (e.id == 101) {
                e.salary = 60000;
            }
        }

        // DELETE
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == 101) {
                list.remove(i);
                break;
            }
        }
    }
}
