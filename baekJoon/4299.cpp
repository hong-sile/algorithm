#include<iostream>
#include<cmath>
using namespace std;

int main(){
	double A, B;
	double scoreA, scoreB;
	cin >> A >> B;
	
	scoreA=(A+B)/2;
	scoreB=(A-B)/2;
	
	if(ceil(scoreA)-scoreA!=0 || ceil(scoreB)-scoreB!=0 || A < B){
		cout << "-1";
	}
	else{
		cout << scoreA <<" "<< scoreB;
	}
}