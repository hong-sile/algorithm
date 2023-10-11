#include<iostream>
using namespace std;

int main(){
	int T;
	int N, M;

	cin >> T;

	while(T--){
		cin >> N >> M;
		int bridge = 1;
		for(int i = 0; i < N; i++){
			bridge= bridge*(M-i);
			bridge= bridge/(1+i);
		}
		cout << bridge << "\n";
	}
}