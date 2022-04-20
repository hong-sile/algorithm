#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N, M;
int output[10000];
bool check[8];

void printSequence(vector<int> v, int printSize){
	if(printSize==M){
		for(int i=0;i<M;i++)
			cout << output[i] <<" ";
		cout <<"\n";
		return;
	}
	int past=0;
	for(int i=0;i<N;i++){
		if(check[i]) continue;
		if(past==v[i]) continue;
		output[printSize]=v[i];
		past=v[i];
		check[i]=true;
		printSequence(v,printSize+1);
		check[i]=false;
	}
	
}

int main(){
	cin >> N >> M;
	int temp;
	vector<int> v;
	
	for(int i=0;i<N;i++){
		cin >> temp;
		v.push_back(temp);
	}
	
	sort(v.begin(),v.end());
	
	printSequence(v,0);
}