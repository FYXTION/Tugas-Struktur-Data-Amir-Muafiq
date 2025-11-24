package tugas.pkg3.struktur.data;

import java.util.Iterator;
import java.util.LinkedList;

public class dfsGraph {

    private int V; // Menampung Jumlah Vertex
    private LinkedList<Integer> adj[]; // Adjacency List

    dfsGraph(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Menambahkan edge dari vertex v ke vertex w
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    /**
     * DFS Util (rekursif) *
     */
    void DFSUtil(int v, boolean visited[]) {
        System.out.println("Visit node: " + v);
        visited[v] = true;

        Iterator<Integer> i = adj[v].listIterator();

        while (i.hasNext()) {
            int n = i.next();

            System.out.println("  Periksa tetangga dari " + v + ": " + n);

            if (!visited[n]) {
                System.out.println("   Masuk ke: " + n);
                DFSUtil(n, visited);
                System.out.println("Backtrack ke: " + v);
            } else {
                System.out.println("    (Sudah dikunjungi) -> " + n);
            }
        }
    }

    /**
     * DFS Utama (Tanpa Pencarian) *
     */
    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    /**
     * Pencarian nilai n di Graf menggunakan DFS *
     */
    boolean searchDFS(int start, int target) {
        boolean visited[] = new boolean[V];
        boolean found = searchDFSUtil(start, target, visited);
        if (!found) {
            System.out.println("Node " + target + " TIDAK ditemukan di graf.");
        }

        return found;
    }

    /**
     * DFS Util untuk Pencarian *
     */
    private boolean searchDFSUtil(int current, int target, boolean visited[]) {
        visited[current] = true;

        // Jika node cocok -> ditemukan
        if (current == target) {
            System.out.println("Node ditemukan: " + current);
            return true;
        }

        Iterator<Integer> it = adj[current].listIterator();

        while (it.hasNext()) {
            int next = it.next();

            System.out.println("   Periksa tetangga dari " + current + ": " + next);

            if (!visited[next]) {
                System.out.println("    Masuk ke: " + next);

                if (searchDFSUtil(next, target, visited)) {
                    return true;
                } else {
                    System.out.println("    Kembali ke: " + current + " (setelah cek " + next + ") ");
                }
            } else {
                System.out.println("    (Sudah dikunjungi) -> " + next);
            }

        }

        return false; // Tidak Ditemukan
    }

    public static void main(String args[]) {

        dfsGraph g = new dfsGraph(8);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 7);
        g.addEdge(4, 7);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        
        /** Tampilkan DFS **/
        System.out.println("DFS (mulai dari 0):");
        g.DFS(0);
        
        System.out.println("\n");
        
        /** Cari Node N **/
        int target = 3;
        
        System.out.println("Mencari node " + target + " dengan DFS:");
        boolean find = g.searchDFS(0, target);
        
        if(!find)
        {
            System.out.println("Node " + target + " TIDAK ditemukan di Graf.");
        }

    }

}
