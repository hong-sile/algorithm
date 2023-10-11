#include<iostream>
using namespace std;

int main(){
	int T;
	int ans[3];
	cin >> T;
	
	ans[0]=T/300;
	T=T%300;
	ans[1]=T/60;
	T=T%60;
	ans[2]=T/10;
	T=T%10;
	
	if(T!=0)
		cout << "-1";
	else 
		cout << ans[0] <<" "<<ans[1]<<" "<<ans[2];
}