package GraphDemo;

/**
 * @author http://c.biancheng.net/algorithm/kruskal.html
 * @date 2021/11/22 16:38
 */
import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {
    static int N = 9; // 图中边的数量
    static int P = 6; // 图中顶点的数量
    //构建表示路径的类
    public static class edge implements Comparable<edge>{
        //每个路径都有 2 个顶点和 1 个权值
        int initial;
        int end;
        int weight;
        public edge(int initial, int end, int weight) {
            this.initial = initial;
            this.end = end;
            this.weight = weight;
        }
        //对每个 edge 对象根据权值做升序排序
        @Override
        public int compareTo(edge o) {
            return this.weight - o.weight;
        }
    }

    public static void kruskal_MinTree(edge[] edges,edge [] minTree) {
        int []assists = new int[P];
        //每个顶点配置一个不同的标记值
        for (int i = 0; i < P; i++) {
            assists[i] = i;
        }
        //根据权值，对所有边进行升序排序
        Arrays.sort(edges);
        //遍历所有的边
        int num = 0;
        for (int i = 0; i < N; i++) {
            //找到当前边的两个顶点在 assists 数组中的位置下标
            int initial = edges[i].initial - 1;
            int end = edges[i].end - 1;
            //如果顶点位置存在且顶点的标记不同，说明不在一个集合中，不会产生回路
            if (assists[initial] != assists[end]) {
                //记录该边，作为最小生成树的组成部分
                minTree[num] = edges[i];
                //计数+1
                num++;
                int elem = assists[end];
                //将新加入生成树的顶点标记全不更改为一样的
                for (int k = 0; k < P; k++) {
                    if (assists[k] == elem) {
                        assists[k] = assists[initial];
                    }
                }
                //如果选择的边的数量和顶点数相差1，证明最小生成树已经形成，退出循环
                if (num == P - 1) {
                    break;
                }
            }
        }
    }
    public static void display(edge [] minTree) {
        System.out.println("最小生成树为：");
        int cost = 0;
        for (int i = 0; i < P - 1; i++) {
            System.out.println(minTree[i].initial+" - "+ minTree[i].end+" 权值为："+minTree[i].weight);
            cost += minTree[i].weight;
        }
        System.out.print("总权值为:"+cost);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        edge[] edges = new edge[N];
        edge[] minTree = new edge[P-1];
        System.out.println("请输入图中各个边的信息：");
        for(int i=0;i<N;i++) {
            int initial = scn.nextInt(), end = scn.nextInt(), weight = scn.nextInt();
            edges[i] = new edge(initial,end,weight);
        }
        kruskal_MinTree(edges,minTree);
        display(minTree);
    }
}
