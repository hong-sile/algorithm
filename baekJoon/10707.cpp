#include<iostream>
using namespace std;

int main(){
	int A,B,C,D,P;
	int XOil;
	int YOil;
	cin >> A >> B >> C >> D >> P;
	
	XOil=A*P;
	if(P <= C) YOil=B;
	else{
		YOil=B+(P-C)*D;
	}
	
	int ans = (XOil<YOil) ? XOil : YOil;
	
	cout << ans;
}