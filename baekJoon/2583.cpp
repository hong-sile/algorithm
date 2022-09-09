#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<queue>
using namespace std;

int M, N;
bool map[100][100];
int dy[4]={1,-1,0,0};
int dx[4]={0,0,1,-1};

int bfs(int inputY,int inputX){
	queue<pair<int,int>> q;
	int y,x,ny,nx,cnt=1;
	q.push(make_pair(inputY,inputX));
	map[inputY][inputX]=true;
	
	while(!q.empty()){
		y=q.front().first;
		x=q.front().second;
		q.pop();
		for(int i=0;i<4;i++){
			ny=y+dy[i];
			nx=x+dx[i];
			
			if(ny<0 || ny>=M || nx<0 || nx>=N || map[ny][nx]) continue;
			
			q.push(make_pair(ny,nx));
			map[ny][nx]=true;
			cnt+=1;
		}
	}
	return cnt;
}

int main(){
	int K,sizeA;
	int ly,lx,ry,rx;
	vector<int> ans;
	
	cin >> M >> N >> K;
	for(int i=0;i<K;i++){
		cin >> lx >> ly >> rx >> ry;
		rx-=1;
		ry-=1;
		for(int y=ly;y<=ry;y++)
			for(int x=lx;x<=rx;x++)
				map[y][x]=true;
	}
	
	for(int i=0;i<M;i++)
		for(int j=0;j<N;j++)
			if(!map[i][j])
				ans.push_back(bfs(i,j));
	
	sort(ans.begin(),ans.end());
	
	sizeA=ans.size();
	cout << sizeA << '\n';
	
	for(int i=0;i<sizeA;i++)
		cout << ans[i]<<" ";
}