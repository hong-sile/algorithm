#include<iostream>
using namespace std;

long long int input[100001];
long long int sum[100001];

int main(){
	int N, M, first,second;
	scanf("%d %d",&N,&M);
	
	for(int i=1;i<=N;i++){
		scanf("%lld",&input[i]);
		sum[i]=sum[i-1]+input[i];
	}
	
	while(M--){
		scanf("%d %d",&first, &second);
		printf("%lld\n",sum[second]-sum[first-1]);
	}
}