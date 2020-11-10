
public class DAGLCA {
	private int Verts; //Number of Vertices
	private int Edges; //Number of Edges
	private int adjacent[][]; //2D array to tell if vertices are adjacent
	private int indegree[]; //indegree of a vertex
	private int outdegree[]; //outdegree of a vertex

	public DAGLCA(int Verts){
		if(Verts < 0){
			System.out.println("The number of vertices cannot be less than 0");
		}

		this.Verts = Verts;
		this.Edges = 0;
		indegree = new int[Verts];
		outdegree = new int[Verts];
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

	public int findLCA(int v, int w){
		validateVertex(v);
		validateVertex(w);
		int answer = LCAUtil(v, w);
		return answer;
		//if(Edges > 0){
		//	int answer = LCAUtil(v, w);
		//	return answer;
		//}
		//else{
		//	throw new IllegalArgumentException("This graph is not an acyclic graph.");
		//}
	}

	private int LCAUtil(int v, int w){
		int vCount = 0;
		int wCount = 0;
		int[] vArray = new int[Edges];
		int[] wArray = new int[Edges];
		boolean[] vMarked = new boolean[Verts];
		boolean[] wMarked = new boolean[Verts];
		vArray[vCount] = v;
		wArray[wCount] = w;
		for(int x = 0; x<Verts; x++){ 
			vMarked[x] = false;
			wMarked[x] = false;
		}
		for(int i = 0; i<Verts; i++){
			vMarked[v] = true;
			wMarked[w] = true;
			for(int j = 0; j<Verts; j++){
				if(adjacent[i][j] == 1 && vMarked[i]){
					vCount++;
					vArray[vCount] = j;
					vMarked[j] = true;
				}
				if(adjacent[i][j] == 1 && wMarked[i]){
					wCount++;
					wArray[wCount] = j;
					wMarked[j] = true;
				}
				if(wArray[wCount] == vArray[vCount]){
					int LowestCA = wArray[wCount];
					return LowestCA;
				}
			}
		}

		return -1;
	}	

}


