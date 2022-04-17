#include <iostream>
#include <limits.h>
using namespace std;

int N;
long long distanceA[100000];
long long oilSupply[100000];

int main(){
	cin >> N;
	int min;
	long long cost=0;
	
	for(int i=0;i<N-1;i++)
		cin >> distanceA[i];
	for(int i=0;i<N-1;i++)
		cin >> oilSupply[i];
	
	min=oilSupply[0];
	
	for(int i=0;i<N-1;i++){
		min=(min < oilSupply[i]) ? min : oilSupply[i];
		cost+=min*distanceA[i];
	}
	
	cout << cost;
}