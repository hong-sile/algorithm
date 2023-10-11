#include<iostream>
using namespace std;

int S[13];
bool check[13];
int k;
int ans[6];

void recusiveF(int size){
	if(size == 6){
		for(int i=0;i<5;i++)
			if(ans[i]>ans[i+1]) return;
		
		for(int i=0;i<6;i++)
			cout << ans[i]<<" ";
		cout << '\n';
		return;
	}
	
	for(int i=0;i<k;i++){
		if(check[i]) continue;
		ans[size]=S[i];
		check[i]=true;
		recusiveF(size+1);
		check[i]=false;
	}
}

int main(){
	cin >> k;
	while(k!=0){
		for(int i=0;i<k;i++) cin >> S[i];
		
		recusiveF(0);
		cout <<'\n';
		cin >> k;
	}
}