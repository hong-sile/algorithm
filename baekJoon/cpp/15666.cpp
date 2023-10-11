#include<iostream>
#include<set>
#include<algorithm>
using namespace std;

int N, M;
int output[10000];

void printSequence(set<int> v, int printSize, int max){
	if(printSize==M){
		for(int i=0;i<M;i++)
			cout << output[i] <<" ";
		cout <<"\n";
		return;
	}
	
	for(auto it= v.begin();it!=v.end();it++){
		if(*it<max) continue;
		output[printSize]=*it;
		printSequence(v,printSize+1,*it);
	}
	
}

int main(){
	cin >> N >> M;
	int temp;
	set<int> v;
	
	for(int i=0;i<N;i++){
		cin >> temp;
		v.insert(temp);
	}
	
	printSequence(v,0,0);
}