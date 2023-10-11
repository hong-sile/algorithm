#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

char inputChar[26];
int L, C;

void dfs(int startPoint, int size, string password){
	if(size==L){
		int voewlCount=0;
		if(password.find("a") != string::npos)
			voewlCount+=1;
		if(password.find("e") != string::npos) 
			voewlCount+=1;
		if(password.find("i") != string::npos)
			voewlCount+=1;
		if(password.find("o") != string::npos)
			voewlCount+=1;
		if(password.find("u") != string::npos)
			voewlCount+=1;
		if(voewlCount>0 && size-voewlCount>1)
			cout << password << '\n';
	}
	else
		for(int i=startPoint;i<C;i++){
			dfs(i+1,size+1,password+=inputChar[i]);
			password.erase(size);
		}
}

int main(){
	string s="";
	cin >> L >> C;
	
	for(int i=0;i<C;i++)
		cin >> inputChar[i];
	
	sort(inputChar,inputChar+C);

	dfs(0,0,s);
}