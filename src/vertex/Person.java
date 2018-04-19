package vertex;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.Arrays;

public class Person extends Vertex {
    private String gender;
    private int age;

    public Person(String label) {
        super(label);
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void fillVertexInfo(String[] args) throws NumberFormatException {
        if (args.length == 2) {
            gender = args[0];
            age = Integer.parseInt(args[1]);
        } else {
            throw new RuntimeException("the Person must have both gender and age,but miss at least one");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Person && ((Person) obj).getLabel().equals(this.getLabel()) && ((Person) obj).getGender().equals(this.getGender()) && ((Person) obj).getAge() == this.age;
    }

    @Override
    public int hashCode() {
        Object[] objects = new Object[3];
        objects[0] = this.getLabel();
        objects[1] = this.getAge();
        objects[2] = this.getGender();
        return Arrays.hashCode(objects);
    }
}
