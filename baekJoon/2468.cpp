#include<iostream>
#include<queue>
using namespace std;

int N;
int map[100][100];
int maxHeight=-1;
int ans=0;
int dy[4]={1,0,-1,0};
int dx[4]={0,1,0,-1};

bool bfs(int height, int y, int x, bool (*check)[100]){
	if(map[y][x]<=height) return false;
	
	int cur_x;
	int cur_y;
	int next_x;
	int next_y;
	queue<pair<int,int>> q;
	
	q.push(pair<int,int>(y,x));
	
	
	while(!q.empty()){
		cur_y=q.front().first;
		cur_x=q.front().second;
		q.pop();
		check[cur_y][cur_x]=true;
		
		for(int i=0;i<4;i++){
			next_y=cur_y+dy[i];
			next_x=cur_x+dx[i];
			
			if(check[next_y][next_x]) continue;
			
			if(next_y<0 || next_y >= N ||
			  next_x<0 || next_x >= N)
				continue;
			
			check[next_y][next_x]=true;
			
			if(map[next_y][next_x]<=height)
				continue;
			
			q.push(pair<int,int>(next_y,next_x));
		}
	}
	return true;
}

int main(){
	cin >> N;
	
	for(int i=0;i<N;i++)
		for(int j=0;j<N;j++){
			cin >> map[i][j];
			if(maxHeight<map[i][j]) maxHeight=map[i][j];
		}
	
	for(int H=0;H<=maxHeight;H++){
		bool check[100][100];
		int count=0;
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				check[i][j]=false;
		
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(check[i][j]==false)
					if(bfs(H,i,j,check))
						count+=1;
		
		ans=(ans>count) ? ans : count;
	}
	
	cout << ans;
}