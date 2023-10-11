#include<iostream>
#include<string>
using namespace std;

int main(){
	int a, b, temp, ans;
	cin >> a >> b;
	ans=0;
	temp=b;
	
	while(a<temp){
		if(temp%2==0)
			temp=temp/2;
		else{
			if(temp%10 != 1){
				cout << "-1";
				return 0;
			}
			else{
				temp=temp/10;
			}
		}
		ans+=1;
	}
	
	if(a==temp)
		cout << ans+1;
	else
		cout << "-1";
}