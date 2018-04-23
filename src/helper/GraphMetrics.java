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
        int index; // 保存v在数组中的下标
        double centrality = 0;
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(v);
        vertices.addAll(g.vertices());
        double[][] e = new double[vertices.size() + 1][vertices.size() + 1];
        int[][] path = new int[vertices.size() + 1][vertices.size() + 1];
        floyd(vertices, e, path);
        // 寻找指定的点在数组中的下标值
        index = getIndex(vertices, v);
        for (int i = 1; i < vertices.size(); i++) {
            if (i != index) {
                centrality += e[index][i] == INFINITE ? 0 : 1.0 / e[index][i];
            }
        }
        return centrality;
    }

    /**
     * 求某个点的 BetweennessCentrality 值，这个值表示这个点在图中促进其他节点进行通信的能力
     *
     * @param g 图对象
     * @param v 点对象
     * @return BetweennessCentrality 的值
     */
    public static double betweennessCentrality(Graph g, Vertex v) {
        int index; // 保存v在数组中的下标
        int shortPathNum = 0, shortPathThroughVNum = 0;
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(v);
        vertices.addAll(g.vertices());
        double[][] e = new double[vertices.size() + 1][vertices.size() + 1];
        int[][] path = new int[vertices.size() + 1][vertices.size() + 1];
        floyd(vertices, e, path);
        // 寻找指定的点在数组中的下标值
        index = getIndex(vertices, v);
        for (int i = 1; i < vertices.size(); i++) {
            for (int j = 1; j < vertices.size(); j++) {
                if (i != j && e[i][j] != INFINITE) {
                    List<Integer> router = new ArrayList<>();
                    getpath(i, j, path, router);
                    if (router.size() != 0)
                        shortPathNum++;
                    router.add(i);
                    if (router.contains(index))
                        shortPathThroughVNum++;
                }
            }
        }
        return (double) shortPathThroughVNum / (double) shortPathNum;
    }

    /**
     * @param start  起点的index值
     * @param end    终点的index值
     * @param path   保存的任意两点之间的最短路径
     * @param router 指定两点之间的最短路径
     */

    private static void getpath(int start, int end, int[][] path, List<Integer> router) {
        if (start == end)
            return;
        if (path[start][end] == 0) {
            router.add(end);
        } else {
            getpath(start, path[start][end], path, router);
            getpath(path[start][end], end, path, router);
        }
    }

    /**
     * 用floyd算法求最短路径
     *
     * @param vertices 图中已经排好序的所有顶点，排序是为了方便使用floyd算法求解
     * @param e        用来存储任意两个点之间的最短距离
     * @param path     用来存储任意两个点之间的最短路径
     */
    private static void floyd(List<Vertex> vertices, double[][] e, int[][] path) {
        // 初始化数组
        for (int i = 1; i < vertices.size(); i++) {
            for (int j = 1; j < vertices.size(); j++) {
                Vertex source = vertices.get(i);
                Vertex target = vertices.get(j);
                Edge edge = source.getOutEdges().stream().filter(item -> item.vertices().size() <= 2 && item.targetVertices().contains(target)).min((o1, o2) -> (int) (o1.getWeight() - o2.getWeight())).orElse(null);
                if (edge != null) {
                    e[i][j] = edge.getWeight() == -1 ? INFINITE : edge.getWeight(); // 两点之间边的权重
                } else {
                    e[i][j] = INFINITE; // 两个点之间没有直接的边连通的情况
                }
                path[i][j] = 0;
            }
        }
        // floyd核心算法
        for (int k = 1; k < vertices.size(); k++) {
            for (int i = 1; i < vertices.size(); i++) {
                for (int j = 1; j < vertices.size(); j++) {
                    if (e[i][k] + e[k][j] < e[i][j]) {
                        e[i][j] = e[i][k] + e[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
    }

    /**
     * 寻找指定的元素在一个列表中的下标值
     * 如果指定的元素不在该列表中，返回-1
     *
     * @param list 指定的列表
     * @param item 需要求下标的元素
     * @return 指定元素的下标值，如果列表中没有这个元素，返回-1
     */
    private static int getIndex(List<?> list, Object item) {
        for (int i = 1; i <= list.size(); i++) {
            if (list.get(i).equals(item))
                return i;
        }
        return -1;
    }
}
