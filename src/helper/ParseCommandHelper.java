package helper;

public class ParseCommandHelper {
    public static void main(String[] args) {
        switch (args[0]) {
            case "vertex":
                break;
            case "edge":
                break;
            case "hyperedge":
                break;
            default:
                throw new UnsupportedOperationException("usage");
        }
    }

    static class vertex {
        static void vertex(String[] args) {

        }

        static void add() {

        }

        static void delete() {

        }
    }

    static class edge {
        static void edge(String[] args) {

        }

        static void add() {

        }

        static void delete() {
        }
    }

    static class hyperedge {
        static void hyperedge(String[] args) {

        }

        static void add() {

        }
    }
}
