package vertex;

import edge.Edge;
import factory.edge.EdgeFactory;
import factory.vertex.VertexFactory;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Vertex Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>May 6, 2018</pre>
 */
public class VertexTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: fillVertexInfo(String[] args)
     */
    @Test
    public void testFillVertexInfo() throws Exception {
        Vertex v1 = VertexFactory.createVertex("v1", "Word", null);
        Vertex v2 = VertexFactory.createVertex("v2", "Word", null);
        List<Vertex> vertices = new ArrayList<>();
        vertices.addAll(Arrays.asList(v1, v2));
        Edge edge = EdgeFactory.createEdge("edge1", "WordNeighborhood", vertices, 0.1);
        assert v1 != null;
        v1.addOutEdge(edge);
        assertEquals(v1.getOutEdges().stream().findFirst().orElse(null), edge);
        assert v2 != null;
        v2.addInEdge(edge);
        assertEquals(v2.getInEdges().stream().findFirst().orElse(null), edge);
    }

    /**
     * Method: addInEdge(Edge inEdge)
     */
    @Test
    public void testAddInEdge() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addOutEdge(Edge outEdge)
     */
    @Test
    public void testAddOutEdge() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: removeEdge(Edge edge)
     */
    @Test
    public void testRemoveEdge() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getInEdges()
     */
    @Test
    public void testGetInEdges() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getOutEdges()
     */
    @Test
    public void testGetOutEdges() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getLabel()
     */
    @Test
    public void testGetLabel() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: setLabel(String newLabel)
     */
    @Test
    public void testSetLabel() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: equals(Object obj)
     */
    @Test
    public void testEquals() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: hashCode()
     */
    @Test
    public void testHashCode() throws Exception {
//TODO: Test goes here... 
    }


} 
