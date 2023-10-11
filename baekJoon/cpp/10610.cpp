#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(){
	int check3=0;
	bool check0=false;
	string N;
	cin >> N;
	
	for(int i=0;i<N.length();i++){
		check3+=N[i]-'0';
		if(N[i]=='0')
			check0=true;
	}
	
	sort(N.begin(),N.end(),greater<char>());
	
	if(check3%3!=0)
		cout << "-1";
	else{
		if(check0){
			cout<<N;
		}
		else
			cout << "-1";
	}
}

/*

2 * 3 * 5

0 이거나 5

*/