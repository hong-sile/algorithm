#include<iostream>
#include<queue>
#include<math.h>
#include<utility>
using namespace std;

int N, L, R;
int country[50][50];
int ans=0;
int dy[4]={1,0,-1,0};
int dx[4]={0,1,0,-1};

void bfs(int y, int x,bool check[][50]){
	queue<pair<int,int>> q;
	vector<pair<int,int>> open;
	int total=country[y][x];
	int cur_y;
	int cur_x;
	int next_y;
	int next_x;
	int average;
	q.push(pair<int,int>(y,x));
	open.push_back(pair<int,int>(y,x));
	check[y][x]=true;
	
	while(!q.empty()){
		cur_y=q.front().first;
		cur_x=q.front().second;
		q.pop();
		
		for(int i=0;i<4;i++){
			next_y=cur_y+dy[i];
			next_x=cur_x+dx[i];
			
			if(next_y<0 || next_y>=N || next_x <0 || next_x>=N||
			  check[next_y][next_x]) continue;
			
			if(abs(country[cur_y][cur_x]-country[next_y][next_x]) < L ||
			  abs(country[cur_y][cur_x]-country[next_y][next_x]) > R) continue;
			
			pair<int,int>next(next_y,next_x);
			
			check[next_y][next_x]=true;
			total+=country[next_y][next_x];
			
			q.push(next);
			open.push_back(next);
		}
	}
	
	
	average=total/open.size();
	
	for(int i=0;i<open.size();i++)
		country[open[i].first][open[i].second]=average;
	
	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++)
			cout << check[i][j]<<" ";
		cout <<endl;
	}
	cout <<endl;
	
	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++)
			cout << country[i][j]<<" ";
		cout <<endl;
	}
	cout <<endl;
}

bool checkDay(){
	bool isMove=false;
	bool check[50][50];
	
	for(int i=0;i<N;i++)
		for(int j=0;j<N;j++){
			check[i][j]=false;
		}
	
	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++){
			if(check[i][j]) continue;
			
			if( j-1>=0 &&
			   abs(country[i][j]-country[i][j-1]) >= L && abs(country[i][j]-country[i][j-1]) <= R){
				isMove=true;
				bfs(i,j,check);
			}
			
			if( i-1>=0 &&
			   abs(country[i][j]-country[i-1][j]) >= L && abs(country[i][j]-country[i-1][j]) <= R){
				isMove=true;
				bfs(i,j,check);
			}
			
			if( j+1<N &&
			   abs(country[i][j]-country[i][j+1]) >= L && abs(country[i][j]-country[i][j+1]) <= R){
				isMove=true;
				bfs(i,j,check);
			}
			
			if( i+1<N &&
			   abs(country[i][j]-country[i+1][j]) >= L && abs(country[i][j]-country[i+1][j]) <= R){
				isMove=true;
				bfs(i,j,check);
			}
		}
	}
	
	return isMove;
}

int main(){
	cin >> N >> L >> R;
	
	for(int i=0;i<N;i++)
		for(int j=0;j<N;j++)
			cin >> country[i][j];
	
	while(checkDay()) ans+=1;
	
	
	cout << ans;
}