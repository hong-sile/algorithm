#include<iostream>
#include<utility>
#include<vector>
#include<limits.h>
#include<queue>
using namespace std;

int N;
int see[20][20];
int minTime=INT_MAX;
int dy[4]={1,0,-1,0};
int dx[4]={0,1,0,-1};

typedef struct nextIndex{
	int distance;
	int x;
	int y;
	int index;
}nextIndex;

int bfs(int y, int x, pair<int,int>destination,int sharkSize){
	int time=-1;
	pair<int,int> currentPosition;
	pair<int,int> nextPosition;
	queue<pair<int,int>> q;
	q.push(pair<int,int>(y,x));
	
	while(!q.empty()){
		int size=q.size();
		time+=1;
		
		for(int T=0;T<size;T++){
			currentPosition=q.front();
			q.pop();
			
			for(int i=0;i<4;i++){
				nextPosition.first = currentPosition.first+dy[i];
				nextPosition.second = currentPosition.second+dx[i];
				
				if(nextPosition.first<0 || nextPosition.first >= N
				   ||nextPosition.second<0 || nextPosition.second>=N) continue;
				
				if(see[nextPosition.first][nextPosition.second] > sharkSize) continue;
				
				if(nextPosition.first==destination.first && nextPosition.second==destination.second) return time+1;
				
				q.push(nextPosition);
			}
		}
	}
	
	return time;
}

void hunt(int y, int x, int time, vector<pair<int,int>> canIntake, int sharkSize, int sharkIntake){
	if(sharkSize==sharkIntake){
		sharkIntake=0;
		sharkSize+=1;
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(see[i][j]+1==sharkSize){
					canIntake.push_back(pair<int,int>(i,j));
				}
	}
	
	vector<pair<int,int>> dCanIntake;
	int size=canIntake.size();
	
	if(size==0){
		minTime=(time<minTime) ? time : minTime;
	}
	else if(size==1){
		pair<int,int>destination(canIntake[0].first,canIntake[0].second);
		
		int huntResult=bfs(y,x,destination,sharkSize);
		
		vector<pair<int,int>> emptyVector;
		
		hunt(destination.first,destination.second,time+huntResult,emptyVector,sharkSize,sharkIntake+1);
	}
	else{
		nextIndex dIndex;
		dIndex.distance=INT_MAX;
		for(int i=0;i<size;i++){
			pair<int,int>destination=canIntake[i];
			int distance=bfs(y,x,destination,sharkSize);
			
			if(distance==0) continue;
			
			if(distance<dIndex.distance){
				dIndex.y=destination.first;
				dIndex.x=destination.second;
				dIndex.distance=distance;
				dIndex.index=i;
			}
			else if(distance==dIndex.distance){
				if(destination.first<dIndex.y){
					dIndex.y=destination.first;
					dIndex.x=destination.second;
					dIndex.index=i;
				}
				else if(destination.first==dIndex.y){
					if(destination.second<dIndex.x){
						dIndex.y=destination.first;
						dIndex.x=destination.second;
						dIndex.index=i;
					}
				}
			}
			
			dCanIntake.assign(canIntake.begin(),canIntake.end());
			dCanIntake.erase(dCanIntake.begin()+dIndex.index);
			hunt(dIndex.y,dIndex.x,time+dIndex.distance,dCanIntake,sharkSize,sharkIntake+1);
		}
	}
	/*
	for(int i = 0 ; i<size ; i++){
		pair<int,int>destination(canIntake[i].first,canIntake[i].second);
		
		int huntResult=bfs(y,x,destination,sharkSize);
		
		if(huntResult==0) continue;
		
		dCanIntake.assign(canIntake.begin(),canIntake.end());
		dCanIntake.erase(dCanIntake.begin()+i);
		hunt(destination.first,destination.second,time+huntResult,dCanIntake,sharkSize,sharkIntake+1);
	}*/
}

int main(){
	cin >> N;
	int y, x;
	vector<pair<int,int>> canIntake;
	
	for(int i=0;i<N;i++)
		for(int j=0;j<N;j++){
			cin >> see[i][j];
			if(see[i][j]==9){
				y=i;
				x=j;
				see[i][j]==0;
			}
			if(see[i][j]==1)
				canIntake.push_back(pair<int,int>(i,j));
		}
	
	hunt(y,x,0, canIntake,2,0);
	
	cout << minTime;
}


/*
1. 어떻게 물고기와 

*/