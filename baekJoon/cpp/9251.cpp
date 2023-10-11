#include<iostream>
#include<string>
#include<cmath>
using namespace std;

string input1;
string input2;
int dp[1001][1001];

int main(){
	int inputLength1;
	int inputLength2;
	int ans=-1;
	cin >> input1 >> input2;
	
	inputLength1=input1.length();
	inputLength2=input2.length();
	
	for(int i=1;i<=inputLength1;i++){
		for(int j=1;j<=inputLength2;j++){
			if(input1[i-1]==input2[j-1])
				dp[i][j]=max(dp[i][j],dp[i-1][j-1]+1);
			else
				dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
		}
	}
	
	for(int i=1;i<=inputLength1;i++)
		for(int j=1;j<=inputLength2;j++)
			ans=max(ans,dp[i][j]);
	
	cout << ans;
}