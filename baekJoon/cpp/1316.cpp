#include<iostream>
#include<string>
using namespace std;

int ans;

int main(){
	int N;
	cin >> N;
	while(N--){
		bool arr[26];
		bool isGroupWord=true;
		string s;
		cin >> s;
		
		for(int i=0;i<26;i++)
			arr[i]=0;
		
		for(int i=0;i<s.length();i++){
			if(arr[s[i]-'a'] && s[i-1]!=s[i]){
				isGroupWord=false;
				break;
			}
			else
				arr[s[i]-'a']=true;
		}
		
		if(isGroupWord)
			ans+=1;
	}
	cout << ans;
}