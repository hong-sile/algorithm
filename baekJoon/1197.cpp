#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

long long int ans;

class Edge{
public:
	int node[2];
	int distance;
	
	Edge(int v1,int v2,int distance){
		this->node[0]=v1;
		this->node[1]=v2;
		this->distance=distance;
	}
	
	bool operator < (const Edge& e){
		return this->distance < e.distance;
	}
};

class DisjointSet{
public:
	int *arr;
	DisjointSet(int size){
		this->arr=(int*)malloc(sizeof(int)*(size+1));
		
		for(int i=1;i<=size;i++)
			arr[i]=i;
	}
	
	void unionSet(int v1, int v2, int distance){
		v1=find(v1);
		v2=find(v2);
		
		if(v1!=v2){
			arr[v2]=v1;
			ans+=distance;
		}
	}
	
	int find(int v1){
		if(arr[v1]==v1)
			return v1;
		else
			return find(arr[v1]);
	}
};

int main(){
	int V, E;
	int v1, v2, distance;
	scanf("%d %d", &V, &E);
	vector<Edge> edges;
	DisjointSet dSet(E);
	
	for(int i=0;i<E;i++){
		scanf("%d %d %d", &v1, &v2, &distance);
		edges.push_back(Edge(v1,v2,distance));
	}
	
	sort(edges.begin(),edges.end());
	
	for(int i=0;i<E;i++)
		dSet.unionSet(edges[i].node[0],edges[i].node[1],edges[i].distance);
	
	cout << ans;
}