#include<iostream>
#include<queue>
using namespace std;

bool check[101];
int map[101];

int main(){
	int ladder, snake, inputSize;
	queue<int> q;
	int count=0;
	int x, y;
	int current,size,nextPos;
	
	cin >> ladder >> snake;
	inputSize=ladder+snake;
	
	for(int i=0;i<inputSize;i++){
		cin >> x >> y;
		map[x]=y;
	}
	
	q.push(1);
	check[1]=true;
	while(!q.empty()){
		count+=1;
		size=q.size();
		
		for(int i=0;i<size;i++){
			current=q.front();
			q.pop();
			
			for(int j=1;j<=6;j++){
				nextPos=current+j;
				
				if(check[nextPos]) continue;
				check[nextPos]=true;
				
				nextPos=(map[nextPos]!=0)?map[nextPos]:nextPos;
				
				if(nextPos==100){
					cout << count;
					return 0;
				}
				
				q.push(nextPos);
			}
		}
	}
	
}