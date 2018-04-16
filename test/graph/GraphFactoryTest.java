package graph;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * GraphFactory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ËÄÔÂ 16, 2018</pre>
 */
public class GraphFactoryTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: createGraph(String filePath)
     */
    @Test
    public void testCreateGraph() throws Exception {
        // GraphPoet.txt is a data file which contain graph information
        assertEquals(GraphPoetFactory.createGraph("./test/graph/data/GraphPoet.txt"), GraphFactory.createGraph("./test/graph/data/GraphPoet.txt"));
        assertEquals(GraphSocialFactory.createGraph("./test/graph/data/GraphSocial.txt"), GraphFactory.createGraph("./test/graph/data/GraphSocial.txt"));
        assertEquals(GraphTopologyFactory.createGraph("./test/graph/data/GraphTopology.txt"), GraphFactory.createGraph("./test/graph/data/GraphTopology.txt"));
        assertEquals(GraphMovieFactory.createGraph("./test/graph/data/GraphMovie.txt"), GraphFactory.createGraph("./test/graph/data/GraphMovie.txt"));
    }

    @Test
    public void testGetVertices() throws Exception {
        // GraphPoet.txt is a data file which contain graph information
//        GraphFactory.getVertices("./test/graph/data/GraphPoet.txt");
//        GraphFactory.getVertices("./test/graph/data/GraphSocial.txt");
        GraphFactory.getVertices("./test/graph/data/GraphTopology.txt");
        GraphFactory.getVertices("./test/graph/data/GraphMovie.txt");
    }

} 
