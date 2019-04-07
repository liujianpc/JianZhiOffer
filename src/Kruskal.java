/**
 * Date: 2019/4/7
 * Created by LiuJian
 *
 * @author LiuJian
 */

/**
 * 克鲁斯卡尔最小生成树算法
 * 1、所有边按权值排序
 * 2、选最小的边，且边的终点不再已经生成的树，则将边放入最小生成树
 */
class Kruskal {

    void kruskal(int edgeNum, char[] vexs, int[][] matrix) {
        int index = 0;
        int[] vends = new int[edgeNum];

        Edge[] rets = new Edge[edgeNum];
        //获取所有的边且排序
        Edge[] edges = sort(getEdges());

        for (int i = 0; i < edgeNum; i++) {
            //拿到边的起点和终点的序号
            int p = getPosition(edges[i].start);
            int q = getPosition(edges[i].end);
            //获取这个两个点的终点是否一致，不一致则将边加入目标生成树
            int m = getEnd(vends,p);
            int n = getEnd(vends,q);
            if (m != n){
                vends[m] = n;
                rets[index++] = edges[i];
            }
        }

    }

    static class Edge {
        char start;
        char end;
        int weight;
    }
}
