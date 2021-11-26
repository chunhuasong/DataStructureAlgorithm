package GraphDemo;

/**
 * @author songhuan
 * @date 2021/11/23 9:17
 */
public class ShortestPath extends MGraph {
    public static void main(String[] args) {
        MGraph G = new MGraph();
        G.CreateMGraph(G);
        G.MAXVEX = 4;
//        //存储最短路径的下标
//        int[] PathPassPoint = new int[G.MAXVEX];
//        //存储到各点最短路径的权值和
//        int[] ShortPathTable = new int[G.MAXVEX];
//        int v0 = 0;
//        Dijkstra(G,v0,PathPassPoint,ShortPathTable);
          int[][] PathPassMatrix = new int[G.MAXVEX][G.MAXVEX];
          int[][] ShortPathMatrix = new int[G.MAXVEX][G.MAXVEX];
          Floyd(G,PathPassMatrix,ShortPathMatrix);

    }

    //Dijkstra算法求有向网G的v0顶点到其余顶点v最短路径
    // 经过的顶点PathPassPoint[],
    // v0到v最短路径长度和ShortPathTable[]
    //想求每个顶点的最短路径 可以循环遍历每个顶点都用一次Dijkstra
    static void Dijkstra(MGraph G,int v0,int[] PathPassPoint,int[] ShortPathTable){
        int v,w,k = 0,min;
        //end[w] = 1 表示求完了v0-->vw的最短路径
        int[] end = new int[G.MAXVEX];
        //初始化顶点数据
        for(v = 0;v < G.numVertexes;v++){
            end[v] = 0;//所有的顶点都没求最短路径
            ShortPathTable[v] = G.arc[v0][v];//把v0相连的顶点加上权值
            PathPassPoint[v] = 0;//下一个点还没找 先都设为0
        }
        ShortPathTable[v0] = 0;//v0--->v0路径为0
        end[v0] = 1;//v0--->v0 不需要求路径

        //功能正式开始 每次循环求v0到某个v顶点的最短路径
        for(v = 1;v < G.numVertexes;v++){
            //初始化目前的最小距离
            min = G.INFINITY;
            //遍历所有顶点找离v0最近的顶点
            for(w = 0;w < G.numVertexes;w++){
                if(end[w] != 1 && ShortPathTable[w] < min){
                    k = w;//k记录最近的点
                    min = ShortPathTable[w];
                }
            }
            //vk找完了
            end[k] = 1;
            //重点！！！修改当前最短路径和距离 更新PathPassPoint ShortPathTable
            //遍历vk与其他顶点的边
            for(w = 0; w < G.numVertexes;w++){
                if(end[w] != 1 && (min+G.arc[k][w]) < ShortPathTable[w]){
                    //得到v0经过vk到其他顶点的最短距离
                    ShortPathTable[w] = min+G.arc[k][w];
                    //v0-->vw点 前驱是vk
                    PathPassPoint[w] = k;
                }
            }
        }
        //打印最短路径及其长度
        System.out.println("最终路径为：" );
        for(int i = 0;i < G.numVertexes;i++){
            System.out.print(PathPassPoint[i] + "  ");
        }
        System.out.println();
        System.out.println("最终长度为：");
        for(int i = 0;i < G.numVertexes;i++){
            System.out.print(ShortPathTable[i] + "  ");
        }

    }

    //Floyd算法
    static void Floyd(MGraph G,int[][] PathPassMatrix,int[][] ShortPathMatrix){
        int v,w,k;
        //初始化 v行 w列
        for(v = 0;v < G.numVertexes;v++){
            for(w = 0;w < G.numVertexes;++w){
                ShortPathMatrix[v][w] = G.arc[v][w];
                PathPassMatrix[v][w] = w;
            }
        }

        //功能正式开始
        //k是路径经过的vk下标
        for(k = 0;k < G.numVertexes;k++){
            for(v = 0;v < G.numVertexes;v++){
                for(w = 0;w < G.numVertexes;w++){
                    //从v--->w 的长度 大于 v-->k--->w的长度 更新最短长度
                    if(ShortPathMatrix[v][w] > (ShortPathMatrix[v][k]+ShortPathMatrix[k][w])){
                        ShortPathMatrix[v][w] = ShortPathMatrix[v][k]+ShortPathMatrix[k][w];
                        //更新经过的下标 变为vk
                        PathPassMatrix[v][w] = PathPassMatrix[v][k];
                    }

                }
            }
        }
        //打印v0--v最后一个点的最短路径及其长度
        System.out.println("最终路径为：" );
        for(int i = 0;i < G.numVertexes;i++){
            //最短路径点在最后一个顶点的那一列
            System.out.print(PathPassMatrix[i][G.numVertexes - 1] + "  ");
        }
        System.out.println();
        System.out.println("最终长度为：");
        for(int i = 0;i < G.numVertexes;i++){
            System.out.print(ShortPathMatrix[0][i] + "  ");
        }
    }

}
