package io.jagdesh.learn.d_streams.zz_streams_examples;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class example {

    static List<Employee> employees =new ArrayList<>();
    static {
        employees.add(
                new Employee("Jagdesh", "Umapathy", 1250000.0, Arrays.asList("Project 1", "Project 2"))
        );
        employees.add(
                new Employee("Ujjwal", "Kulkarni", 1220000.0, Arrays.asList("Project 2", "Project 3"))
        );
        employees.add(
                new Employee("Ananya", "Pandey", 1230000.0, Arrays.asList("Project 3", "Project 4"))
        );
    }

    public static void main(String[] args) {
        System.out.println();

        //  forEach()
        employees.stream()
                .forEach(employee -> System.out.println(employee));
        System.out.println();

        //	map()
        //	collect()
        List<Employee> empList = employees.stream()
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                ))
                .collect(Collectors.toList());
        System.out.println(empList);
        System.out.println();

        //	filter()
        List<Employee> filterEmp = employees.stream()
                .filter(employee -> employee.getLastName().contains("a") && employee.getLastName().contains("y"))
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                ))
                .collect(Collectors.toList());
        System.out.println(filterEmp);
        System.out.println();

        //	findFirst()
        Employee firstEmp = employees.stream()
                .filter(employee -> employee.getLastName().contains("a") && employee.getLastName().contains("y"))
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                ))
                .findFirst()
                .orElse(null);

        System.out.println(firstEmp);
        System.out.println();

        //	flatMap()
        Set<String> allUniqueProjects = employees.stream()
                .map(employee -> employee.getProjects())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.toSet());
        System.out.println(allUniqueProjects);
        System.out.println();

        //	Short Circuit Operations
        List<Employee> shortCircuit = employees.stream()
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(shortCircuit);
        System.out.println();

        //	Finite Date
        Stream.generate(Math::random)
                .limit(5)
                .forEach(value -> System.out.println(value));
        System.out.println();

        //	Sorting
        List<Employee> sortedEmps = employees.stream()
                .sorted((o1, o2) -> o1.getFirstName()
                        .compareToIgnoreCase(o2.getFirstName()))
                .collect(Collectors.toList());
        System.out.println(sortedEmps);
        System.out.println();

        //  min() | max()
        Employee empDbl = employees.stream()
                //.max(Comparator.comparing(Employee::getSalary))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new NoSuchElementException("There is no Such element"));
        System.out.println(empDbl);
        System.out.println();

        //  reduce()
        Double totalSal = employees.stream()
                .map(employee -> employee.getSalary())
                .reduce(0.0, Double::sum);
        System.out.println(totalSal);
    }
}
