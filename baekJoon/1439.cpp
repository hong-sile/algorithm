#include<iostream>
#include<string>
using namespace std;

int main(){
	string N;
	int cnt=0;
	char previousValue;

	cin >> N;
	previousValue=N[0];
	
	for(int i=1;i<N.length();i++){
		if(N[i]== previousValue)
			continue;
		cnt+=1;
		previousValue=N[i];
	}
	if(cnt%2==0)
		cout << cnt/2;
	else
		cout << cnt/2+1;
}