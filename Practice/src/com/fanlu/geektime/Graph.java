package com.fanlu.geektime;

import java.util.LinkedList;
import java.util.Queue;

public class Graph { // 无向图
    private int vertexNum; // 顶点的个数
    private LinkedList<Integer>[] adjacencyLists; // 邻接表

    public Graph(int vertexNum) {
        this.vertexNum = vertexNum;
        adjacencyLists = new LinkedList[vertexNum];
        for (int i = 0; i < vertexNum; ++i) {
            adjacencyLists[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adjacencyLists[s].add(t);
        adjacencyLists[t].add(s);
    }

    public void bfs(int s, int t) {
        if (s == t)
            return;

        // 记录顶点的被访问状态
        boolean[] visited = new boolean[vertexNum];
        visited[s] = true;
        // 已访问，但是其相邻顶点还未访问的顶点（最反直觉的一步，或者说最重要的一步）
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        // 搜索路径，是通过哪个前项顶点搜索过来的
        int[] prev = new int[vertexNum];
        for (int i = 0; i < vertexNum; ++i) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            // 相邻顶点中取出一个
            int w = queue.poll();
            // 遍历此顶点的相邻顶点
            for (int i = 0; i < adjacencyLists[w].size(); ++i) {
                int q = adjacencyLists[w].get(i);
                // 如果取出的相邻顶点还未访问
                if (!visited[q]) {
                    //1. 记录下它的前项顶点
                    prev[q] = w;
                    //2. 如果是最后一个顶点则打印路径
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    //3. 标记顶点为访问过
                    visited[q] = true;
                    //4. 把顶点推入队列
                    queue.add(q);
                }
            }
        }
    }

    boolean found = false; // 全局变量或者类成员变量

    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[vertexNum];
        int[] prev = new int[vertexNum];
        for (int i = 0; i < vertexNum; ++i) {
            prev[i] = -1;
        }

        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true)
            return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }

        for (int i = 0; i < adjacencyLists[w].size(); ++i) {
            int q = adjacencyLists[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s)
            print(prev, s, prev[t]);
        System.out.print(t + " ");
    }

}

