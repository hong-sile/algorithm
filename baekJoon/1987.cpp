#include<iostream>
#include<string>
#include<vector>
#include<stack>
using namespace std;

int R, C;
vector<string> board;
int dy[4]={1,-1,0,0};
int dx[4]={0,0,1,-1};
bool alpha[26];

int dfs(){
	stack<pair<int,int>> S;
	S.push(make_pair(0,0));
	int y,x,ny,nx;
	bool isProgress=false;
	//int runTime=1;
	int maxTime=1;
	
	while(!S.empty()){
		y=S.top().first;
		x=S.top().second;
		S.pop();
		
		for(int i=0;i<4;i++){
			ny=y+dy[i];
			nx=x+dx[i];
			
			if(ny<0 || ny==R || nx<0 || nx==C || alpha[board[ny][nx]-'A'])
				continue;
			
			isProgress=true;
			alpha[board[ny][nx]-'A']=true;
			S.push(make_pair(y,x));
			S.push(make_pair(ny,nx));
			cout << ny << " " << nx << endl;
			break;
		}
		
		if(!isProgress){
			alpha[board[y][x]-'A']=false;
		}
		isProgress=false;
		
		maxTime=(maxTime > S.size()) ? maxTime : S.size();
	}
	
	return maxTime;
}

int main(){
	string input;
	cin >> R >> C;
	
	for(int i=0;i<R;i++){
		cin >> input;
		board.push_back(input);
	}
	
	cout << dfs();
	
}

//시작시간 22:32
//1차 완성 22:50 segFault
//2차 완성 23:03 2%에서 시간초과 stop 23:07에 시작
//23:08 이 문제는 깊이 우선탐색이 더 낫다고 판단 동시진행시 방문한 문자가 체크 되지 않음
// 추후에 다시풀도록은 개뿔 23:12 시작
/*
int bfs(){
	queue<string> q;
	queue<pair<int,int>> posQ;
	int x, y, nx, ny;
	string cur="";
	int runTime=1;
	int qSize;
	bool isProgress=false;
	cur+=board[0][0];
	q.push(cur);
	posQ.push(make_pair(0,0));
	string temp;
	
	while(!q.empty()){
		qSize=q.size();
		
		for(int repeat=0;repeat<qSize;repeat++){
			y=posQ.front().first;
			x=posQ.front().second;
			posQ.pop();
			
			cur=q.front();
			q.pop();
			
			for(int i=0;i<4;i++){
				ny=y+dy[i];
				nx=x+dx[i];
				
				if(ny<0 || ny == R || nx<0 || nx ==C)
					continue;
				
				if(cur.find(board[ny][nx]) != string::npos)
					continue;
				
				temp=cur+board[ny][nx];
				q.push(temp);
				posQ.push(make_pair(ny,nx));
				
				isProgress=true;
			}
		}
		
		if(isProgress){
			isProgress=false;
			runTime+=1;
		}
	}
	
	return runTime;
}
*/