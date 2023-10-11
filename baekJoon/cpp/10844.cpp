#include<iostream>
using namespace std;


int main(){
	int n;
	long long ans=0;
	long long dp[101][10];
	
	dp[1][0]=0;
	for(int i=1;i<=9;i++){
		dp[1][i]=1;
	}
	
	cin >> n;
	
	//구현부
	for(int i=2;i<=n;i++){
		for(int j=0;j<=9;j++){
			if(j==0)
				dp[i][j]=dp[i-1][1];
			else if(j==9)
				dp[i][j]=dp[i-1][8];
			else
				dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1]) % 1000000000;
		}
	}
	
	
	for(int i=0;i<=9;i++){
		ans+=dp[n][i];
		ans%=1000000000;
	}
	
	cout << ans;
}
