#include<iostream>
#include<queue>
using namespace std;

int main(){
	priority_queue<int> rope;
	int temp;
	int N;
	int max=0;
	
	cin >> N;
	
	for(int i = 0; i < N; ++i){
		cin >> temp;
		rope.push(temp);
	}
	
	for(int i=1;i<=N;i++){
		temp=rope.top();
		rope.pop();
		max=(max > temp*i) ? max : temp*i;
	}
	cout << max;
}