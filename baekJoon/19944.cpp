#include<iostream>
using namespace std;

int main(){
	int N, M;
	cin >> N >> M;
	
	if(3>M)
		cout <<"NEWBIE!";
	else if(N>=M && M>=3)
		cout <<"OLDBIE!";
	else
		cout << "TLE!";
}