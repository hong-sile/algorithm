#include<iostream>
#include<utility>
#include<queue>
#include<cstdlib>
using namespace std;

int map[20][20];
int sharkSize=2;
pair<int,int> sharkPos;
int sharkAmountEaten=0;
int ansTime=0;
int N;
//priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> canIntake;
queue<pair<int,int>> canIntake;
int dy[4]={1,-1,0,0};
int dx[4]={0,0,1,-1};

int bfs(pair<int,int> target){
	int check[20][20]={0,};
	queue<pair<int,int>> q;
	pair<int,int> curPos;
	pair<int,int> nextPos;
	q.push(sharkPos);
	check[sharkPos.first][sharkPos.second]=1;
	int visitTime=0;
	
	while(!q.empty()){
		int qSize=q.size();
		for(int repeat=0; repeat<qSize;repeat++){
			curPos=q.front();
			q.pop();
			for(int i=0;i<4;i++){
				nextPos.first=curPos.first+dy[i];
				nextPos.second=curPos.second+dx[i];
				
				if(nextPos.first <0 || nextPos.first > N || nextPos.second<0 || nextPos.second > N||
				  check[nextPos.first][nextPos.second])
					continue;
				
				if(map[nextPos.first][nextPos.second]>sharkSize) continue;
				
				if(nextPos.first==target.first && nextPos.second==target.second) return visitTime+1;
				
				check[nextPos.first][nextPos.second]=1;
				q.push(nextPos);
			}
		}
		visitTime+=1;
	}
	
	return -1;
}

void hunt(){
	pair<int,int> target;
	int nextMove;
	
	while(!canIntake.empty()){
		target=canIntake.top();
		canIntake.pop();
		cout << target.first << " " << target.second<< '\n';
		//time을 계산하는 부분
		nextMove=bfs(target);
		if(nextMove==-1)
			return;
		ansTime+=nextMove;
		sharkPos=target;
		sharkAmountEaten+=1;
		if(sharkAmountEaten==sharkSize){
			sharkAmountEaten=0;
			sharkSize+=1;
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++){
					if(sharkSize-1==map[i][j])
						canIntake.push(make_pair(i,j));
				}
		}
	}
}

int main(){
	cin >> N;
	
	for(int i = 0; i < N; i++)
		for(int j=0; j< N ; j++){
			cin >> map[i][j];
			if(map[i][j]==9){
				sharkPos.first=i;
				sharkPos.second=j;
			}
			if(map[i][j]==1){
				canIntake.push(make_pair(i,j));
			}
		}
	
	hunt();
	
	cout << ansTime;
}

//다시풀어봐야하는 문제