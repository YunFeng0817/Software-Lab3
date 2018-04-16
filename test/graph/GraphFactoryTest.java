package graph;

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
        GraphFactory.createGraph("./test/graph/GraphPoet.txt");
    }


} 
