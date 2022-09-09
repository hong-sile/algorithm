#include<iostream>
#define endl "\n"
using namespace std;

int canMakeValue[10001];

int main(){
	int N, K;
	int coins[101];
	
	canMakeValue[0]=1;
	scanf("%d %d", &N ,&K);
	
	for(int i=0;i<N;i++){
		scanf("%d", &coins[i]);
	}
	
	for(int i=0;i<N;i++){
		for(int j=coins[i];j<=K;j++){
			canMakeValue[j]+=canMakeValue[j-coins[i]];
		}
	}
	
	printf("%d", canMakeValue[K]);
}