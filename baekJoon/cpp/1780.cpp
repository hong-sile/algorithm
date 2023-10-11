#include<iostream>
using namespace std;

int N;
int paper[2187][2187];

int one=0;
int zero=0;
int mOne=0;

void checkPaper(int y, int x, int size){
	int next=size/3;
	bool isOk=true;
	
	for(int i=y ; i<y+size ; i++)
		for(int j=x ; j<x+size ; j++){
			if(paper[i][j]!=paper[y][x]){
				isOk=false;
				break;
			}
		}

	if(isOk){
		switch(paper[y][x]){
			case -1 : 
				mOne+=1;
				break;
			case 0 :
				zero+=1;
				break;
			case 1 :
				one+=1;
		}
	}
	
	else{
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				checkPaper(y+next*i,x+next*j,next);
	}
}

int main(){
	cin >> N;
	
	for(int i=0;i<N;i++)
		for(int j=0;j<N;j++)
			cin >> paper[i][j];
	
	checkPaper(0,0,N);
	
	cout << mOne<<endl<<zero<<endl<<one;
}