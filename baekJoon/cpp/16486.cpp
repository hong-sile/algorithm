#include<iostream>
#define PI 3.141592;
using namespace std;

int main(){
	int d1, d2;
	double ans;
	
	cin >> d1 >> d2;
	
	ans=2*d1+d2*2*PI;
	printf("%.6lf",ans);
}