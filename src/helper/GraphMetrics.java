package helper;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;

import java.util.ArrayList;
import java.util.List;

public class GraphMetrics {
    private final static Double INFINITE = 10000000.0;

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
        if (g.vertices().contains(v)) {
            if (v.getInEdges().size() != v.getOutEdges().size()) {
                throw new UnsupportedOperationException("Directed edge must define in or out degree centrality");
            }
            return v.getInEdges().size();
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
        if (g.vertices().contains(v)) {
            return v.getInEdges().size();
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
        if (g.vertices().contains(v)) {
            return v.getOutEdges().size();
        }
        return 0;
    }

    /**
     * 用于计算一个点到图中其他点的开销 因数 closenessCentrality
     *
     * @param g 图对象
     * @param v 点对象
     * @return closenessCentrality 的值
     */
    static double closenessCentrality(Graph g, Vertex v) {
        int index = 0; // 保存v在数组中的下标
        double centrality = 0;
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(v);
        vertices.addAll(g.vertices());
        double[][] e = floyd(vertices);
        for (int i = 1; i <= vertices.size(); i++) {
            if (vertices.get(i).equals(v)) {
                index = i;
                break;
            }
        }
        for (int i = 1; i < vertices.size(); i++) {
            if (i != index) {
                centrality += e[index][i] == INFINITE ? 0 : 1.0 / e[index][i];
            }
        }
        return centrality;
    }

    /**
     * 用floyd算法求最短路径
     *
     * @param vertices 图中已经排好序的所有顶点，排序是为了方便使用floyd算法求解
     * @return 一个二维矩阵，存储图中任意两点之间的最短路径
     */
    private static double[][] floyd(List<Vertex> vertices) {
        double[][] e = new double[vertices.size() + 1][vertices.size() + 1];
        // 初始化数组
        for (int i = 1; i <= vertices.size(); i++) {
            for (int j = 1; j <= vertices.size(); j++) {
                Vertex source = vertices.get(i);
                Vertex target = vertices.get(j);
                Edge edge = source.getOutEdges().stream().filter(item -> item.vertices().size() <= 2 && item.targetVertices().contains(target)).min((o1, o2) -> (int) (o1.getWeight() - o2.getWeight())).orElse(null);
                if (edge != null) {
                    e[i][j] = edge.getWeight() == -1 ? INFINITE : edge.getWeight(); // 两点之间边的权重
                } else {
                    e[i][j] = INFINITE; // 两个点之间没有直接的边连通的情况
                }
            }
        }
        // floyd核心算法
        for (int k = 1; k <= vertices.size(); k++) {
            for (int i = 1; i < vertices.size(); i++) {
                for (int j = 1; j < vertices.size(); j++) {
                    if (e[i][k] + e[k][j] < e[i][j]) {
                        e[i][j] = e[i][k] + e[k][j];
                    }
                }
            }
        }
        return e;
    }
}
