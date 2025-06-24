/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    private int importance = 0;

    public Solution() {
        this.importance = 0;
    }

    public int getImportance(List<Employee> employees, int id) {
        final var n = employees.size();
        final var employeeById = new HashMap<Integer, Employee>(n);

        for (var emp : employees)
            employeeById.put(emp.id, emp);

        dfs(id, employeeById);

        return importance;
    }

    private void dfs(int id, Map<Integer, Employee> employeeById) {
        final var emp = employeeById.get(id);
        importance += emp.importance;
        for (var _id : emp.subordinates)
            dfs(_id, employeeById);
    }
}
