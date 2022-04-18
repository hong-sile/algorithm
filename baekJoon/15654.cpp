#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N, M;
int check[10000];
int output[10000];

void printSequence(vector<int> v, int printSize){
	if(printSize==M){
		for(int i=0;i<M;i++)
			cout << output[i] <<" ";
		cout <<"\n";
		return;
	}
	
	for(int i=0;i<N;i++){
		if(check[i]) continue;
		output[printSize]=v[i];
		
		check[i]=true;
		printSequence(v,printSize+1);
		check[i]=false;
	}
	
}

int main(){
	cin >> N >> M;
	vector<int> v(N);
	
	for(int i=0;i<N;i++){
		cin >> v[i];
	}
	
	sort(v.begin(),v.end());
	
	printSequence(v,0);
}