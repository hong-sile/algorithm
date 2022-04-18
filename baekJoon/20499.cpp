#include<iostream>
using namespace std;

int main(){
	int K, D, A;
	scanf("%d/%d/%d",&K,&D,&A);
	
	if((K+A)<D || D==0)
		cout <<"hasu";
	else
		cout <<"gosu";
}