#include<iostream>
#include<set>
#include<queue>
using namespace std;

int N, M;
set<int>cutted[300000];

void bfs(int node){
	queue<int> q;
	q.push(1);
	
	
	cout << ans <<"\n";
}

int main(){
	cin >> N >> M;
	int V1, V2;
	
	for(int i=0;i<N;i++){
		cin >> V1 >> V2;
		set[V1].insert(V2);
		set[V2].insert(V1);
	}
	
	cout << "0";
	
	for(int i=1;i<N;i++)
		bfs(N);
}