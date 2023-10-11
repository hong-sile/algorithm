#include<iostream>
using namespace std;

int main(){
	int S, K, H;
	int min;
	cin >> S >> K >> H;
	
	min=S;
	
	if(S+K+H>=100)
		cout << "OK";
	else{
		min = (min < K) ? min : K;
		min = (min < H) ? min : H;
		
		if(min==S)
			cout << "Soongsil";
		else if(min==K)
			cout << "Korea";
		else
			cout << "Hanyang";
	}
}