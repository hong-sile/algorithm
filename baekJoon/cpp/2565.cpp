#include<iostream>
#include<vector>
using namespace std;

int powerCodes[501];
int LIS[501];

int main(){
	int numPowerCode, maxCodes=0,first, second, max=0, ans;
	cin >> numPowerCode;
	
	for(int i=0;i<numPowerCode;i++){
		scanf("%d %d", &first, &second);
		powerCodes[first]=second;
		maxCodes=(maxCodes>second)?maxCodes:second;
	}
	
	for(int i=1;i<=maxCodes;i++){
		if(powerCodes[i]==0) continue;
		LIS[i]=1;
		for(int j=0;j<=maxCodes;j++){
			
			if(powerCodes[i]>powerCodes[j]){
				LIS[i]=(LIS[j]+1>LIS[i])?LIS[j]+1:LIS[i];
			}
		}
	}
	
	for(int i=1;i<=maxCodes;i++)
		max=(max>LIS[i])?max:LIS[i];
	
	cout << numPowerCode-max;
}