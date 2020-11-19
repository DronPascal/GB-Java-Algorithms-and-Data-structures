package hw1;

//суть начинается со строчки Integer I = 5;
class Person {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] arguments) {
        Person person = new Person();
        person.setName("Bob");

        int i = 5;
        setPersonName(person, i);
        System.out.println(person.getName() + " " + i);

        Integer I = 5;
        setPersonName(person, I);
        System.out.println(person.getName() + " " + I);
    }

    private static void setPersonName(Person person, int num) {
        person.setName("Linda");
        num = 99;
    }

    private static void setPersonName(Person person, Integer num) {
        person.setName("Linda");
        num = 99;
    }
}

