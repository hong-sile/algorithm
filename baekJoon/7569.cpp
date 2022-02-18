#include<iostream>
#include<queue>
using namespace std;

typedef struct point{
	int x;
	int y;
	int z;
	point() {}
	point(int X, int Y, int Z) : x(X), y(Y), z(Z){}
}point;

int M, N, H;
int tomato[100][100][100];
int dx[6]={0,1,0,-1,0,0};
int dy[6]={1,0,-1,0,0,0};
int dz[6]={0,0,0,0,1,-1};
queue<point> q;
int ripeTomato;

int dfs(){
	int count=0;
	queue<point>nodeList;
	point current;
	
	while(!q.empty()){
		count+=1;
		
		while(!q.empty()){
			nodeList.push(q.front());
			q.pop();
		}
		
		while(!nodeList.empty()){
			current=nodeList.front();
			nodeList.pop();
			
			for(int i=0;i<6;i++){
				point nextNode = {current.x+dx[i],current.y+dy[i],current.z+dz[i]};
				
				if(nextNode.x<0 || nextNode.x>=N ||
				  nextNode.y<0 || nextNode.y>=M ||
				  nextNode.z<0 || nextNode.z>=H) continue;
				
				if(tomato[nextNode.x][nextNode.y][nextNode.z] != 0) continue;
				
				q.push(nextNode);
				ripeTomato+=1;
				tomato[nextNode.x][nextNode.y][nextNode.z]=1;
			}
		}
	}
	
	return count-1;
}

int main(){
	int ans;
	cin >> M >> N >> H;
	
	for(int k=0;k<H;k++)
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++){
				cin >> tomato[i][j][k];
				if(tomato[i][j][k]==1){
					q.push(point(i,j,k));
					ripeTomato+=1;
				}
				if(tomato[i][j][k]==-1) ripeTomato+=1;
			}
	
	ans = dfs();

	if(ripeTomato==N*M*H){
		cout << ans;
		return 0;
	}
	
	cout << "-1";
}
//다음엔 조금더 효율적으로 짜기
//https://www.acmicpc.net/problem/7569