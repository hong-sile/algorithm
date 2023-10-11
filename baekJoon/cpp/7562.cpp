#include<iostream>
#include<queue>
#include<utility>
using namespace std;

int dy[8]={2,2,1,1,-1,-1,-2,-2};
int dx[8]={-1,1,2,-2,2,-2,1,-1};
pair<int,int> curPos;
pair<int,int> targetPos;
int y,x,ny,nx,I;

int dfs(){
	queue<pair<int,int>> q;
	bool check[300][300]={false,};
	int cnt=0;
	q.push(curPos);
	int qSize;
	
	while(!q.empty()){
		qSize=q.size();
		
		for(int repeat=0;repeat<qSize;repeat++){
			y=q.front().first;
			x=q.front().second;
			q.pop();
			for(int i=0;i<8;i++){
				ny=y+dy[i];
				nx=x+dx[i];
				
				if(ny<0 || ny>=I || nx<0 || nx>=I || check[ny][nx]) continue;
				
				if(ny==targetPos.first && nx==targetPos.second) return cnt+1;
				
				q.push(make_pair(ny,nx));
				check[ny][nx]=true;
			}
		}
		cnt+=1;
	}
	return cnt;
}

int main(){
	int T;
	
	cin >> T;
	while(T--){
		cin >> I;
		cin >> curPos.first >> curPos.second;
		cin >> targetPos.first >> targetPos.second;
		if(curPos.first==targetPos.first && curPos.second==targetPos.second){
			cout << "0\n";
			continue;
		}
		cout << dfs()<<'\n';
	}
}