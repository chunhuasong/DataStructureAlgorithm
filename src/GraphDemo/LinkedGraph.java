package GraphDemo;

import java.util.Scanner;

/**
 * @author songhuan
 * @date 2021/11/23 13:17
 */
public class LinkedGraph {
    static int MAXVEX = 10;
    int numVertexes,numEdges;
    VextexNode[] vexs;

    public LinkedGraph() {
        this.vexs = new VextexNode[MAXVEX];
        for(int i = 0;i < MAXVEX;i++){
            vexs[i] = new VextexNode();
        }
    }

    //边表节点
    static class EdgeNode{
        int adjvex;//存储邻接点对应的下标
        int weight;
        EdgeNode next;
    }
    //顶点表节点
    static class VextexNode{
        int in;//顶点入度
        int data;
        EdgeNode firstedge;//边表头指针

        public VextexNode() {
            this.data = -1;
            this.in = 0;
        }
    }

      static void CreateLinkedGraph(LinkedGraph G){
        int i,j,k,w;

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入顶点数和边数");
        G.numVertexes = scanner.nextInt();
        System.out.println("顶点数是：" + G.numVertexes);
        G.numEdges = scanner.nextInt();
        System.out.println("边数是：" + G.numEdges);

        System.out.println("输入顶点信息");
        //初始化顶点表
        for(i = 0;i < G.numVertexes;i++){
            //给顶点表的data赋值
            G.vexs[i].data = scanner.nextInt();
            //邻接结点表头节点初始化为空
            G.vexs[i].firstedge = null;
        }
        //初始化边表
        for(k = 0;k < G.numEdges;k++){
            System.out.println("输入边（vi,vj）上的顶点序号及其权值");
            i = scanner.nextInt();
            j = scanner.nextInt();
            w = scanner.nextInt();
                 //头插法 把邻接节点插到顶点的前头
            EdgeNode e = new EdgeNode();
            //邻接序号j
            e.adjvex = j;
            e.weight = w;
            e.next = G.vexs[i].firstedge;
            G.vexs[i].firstedge = e;//头指针指向e所在位置
            G.vexs[j].in++;//j顶点入度加1
        }

    }

    public static void main(String[] args) {
        LinkedGraph G = new LinkedGraph();
        CreateLinkedGraph(G);
        //TopologicalSort(G);
        CriticalPath(G);
    }

    //拓扑排序 G无回路返回true 否则返回false
    static Boolean TopologicalSort(LinkedGraph G){
        EdgeNode e;
        int i,k,gettop;
        int top = -1;//栈顶指针
        int count = 0;//统计输出顶点的个数
        int[] stack = new int[G.numVertexes];//栈用来存入度为0的顶点
        for(i = 0;i < G.numVertexes;i++){
            if(G.vexs[i].in == 0){
                stack[++top] = i;//将入度为0的顶点入栈//++i 先自增 再赋值
            }
        }
        //栈不为空时 弹出入度0的顶点
        while (top != -1){
            gettop = stack[top--];//i--先赋值 再自减
            System.out.println(G.vexs[gettop].data);
            count++;//输出的顶点个数加1
            //遍历弹出顶点的相连顶点
            for(e = G.vexs[gettop].firstedge;e != null;e = e.next){
                k = e.adjvex;
                //弹出一个顶点 k顶点的入度减1 若入度为0 把看入栈
                if((--G.vexs[k].in) == 0){
                    stack[++top] = k;
                }
            }
        }
        if(count < G.numVertexes){
            return false;
        }
        else
            return true;
    }

    //关键路径算法
    //vk的最早发生时间和最晚发生时间
    static int[] earliest_time_of_vertex,
            latest_time_of_vertex;
    //存储拓扑序列
    static int[] stack2;
    static int top2 = -1;
    //拓扑排序改进，用于计算关键路径
    static boolean TopologicalCalculate(LinkedGraph G){
        EdgeNode e;
        int i,k,gettop;
        int top = -1;//栈顶指针
        int count = 0;//统计输出顶点的个数
        int[] stack = new int[G.numVertexes];//栈用来存入度为0的顶点
        for(i = 0;i < G.numVertexes;i++){
            if(G.vexs[i].in == 0){
                stack[++top] = i;//将入度为0的顶点入栈//++i 先自增 再赋值
            }
        }
        //初始化时间最早发生时间
        earliest_time_of_vertex = new int[G.numVertexes];
        for(i = 0;i < G.numVertexes;i++){
            earliest_time_of_vertex[i] = 0;
        }
        stack2 = new int[G.numVertexes];
        //栈不为空时 弹出入度0的顶点
        while (top != -1){
            gettop = stack[top--];//i--先赋值 再自减
            System.out.println(G.vexs[gettop].data);
            count++;//输出的顶点个数加1
            //弹出顶点压入拓扑排序的栈
            stack2[++top2] = gettop;
            //遍历弹出顶点的相连顶点
            for(e = G.vexs[gettop].firstedge;e != null;e = e.next){
                k = e.adjvex;
                //弹出一个顶点 k顶点的入度减1 若入度为0 把看入栈
                if((--G.vexs[k].in) == 0){
                    stack[++top] = k;
                }
                //！！！！更新各个顶点事件最早发生时间值 找最长的时间
                if((earliest_time_of_vertex[gettop] + e.weight) > earliest_time_of_vertex[k]){
                    earliest_time_of_vertex[k] = earliest_time_of_vertex[gettop] + e.weight;
                }
            }
        }
        if(count < G.numVertexes){
            return false;
        }
        else
            return true;
    }

    static void CriticalPath(LinkedGraph G){
        EdgeNode e;
        int i,gettop,k,j;
        //分别为活动（弧）的最早发生时间和最晚发生时间
        int earliest_time_edge,lastest_time_edge;
        //求拓扑排序stack2[]的值 计算earliest_time_of_vertex[]
        TopologicalCalculate(G);
        latest_time_of_vertex = new int[G.numVertexes];
        //初始化事件最晚发生时间 都赋值成最后汇点的最早发生时间
        for(i = 0;i < G.numVertexes;i++){
            latest_time_of_vertex[i] = earliest_time_of_vertex[G.numVertexes - 1];
        }
        while (top2 != -1){
            //弹出栈顶元素
            gettop = stack2[top2--];
            for(e = G.vexs[gettop].firstedge;e != null;e = e.next){
                k = e.adjvex;
                //计算各顶点事件最晚发生时间
                //从汇点往前推 以时间短的为准
                if(latest_time_of_vertex[k] - e.weight < latest_time_of_vertex[gettop]){
                    latest_time_of_vertex[gettop] = latest_time_of_vertex[k] - e.weight;
                }
            }
        }
        //求弧vj-->vk的最早发生时间和最晚发生时间
        for(j = 0;j < G.numVertexes;j++){
            for(e = G.vexs[j].firstedge;e != null;e = e.next){
                k = e.adjvex;
                earliest_time_edge = earliest_time_of_vertex[j];
                lastest_time_edge = latest_time_of_vertex[k] - e.weight;
                if(earliest_time_edge == lastest_time_edge){
                    System.out.println("<" + G.vexs[j].data +"," + G.vexs[k].data +">" + " " + e.weight);
                }
            }
        }
    }

}
