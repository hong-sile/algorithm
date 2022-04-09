#include<iostream>
#include<string>
using namespace std;

int R;
int C;
char data[20][20];

void bfs(){
	
}

int main(){
	string input;
	cin >> R >> C;
	
	for(int i=0;i<R;i++){
		cin >> input;
		for(int j=0;j<C;j++)
			data[i][j]=input[j];
	}
	
	bfs();
}