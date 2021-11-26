package GraphDemo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author songhuan
 * @date 2021/11/22 16:22
 */
public class MiniTree_Kruskal {

    static int numVertexes,numEdges;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入顶点数和边数");
        numVertexes = scanner.nextInt();
        System.out.println("顶点数是：" + numVertexes);
        numEdges = scanner.nextInt();
        System.out.println("边数是：" + numEdges);
        Edge[] edges = new Edge[numEdges];
        Edge[] minTree = new Edge[numVertexes - 1];

        for(int i = 0;i < numEdges;i++) {
            System.out.println("请输入图中各个边的信息：");
            int begin = scanner.nextInt(), end = scanner.nextInt(), weight = scanner.nextInt();
            edges[i] = new Edge(begin,end,weight);
        }
        Kruskal_MinTree(edges,minTree);

    }


    public static void Kruskal_MinTree(Edge[] edges,Edge[] minTree){
        int[] assists = new int[numVertexes] ;
        //每个顶点配置一个标记值
        for(int i = 0;i < numVertexes;i++){
            assists[i] = i;
        }
        //按照权值升序排序
        Arrays.sort(edges);
        //遍历所有的边 num 代表最小生成树里的边
        int num = 0;
        for(int i = 0;i < numEdges;i++){
            //找到边的起点终点在assists里面的下标
            int begin = edges[i].begin;
            int end = edges[i].end;
            //如果两端的标记不相等 则没有环路
            if(assists[begin] != assists[end]){
                //把这条边加入树
                minTree[num] = edges[i];
                //树的边数多1
                num++;
                //已经加入树的边 把他们的顶点换成一样的标记
                int element = assists[end];
                for(int k = 0;k < numVertexes;k++){
                    if(assists[k] == element){
                        assists[k] = assists[begin];
                    }
                }
                if(num == numVertexes - 1){
                    break;
                }
            }
        }
        System.out.println("最小生成树为：");
        int cost = 0;
        for (int i = 0; i < numVertexes - 1; i++) {
            System.out.println(minTree[i].begin+" - "+ minTree[i].end+" 权值为："+minTree[i].weight);
            cost += minTree[i].weight;
        }
        System.out.print("总权值为:"+cost);
    }
}

class Edge implements Comparable<Edge>{
    int begin;
    int end;
    int weight;
        //每个路径都有 2 个顶点和 1 个权值

        public Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }

    @Override
    //升序排序
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
