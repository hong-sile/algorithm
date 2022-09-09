#include<iostream>
#include<string>
#define endl '\n';
using namespace std;

int main(){
	string s;
	cin >> s;
	int cnt;
	int length = s.length();
	
	for(int i=0;i<26;i++){
		cnt =0;
		for(int j=0;j<length;j++){
			if(s.at(j)=='a'+i){
				cnt+=1;
			}
		}
		cout << cnt << ' ';
	}
}