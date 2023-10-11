#include<iostream>
#include<vector>
#include<algorithm>
#define MAX_COST 1000000001
using namespace std;

int N, M;
int Graph[101][101];

int main(){
	int busStartPoint, busEndPoint,busCost;
	cin >> N >> M;
	
	for(int i=1;i<=N;i++)
		for(int j=1;j<=N;j++)
			Graph[i][j]=MAX_COST;
	
	for(int i=0;i<M;i++){
		cin >> busStartPoint >> busEndPoint >> busCost;
		Graph[busStartPoint][busEndPoint]=min(Graph[busStartPoint][busEndPoint],busCost);
	}
	
	for(int i=1;i<=N;i++)
		for(int j=1;j<=N;j++)
			if(i==j)
				Graph[i][j]=0;
	
	for(int i=1;i<=N;i++){
		for(int j=1;j<=N;j++){
			for(int k=1;k<=N;k++){
				Graph[j][k]=min(Graph[j][k],Graph[j][i]+Graph[i][k]);
			}
		}
	}
	
	for(int i=1;i<=N;i++){
		for(int j=1;j<=N;j++){
			if(Graph[i][j]==MAX_COST)
				cout << "0 ";
			else
				cout << Graph[i][j] << " ";
		}
		cout << '\n';
	}
}