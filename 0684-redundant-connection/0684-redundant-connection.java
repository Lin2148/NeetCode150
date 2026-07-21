class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n+1);

        for (int i = 0; i < n; i++){
            int edgeX = edges[i][0];
            int edgeY = edges[i][1];
            if (uf.find(edgeX) != uf.find(edgeY)){
                uf.union(edgeX, edgeY);
            }
            else return edges[i];
        }
        // 走不到
        return new int[0];
    }
}

class UnionFind{
    private int[] parent;
    
    public UnionFind(int n){
        this.parent = new int[n];

        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public int find(int n){
        if (parent[n] == n){
            return n;
        }
        
        int root = find(parent[n]);
        parent[n] = root;
        return root;
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY){
            parent[rootY] = rootX;
        }
    }
}