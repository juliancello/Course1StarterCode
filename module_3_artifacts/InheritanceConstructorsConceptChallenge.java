package demos;

public class InheritanceConstructorsConceptChallenge1 { // 1
    public class Person {
        private String name;

        public Person(String n) {
            this.name = n;
            System.out.print("#1 ");
        }
    }

    public class Student extends Person {
        public Student() {
            this("Student");
            System.out.print("$2 ");
        }

        public Student(String n) {
            super(n);
            System.out.print("#3 ");
        }
    }

    public class Main {
        public static void main(String... args) {
            Student s = new Student();
        }
    }
} // prints 1, 3, 2

public class InheritanceConstructorsConceptChallenge2 { // 2
    public class Person {
        private String name;
        public Person( String n ) {
            super();
            this.name = n;
        }
        public void setName( String n ) {
            this.name = n;
        }
    }

    public class Student extends Person {
        public Student () {
            this.setName("Student");
        }
    }

    public class Main {
        public static void main(String... args) {
            Student s = new Student();
        }
    }
} // Causes compile time error:
// It is because the Person class has no default (no-argument) constructor.
// Since the Student constructor doesn't explicitly call super with an argument, Java will attempt to call the Person's
// non-existent no-argument constructor automatically.