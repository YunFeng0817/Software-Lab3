package helper;

import graph.Graph;
import vertex.Vertex;

public class GraphMetrics {
    /**
     * 获得一个无向图中点的 点度中心性
     * 如果图中没有这个点,将会返回0
     * 如果传入的图是有向图，且点的入度和出度不相同 ，会throw UnsupportedOperationException
     *
     * @param g 传入所求点所在的图
     * @param v 需要求度的点
     * @return 所求点的度，如果传入的图中没有这个点，就会返回0
     */
    static double degreeCentrality(Graph g, Vertex v) {
        Vertex vertex = g.vertices().stream().filter(item -> item.equals(v)).findFirst().orElse(null);
        if (vertex != null) {
            if (vertex.getInEdges().size() != vertex.getOutEdges().size()) {
                throw new UnsupportedOperationException("Directed edge must define in or out degree centrality");
            }
            return vertex.getInEdges().size();
        }
        return 0;
    }

    /**
     * 获得一个有向图中点的 点入度中心性
     * 如果图中没有这个点,将会返回0
     *
     * @param g 传入所求点所在的图
     * @param v 需要求度的点
     * @return 所求点的入度值，如果传入的图中没有这个点，就会返回0
     */
    static double inDegreeCentrality(Graph g, Vertex v) {
        Vertex vertex = g.vertices().stream().filter(item -> item.equals(v)).findFirst().orElse(null);
        if (vertex != null) {
            return vertex.getInEdges().size();
        }
        return 0;
    }

    /**
     * 获得一个无向图中点的 点出度中心性
     * 如果图中没有这个点,将会返回0
     *
     * @param g 传入所求点所在的图
     * @param v 需要求度的点
     * @return 所求点的出度值，如果传入的图中没有这个点，就会返回0
     */
    static double outDegreeCentrality(Graph g, Vertex v) {
        Vertex vertex = g.vertices().stream().filter(item -> item.equals(v)).findFirst().orElse(null);
        if (vertex != null) {
            return vertex.getOutEdges().size();
        }
        return 0;
    }
}
