package module.three.lld.patterns.creational;

class PersonalDetails {
    private final String name;
    private final String address;
    private final int age;

    private PersonalDetails(PersonalDetailsBuilder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.age = builder.age;
    }

    public static class PersonalDetailsBuilder {
        private String name;
        private String address;
        private int age;

        public PersonalDetailsBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonalDetailsBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public PersonalDetailsBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public PersonalDetails build() {
            return new PersonalDetails(this);
        }
    }

    public String toString() {
        return "{ name: " + this.name + ", address: " + this.address + ", age: " + this.age + "}";
    }
}

/**
 * Constructs complex objects step by step, allowing different representations using same construction process.
 */
public class _5Builder {

    public static void main(String[] args) {
        PersonalDetails personalDetails = new PersonalDetails.PersonalDetailsBuilder().setName("Amit").setAddress("Mumbai").setAge(29).build();
        System.out.println("Personal details: " + personalDetails.toString());
    }

}
