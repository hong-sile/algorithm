//fail

#include<iostream>
#include<utility>
#include<string>
#include<queue>
using namespace std;

int N, M;
int matrix[1000][1000];
int checkMatrix[1000][1000][2];
int dy[4]={1,-1,0,0};
int dx[4]={0,0,1,-1};


typedef struct Point{
	int y;
	int x;
	int canBreakWall=1;
}Point;

int dfs(){
	int cnt=1;
	int size=0;
	queue<Point> q;
	Point curPoint;
	Point nextPoint;
	curPoint.y=0;
	curPoint.x=0;
	q.push(curPoint);
	checkMatrix[0][0][1]=1;
	
	while(!q.empty()){
		size=q.size();
		
		for(int i=0;i<size;i++){
			curPoint = q.front();
			q.pop();
			cout << "curpoint" << curPoint.y <<" "<< curPoint.x<<endl;
			for(int dir=0;dir<4;dir++){
				nextPoint.y=curPoint.y+dy[dir];
				nextPoint.x=curPoint.x+dx[dir];
				nextPoint.canBreakWall=curPoint.canBreakWall;
				
				if(nextPoint.y <0 || nextPoint.y==N || nextPoint.x<0 || nextPoint.x==M) continue;
				
				if(matrix[nextPoint.y][nextPoint.x]==1 && nextPoint.canBreakWall){
					nextPoint.canBreakWall=0;
					checkMatrix[nextPoint.y][nextPoint.x][0]=checkMatrix[curPoint.y][curPoint.x][1]+1;
				}
				else if(matrix[nextPoint.y][nextPoint.x]==0 && checkMatrix[nextPoint.y][nextPoint.x][nextPoint.canBreakWall]){
					checkMatrix[nextPoint.y][nextPoint.x][nextPoint.canBreakWall] = checkMatrix[curPoint.y][curPoint.x][nextPoint.canBreakWall]+1;
				}
				else continue;
				
				if(nextPoint.y==N-1 && nextPoint.x==M-1) return checkMatrix[nextPoint.y][nextPoint.x][nextPoint.canBreakWall];

				q.push(nextPoint);
				
			}
			cout << endl << endl;
		}
	}
	return -1;
}


int main(){
	string temp;
	cin >> N >> M;
	
	for(int i=0;i<N;i++){
		cin >> temp;
		for(int j=0;j<M;j++){
			matrix[i][j]=temp[j]-'0';
		}
	}
	
	cout << dfs();
}