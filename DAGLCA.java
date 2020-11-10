
public class DAGLCA {
	private int Verts; //Number of Vertices
	private int Edges; //Number of Edges
	private int adjacent[][]; //2D array to tell if vertices are adjacent
	private int indegree[]; //indegree of a vertex
	private int outdegree[]; //outdegree of a vertex

	public DAGLCA(int Verts){ //Ensuring no.vertices can not be less than 0
		if(Verts < 0){
			System.out.println("The number of vertices cannot be less than 0");
		}

		this.Verts = Verts;
		this.Edges = 0;
		indegree = new int[Verts];
		outdegree = new int[Verts];
		adjacent = new int[Verts][Verts];
		for(int i = 0; i<Verts; i++){
			for(int j = 0; j<Verts; j++){ //setting up empty 2D array
				adjacent[i][j] = 0;
			}
		}

	}

	public int Verts(){ //returns the number of vertices in the graph
		return Verts;
	}

	public int Edges(){ //returns the number of edges in the graph
		return Edges;
	}

	private void validateVertex(int v){ //Checks that the vertex entered is valid
		if(v<0 || v>=Verts){ //vertex can not be less than 0 or greater than the number of vertices in the graph
			System.out.println("Vertex is not valid");
		}
	}

	public void addEdge(int v, int w){ //function to add a directed edge to the graph
		validateVertex(v); 
		validateVertex(w); //ensures vertices are valid
		adjacent[v][w] = 1; //updates to say they are adjacent
		indegree[w]++; // increases the no.vertices pointing at w 
		outdegree[v]++; //increases the number of vertices that v is pointing at
		Edges++; //increase no.edges
	}

	public void removeEdge(int v, int w){ //function to remove a directed edge from the graph
		validateVertex(v);                //it is the reverse function of addEdge
		validateVertex(w);
		adjacent[v][w] = 0;
		indegree[w]--;
		outdegree[v]--;
		Edges--;
	}

	public int findLCA(int v, int w){ //validates the vertices, finds the LCA and returns it
		validateVertex(v); 
		validateVertex(w);
		int vCount = 0;
		int wCount = 0;
		int[] vArray = new int[Edges];
		int[] wArray = new int[Edges];
		boolean[] vMarked = new boolean[Verts];
		boolean[] wMarked = new boolean[Verts];
		vArray[vCount] = v;
		wArray[wCount] = w;
		for(int x = 0; x<Verts; x++){ //sets all vertices to false
			vMarked[x] = false;
			wMarked[x] = false;
		}
		for(int i = 0; i<Verts; i++){
			vMarked[v] = true;   
			wMarked[w] = true;    //marks v and w true
			for(int j = 0; j<Verts; j++){
				if(adjacent[i][j] == 1 && vMarked[i]){ //checks if i and j are adjacent and v is marked true
					vCount++;  //increases count if passes if statement
					vArray[vCount] = j; //updates value in array
					vMarked[j] = true;  //marks the adjacent to v true
				}
				if(adjacent[i][j] == 1 && wMarked[i]){ //same as above for w
					wCount++;
					wArray[wCount] = j;
					wMarked[j] = true;
				}
				if(wArray[wCount] == vArray[vCount]){  //if the LCA is found return it
					int LowestCA = wArray[wCount];
					return LowestCA;
				}
			}
		}

		return -1; //else return -1
	}	

}


