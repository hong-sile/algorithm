#include <iostream>
using namespace std;

int main(){
	long long N;
	long long cnt=0;
	int minus=1;
	cin >> N;
	
	while(N-minus>=0){
		N-=minus++;
		cnt+=1;
	}
	cout << cnt;
}