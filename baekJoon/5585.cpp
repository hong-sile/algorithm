#include <iostream>
using namespace std;

int main(){
	int ans=0;
	int money;
	cin >> money;
	money=1000-money;
	
	ans+=money/500;
	money=money%500;
	
    ans+=money/100;
    money=money%100;
	
	ans+=money/50;
    money=money%50;	
	
	ans+=money/10;
    money=money%10;
	
	ans+=money/5;
    money=money%5;
	ans+=money;
	
	cout << ans;
}