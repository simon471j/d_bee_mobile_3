public class Person implements Comparable<Person> {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public int compareTo(Person o) {
        if (this.age != o.age)
            return this.age > o.age ? -1 : 1;
        return 0;
    }

    @Override
    public String toString() {
        return name + "," + age;
    }
}
