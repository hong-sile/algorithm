#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N, M;
int output[10000];

void printSequence(vector<int> v, int printSize, int max){
	if(printSize==M){
		for(int i=0;i<M;i++)
			cout << output[i] <<" ";
		cout <<"\n";
		return;
	}
	
	for(int i=0;i<N;i++){
		if(v[i]<max) continue;
		output[printSize]=v[i];
		printSequence(v,printSize+1,v[i]);
	}
	
}

int main(){
	cin >> N >> M;
	vector<int> v(N);
	
	for(int i=0;i<N;i++){
		cin >> v[i];
	}
	
	sort(v.begin(),v.end());
	
	printSequence(v,0,0);
}