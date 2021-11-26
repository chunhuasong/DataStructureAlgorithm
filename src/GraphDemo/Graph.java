package GraphDemo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author songhuan
 * @date 2021/11/22 10:04
 * 包括图的邻接矩阵创建 深度广度遍历 和 最小生成树
 */
public class Graph {
    private static MGraph G = new MGraph();
    static Boolean visited[] = new Boolean[1000];


    public static void main(String[] args) {
        //输入连通边时按照顺序排布顶点和对应下标
        G.CreateMGraph(G);
//        System.out.println("深度优先遍历");
//        DFSTraverse(G);
//        System.out.println("广度优先遍历");
//        BFSTraverse(G);
        System.out.println("最小生成树");
        MiniSpanTree_Prim(G);
    }

    //邻接矩阵的深度优先递归算法
    static void DFS(MGraph G,int i){
        int j;
        visited[i] = true;
        System.out.println(G.vexs[i]);
        for(j = 0;j < G.numVertexes;j++){
            if(G.arc[i][j] == 1 && !visited[j]){
                //如果vi,vj连通，vj没有被访问过
                DFS(G,j);
            }
        }
    }
    //邻接矩阵的深度遍历操作
    static void DFSTraverse(MGraph G){
        int i;
        for(i = 0;i < G.numVertexes;i++){
            visited[i] = false;
        }
        for(i = 0;i < G.numVertexes;i++){
            if(!visited[i]) {
                DFS(G, i);
            }
        }
    }
    //邻接矩阵的广度遍历操作
    static void BFSTraverse(MGraph G){
        int i,j;
        Queue<Integer> Q = new LinkedList();
        for(i = 0;i < G.numVertexes;i++){
            visited[i] = false;
        }
        for(i = 0;i < G.numVertexes;i++){
            if(!visited[i]){
                visited[i] = true;
                System.out.println(G.vexs[i]);
                //当前访问的顶点入队
                Q.offer(i);
                while (!Q.isEmpty()){
                    i = Q.poll();
                    for(j = 0;j < G.numVertexes;j++){
                        //如果其他顶点与当前顶点存在边且未访问过
                        if(G.arc[i][j] == 1 && !visited[j]){
                            visited[j] = true;
                            System.out.println(G.vexs[j]);
                            Q.offer(j);
                        }
                    }
                }
            }
        }
    }
    //Prim算法生成最小生成树
    static void MiniSpanTree_Prim(MGraph G){
        int min,i,j,k;
        //保存相关顶点下标
        int adjvex[] = new int[G.MAXVEX];
        //保存边的权值
        int lowcost[] = new int[G.MAXVEX];
        //v0加入了生成树 初始化第一个权值为0
        //凡是lowcost数组的值被设为0 就是此下标的顶点被纳入最小生成树
        lowcost[0] = 0;
        //初始化第一个顶点的下标为0 从v0开始
        adjvex[0] = 0;
        //循环除下标为0外的全部顶点
        for(i = 1;i < G.numVertexes;i++){
            //将v0顶点相连的边的权值存入数组
            lowcost[i] = G.arc[0][i];
            //初始化都为v0的下标
            adjvex[i] = 0;
        }
        //初始化
        //正式开始构造最小生成树
        for(i = 1;i < G.numVertexes;i++){
            min = G.INFINITY;
            //j---循环顶点下标
            j = 1;
            //k存储最小权值的顶点下标
            k = 0;
            while (j < G.numVertexes){
                if(lowcost[j] != 0 && lowcost[j] < min){
                    //更换权值最小值
                    min = lowcost[j];
                    //把最小值下标存到k里
                    k = j;
                }
                j++;
            }
            System.out.println("(" + G.vexs[adjvex[k]] + "," + k + ")" + " min:" + min);
            //k顶点已经被加入最小生成树之中
            lowcost[k] = 0;


            //循环剩余没在生成树的顶点 从k开始找下一个点
            for(j = 1;j < G.numVertexes;j++){
                //把vk的权值放入lowcost
                if(lowcost[j] != 0 && G.arc[k][j] < lowcost[j]){
                    lowcost[j] = G.arc[k][j];
                    adjvex[j] = k;//adjvex存储了每一次循环的起点顶点下标
                }
            }
        }
    }
}

class MGraph {
    //邻接矩阵
    static int MAXVEX = 100;
    static int INFINITY = 65535;
    String vexs[] = new String[MAXVEX];//顶点表
    int arc[][] =  new int[MAXVEX][MAXVEX];//邻接矩阵 边表
    int numVertexes,numEdges;//顶点数和边数


    public void CreateMGraph(MGraph G){
        int i,j,k,w;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入顶点数和边数");
        G.numVertexes = scanner.nextInt();
        System.out.println("顶点数是：" + G.numVertexes);
        G.numEdges = scanner.nextInt();
        System.out.println("边数是：" + G.numEdges);

        System.out.println("输入顶点信息");
        for(i = 0;i < G.numVertexes;i++){
            G.vexs[i] = scanner.next();
        }

        for(i = 0;i < G.numVertexes;i++){
            for(j = 0;j < G.numVertexes;j++){
                G.arc[i][j] = INFINITY;
            }
            G.arc[i][i] = 0;
        }
        for(k = 0;k < G.numEdges;k++){
            System.out.println("输入边（vi,vj）上的权重w");
            i = scanner.nextInt();
            j = scanner.nextInt();
            w = scanner.nextInt();
            G.arc[i][j] = w;
            G.arc[j][i] = G.arc[i][j];
        }
    }



}


