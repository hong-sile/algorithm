#include<iostream>
using namespace std;

int N, K;
long long arr[201][201];


int main(){
	cin >> N >> K;
	
	for(int i=0;i<=N;i++) arr[1][i]=1;
	
	for(int i=2;i<=K;i++){
		for(int j=0;j<=N;j++){
			for(int a=0;a<=j;a++){
				arr[i][j]+=arr[i-1][a];
				arr[i][j]%=1000000000;
			}
		}
	}
	cout << arr[K][N];
}