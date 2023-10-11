#include<iostream>
#define endl '\n';
using namespace std;

int main(){
	int N, temp;
	cin >> N;
	
	for(int i=0 ; i<2*N-1 ; i++){
		if(i>=N)
			temp=2*N-2-i;
		else
			temp=i;
		for(int j=0;j<=temp;j++){
			cout << '*';
		}
		cout << endl;
	}
}