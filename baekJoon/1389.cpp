#include<iostream>
#include<algorithm>
#include<climits>
using namespace std;

unsigned int friendShip[101][101];

int main(){
	int N,M,ans=0,ansValue=INT_MAX,temp;
	int first, second;
	cin >> N >> M;
	
	for(int i=1;i<=N;i++)
		for(int j=1;j<=N;j++)
			friendShip[i][j]=INT_MAX;
	
	for(int i=0;i<M;i++){
		cin >> first >> second;
		friendShip[first][second]=1;
		friendShip[second][first]=1;
	}
	
	for(int i=1;i<=N;i++){
		for(int j=1;j<=N;j++){
			for(int k=1;k<=N;k++){
				if(i==j || i==k) continue;
				friendShip[j][k]=min(friendShip[j][k],friendShip[j][i]+friendShip[i][k]);
			}
		}
	}
	
	for(int i=1;i<=N;i++){
		temp=0;
		for(int j=1;j<=N;j++){
			if(i==j) continue;
			temp+=friendShip[i][j];
		}
		if(temp<ansValue){
			ansValue=temp;
			ans=i;
		}
	}
	cout << ans;
}