/**
 * Date: 2019/4/7
 * Created by LiuJian
 *
 * @author LiuJian
 */

/**
 * 普利姆最小生成树
 */
class Prim {

    void prim(char[] vexs, int[][] matrix,int start){


        //vexs是点集合， matrix是邻接矩阵
        int num = vexs.length;
        int index = 0;
        //用于存放目标点
        char[] prims = new char[num];
        //用于存放当前点到周围点的权值
        int[] weight = new int[num];

        prims[index++] = vexs[start];

        //初始化weight
        for (int i = 0; i < num; i++) {
            weight[i] = matrix[start][i];
        }

        //标志start已经放进了目标集合
        weight[start] = 0;

        //计算最小路径和
        int sum = 0;
        //查找所有点相邻最小权重的点
        for (int i = 0; i < num; i++) {

            if (start == i){
                continue;
            }

            int j = 0;
            int target = 0;
            int min = Integer.MAX_VALUE;

            //查找权值最小的点
            while (j < num){
                if (weight[j] != 0 && weight[j] < min){
                    min = weight[j];
                    target = j;
                }
                j++;
            }
            sum += weight[target];
            //将目标点放入目标集合
            prims[index++] = vexs[target];

            //标记这个点已经放入了目标集合
            weight[target] = 0;

            //从当前target出发，更新其他点的权值
            for (int k = 0; k < num; k++) {
                if (weight[k] != 0 && weight[k] > matrix[target][k]){
                    weight[k] = matrix[target][k];
                }
            }


        }
    }

}
