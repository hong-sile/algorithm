#include<iostream>
#include<utility>
#include<queue>
#define APPLE -1
#define SNAKEBODY 1
using namespace std;

queue<pair<int,char>> changeDir;
queue<pair<int,int>> snake;

int N, K, L;
int dy[4]={-1,0,1,0};
int dx[4]={0,1,0,-1};
int map[101][101];

void printMap(){
	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++)
			printf("%d ",map[i][j]);
		cout << endl;
	}
	cout << endl << endl;
}

int main(){
	int y, x;
	int sec;
	char dir;
		
	int currentSec=0;
	int currentY=0;
	int currentX=0;
	int currentDir=1;
	char nextDir;
	int nextDirSec;
	
	cin >> N >> K;
	
	for(int i=0;i<K;i++){
		cin >> y >> x;
		map[y-1][x-1]=APPLE;
	}
	
	cin >> L;
	
	for(int i=0;i<L;i++){
		cin >> sec >> dir;
		changeDir.push({sec,dir});
	}
	
	nextDirSec=changeDir.front().first;
	nextDir=changeDir.front().second;
	changeDir.pop();
	map[0][0]=SNAKEBODY;
	snake.push({0,0});
	
	while(1){
		currentSec+=1;
		
		//이동 부
		currentY=currentY+dy[currentDir];
		currentX=currentX+dx[currentDir];
		
		//충돌 여부 체크
		if(currentY < 0 || currentY >=N || currentX < 0 || currentX >=N){
			break;
		}
		if(map[currentY][currentX]==SNAKEBODY){
			break;
		}
		
		//사과 체크 부
		if(map[currentY][currentX]!=APPLE){
			pair<int,int> tail= snake.front();
			map[tail.first][tail.second]=0;
			snake.pop();
		}
		else{
			map[currentY][currentX]=0;
		}
		
		//방향 전환 부
		if(nextDirSec==currentSec){
			if(nextDir=='L'){
				currentDir-=1;
				if(currentDir<0)
					currentDir+=4;
			}
			else if(nextDir=='D'){	
				currentDir+=1;
				if(currentDir>3)
					currentDir-=4;
			}
			
			if(!changeDir.empty()){
				nextDirSec=changeDir.front().first;
				nextDir=changeDir.front().second;
				changeDir.pop();
			}
			
		}
		
		map[currentY][currentX]=SNAKEBODY;
		snake.push({currentY,currentX});
	}
	//cout << map[currentY][currentX] << endl;
	cout << currentSec;
}



//자기 몸에 부딪히는 케이스를 어떻게 체크 할 것인지 -> map에 자기 몸을 체크
/*
꼬리가 줄어들고 다음 꼬리의 좌표는 어떻게 구할지 -> 이동시 checkTailCount 값으로 map에 저장.
이럴 경우 뱀의 몸체에 고유한 번호가 붙고, 해당 번호가 작을 수록 꼬리에 가까운 값이란 의미로
다음 꼬리의 좌표를 고를 수 가 있음.
*/
