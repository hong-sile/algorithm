#include<iostream>
#include<queue>
#include<utility>
#include<string>
using namespace std;

bool checkNum[10001];

string bfs(int src, int dst){
	queue<pair<int,string>> q;
	q.push(make_pair(src,""));
	pair<int,string> current;
	int checkD,checkS,checkL,checkR;
	checkNum[src]=true;
	
	for(int i=0;i<=10000;i++)
		checkNum[i]=false;
	
	while(!q.empty()){
		current=q.front();
		q.pop();
		
		checkD=current.first*2%10000;
		if(checkD==dst)
			return current.second+"D";
		if(!checkNum[checkD]){
			q.push(make_pair(checkD,current.second+"D"));
			checkNum[checkD]=true;
		}
		
		checkS=(current.first!=0)?current.first-1:9999;
		if(checkS==dst)
			return current.second+"S";
		if(!checkNum[checkS]){
			q.push(make_pair(checkS,current.second+"S"));
			checkNum[checkS]=true;
		}
		
		checkL=current.first/1000+(current.first%1000*10);
		if(checkL==dst)
			return current.second+"L";
		if(!checkNum[checkL]){
			q.push(make_pair(checkL,current.second+"L"));
			checkNum[checkL]=true;
		}
		
		checkR=current.first%10*1000+(current.first/10);
		if(checkR==dst)
			return current.second+"R";
		if(!checkNum[checkR]){
			q.push(make_pair(checkR,current.second+"R"));
			checkNum[checkR]=true;
		}
	}
}

int main(){
	int T;
	scanf("%d",&T);
	
	while(T--){
		int A, B, cnt=0;
		scanf("%d %d", &A, &B);
		cout << bfs(A,B)<<"\n";
	}
}