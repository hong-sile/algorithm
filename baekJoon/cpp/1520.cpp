#include<iostream>
#include<stack>
#include<utility>
using namespace std;

int M,N;
int map[500][500];
unsigned long long int ans[500][500];
int dy[4]={1,0,-1,0};
int dx[4]={0,1,0,-1};

int main(){
	stack<pair<int,int>> S;
	cin >> M >> N;
	int y,x,ny,nx;
	bool changeAnswer=false;
	int T;
	
	for(int i=0;i<M;i++)
		for(int j=0;j<N;j++){
			scanf("%d",&map[i][j]);
			ans[i][j]=0;
		}
	
	ans[M-1][N-1]=1;
	
	S.push(make_pair(M-1,N-1));
	
	while(!S.empty()){
		y=S.top().first;
		x=S.top().second;
		S.pop();
		
		for(T=0;T<4;T++){
			ny=y+dy[T];
			nx=x+dx[T];
			
			if(ny<0 || ny==M || nx<0 || nx==N || map[ny][nx] <= map[y][x])
				continue;
			
			//if(map[ny][nx] < map[y][x] || ans[])
			
			ans[ny][nx]+=ans[y][x];
			cout << y << " " << x<< " " << ny << " " << nx <<endl;
			S.push(make_pair(ny,nx));
			
	
			for(int i=0;i<M;i++){
				for(int j=0;j<N;j++)
					cout << ans[i][j]<<" ";
				cout << endl;
			}
			cout << endl;
		}
	}
	//cout << ans[0][0];
}

//22:15 시작
//22:27~31 화장실 이슈
//22:31재개
//종료 후 복귀할때 어떻게 구현해야하나?
//dfs를 구현하는 것을 조금 연습해보자 너무 bfs만 했다.
//dfs는 재귀가 낫나..?
//22:54 제출했으나 16%에서 시간초과
//22:54 관련게시글 보고 DP가 필요하다는 것을 인지
// 씨바 도대체 어떻게 해 ㅜ
//새로운 1차 시도 거꾸로 탐색하면서 ans배열을 만든 후 그배열의 값에 가능한 경로 탐색
//개터짐 내일 다시풀어보기
