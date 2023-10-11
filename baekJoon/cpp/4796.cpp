#include<iostream>
#include<string>
using namespace std;

int main(){
	int L, P, V, count=1, ans;
	cin >> L >> P >> V;
	
	while(L!=0){
		ans=0;
		ans+=(V/P)*L;
		ans+=(V%P < L) ? V%P : L;
		cout << "Case " + to_string(count++)+": "+ to_string(ans) << '\n';
		cin >> L >> P >> V;
	}
}