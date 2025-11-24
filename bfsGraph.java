package tugas.pkg3.struktur.data;

import java.util.Iterator;
import java.util.LinkedList;


public class bfsGraph {

    private int V;
    private LinkedList<Integer> adj[];

    bfsGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s, int target) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        System.out.println("Mulai BFS dari vertex: " + s);
        System.out.println("Mencari angka: " + target);
        System.out.println("Tandai " + s + " sebagai visited dan memasukkan ke queue");

        while (!queue.isEmpty()) {
            System.out.println("\nQueue saat ini : " + queue);

            s = queue.poll();
            System.out.println("Ambil dari queue (pool): " + s);
            System.out.println("Kunjungi node: " + s);

            // Cek apakah node saat ini adalah target
            if (s == target) {
                System.out.println("TARGET ditemukan! Angka " + target + " ada dalam graf.");
                return;
            }

            Iterator<Integer> i = adj[s].listIterator();

            while (i.hasNext()) {
                int n = i.next();

                System.out.println("  Cek tetangga: " + n);

                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                    System.out.println("    -> Belum Visited, tandai visited dan masukkan ke queue: " + n);

                } else {
                    System.out.println("    -> Sudah visited, lewati.");
                }
            }
        }

        System.out.println("\nTARGET " + target + " TIDAK ditemukan di graf.");

    }

    public static void main(String args[]) {
        bfsGraph g = new bfsGraph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(5, 5);
        
        int start = 0;
        int cariN = 4;
        
        System.out.println("BFS dengan vertex awal " + start);
        g.BFS(start, cariN);

    }

}