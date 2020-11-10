
public class DAGLCA {
	private int Verts; //Number of Vertices
	private int Edges; //Number of Edges
	private int adjacent[][]; //2D array to tell if vertices are adjacent
	private int indegree[]; //indegree of a vertex
	private int outdegree[]; //outdegree of a vertex
	private int visited[]; //checks if vertex has been visited

	public DAGLCA(int Verts){
		if(Verts < 0){
			System.out.println("The number of vertices cannot be less than 0");
		}

		this.Verts = Verts;
		this.Edges = 0;
		indegree = new int[Verts];
		outdegree = new int[Verts];
		visited = new int[Verts];
		adjacent = new int[Verts][Verts];
		for(int i = 0; i<Verts; i++){
			for(int j = 0; j<Verts; j++){
				adjacent[i][j] = 0;
			}
		}

	}

	public int Verts(){
		return Verts;
	}

	public int Edges(){
		return Edges;
	}

	private void validateVertex(int v){
		if(v<0 || v>=Verts){
			System.out.println("Vertex is not valid");
		}
	}

	public void addEdge(int v, int w){
		validateVertex(v);
		validateVertex(w);
		adjacent[v][w] = 1;
		indegree[w]++;
		outdegree[v]++;
		Edges++;
	}

	public void removeEdge(int v, int w){
		validateVertex(v);
		validateVertex(w);
		adjacent[v][w] = 0;
		indegree[w]--;
		outdegree[v]--;
		Edges--;
	}

} 

