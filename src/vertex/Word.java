package vertex;

public class Word extends Vertex {

    public Word(String label) {
        super(label);
    }

    @Override
    public void fillVertexInfo(String[] args) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Word && ((Word) obj).getLabel().equals(this.getLabel());
    }
}
