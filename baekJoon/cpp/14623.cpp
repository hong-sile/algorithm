#include<iostream>
#include<string>
using namespace std;

unsigned long long int changeBin(string s){
	unsigned long long int ans=0;
	int bin=1;
	
	for(int i=s.length()-1;i>=0;i--){
		ans+=(s[i]-'0')*bin;
		bin*=2;
	}
	
	return ans;
}

int main(){
	unsigned long long int ans;
	unsigned long long int product=1;
	string s1, s2;
	string output="";
	cin >> s1 >> s2;
	
	
	ans=changeBin(s1)*changeBin(s2);
	
	while(ans!=0){
		output=(char)((ans%2)+'0')+output;
		ans=ans/2;
	}
	
	cout << output;
}