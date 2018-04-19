package vertex;

public class Actor extends Vertex {
    private int age; // 演员的年龄
    private String gender;

    Actor(String label) {
        super(label);
    }

    @Override
    public void fillVertexInfo(String[] args) {
        if (args.length == 2) {
            age = Integer.parseInt(args[0]);
            gender = args[1];
        } else {
            throw new RuntimeException("the hyper edge must have one more vertex");
        }
    }
}
