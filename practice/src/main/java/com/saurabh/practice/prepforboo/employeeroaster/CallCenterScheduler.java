package com.saurabh.practice.prepforboo.employeeroaster;

import java.time.DayOfWeek;
import java.util.*;
import java.util.stream.Collectors;

public class CallCenterScheduler {

        enum Language {ENGLISH, DUTCH, SPANISH};

        record Employee(String name, Set<Language> languages){};

        private static Map<Language, Integer> required = Map.of(
                Language.ENGLISH, 3,
                Language.DUTCH, 2,
                Language.SPANISH, 1
        );

        private static final int MAX_DAYS_FOR_WORK = 5;

        private static Map<DayOfWeek, Map<Language, List<Employee>>> prepareSchedule(List<Employee> employees){
            Map<Employee, Set<DayOfWeek>> availability = new HashMap<>();
            for (Employee employee :employees) {
                availability.put(employee, new HashSet<>());
            }

            Map<DayOfWeek, Map<Language, List<Employee>>> assigned = new EnumMap<>(DayOfWeek.class);
            for (DayOfWeek day : DayOfWeek.values()){
                assigned.put(day, new EnumMap<>(Language.class));
            }

            List<Language> languagesByScarcity = Arrays.stream(Language.values())
                    .sorted(Comparator.comparingLong(lang ->
                            employees.stream().filter(e -> e.languages().contains(lang)).count()
                    )).collect(Collectors.toList());


            for (Language language: languagesByScarcity) {
                    int langRequirement = required.get(language);

                    for (DayOfWeek day : DayOfWeek.values()){

                        List<Employee> eligible = employees.stream()
                                .filter(e->e.languages().contains(language))
                                .filter(e-> !availability.get(e).contains(day))
                                .filter(e-> availability.get(e).size()<MAX_DAYS_FOR_WORK)
                                .sorted(Comparator.comparingInt(e-> availability.get(e).size()))
                                .collect(Collectors.toList());

                        if(eligible.size()<langRequirement){

                        }
                        List<Employee> chosen = eligible.subList(0, langRequirement);

                        for (Employee employee: chosen) {
                            availability.get(employee).add(day);
                        }
                        assigned.get(day).put(language, new ArrayList<>(chosen));
                    }
            }
            return assigned;
        }



        public static void main (String[]args){
            List<Employee> employees = List.of(
                    new Employee("Alice", Set.of(Language.ENGLISH, Language.DUTCH)),
                    new Employee("Bob", Set.of(Language.ENGLISH)),
                    new Employee("Carlos", Set.of(Language.SPANISH, Language.ENGLISH)),
                    new Employee("Diana", Set.of(Language.DUTCH, Language.SPANISH)),
                    new Employee("Erik", Set.of(Language.ENGLISH, Language.DUTCH)),
                    new Employee("Fatima", Set.of(Language.ENGLISH)),
                    new Employee("Gustav", Set.of(Language.SPANISH)),
                    new Employee("Hana", Set.of(Language.ENGLISH, Language.SPANISH)),
                    new Employee("Ivan", Set.of(Language.DUTCH)),
                    new Employee("Julia", Set.of(Language.ENGLISH, Language.DUTCH, Language.SPANISH))
            );

            Map<DayOfWeek, Map<Language, List<Employee>>> schedule = prepareSchedule(employees);

            for (DayOfWeek day : DayOfWeek.values()) {
                System.out.println("=== " + day + " ===");
                for (Language lang : Language.values()) {
                    List<String> names = schedule.get(day).get(lang).stream()
                            .map(Employee::name)
                            .collect(Collectors.toList());
                    System.out.println("  " + lang + ": " + names);
                }
            }

        }



    }