#include<iostream>
#include<algorithm>
using namespace std;

int main(){
	int n, sum=1;
	int arr[1000];
	cin >> n;
	
	for(int i=0;i<n;i++){
		cin >> arr[i];
	}
	
	sort(arr,arr+n);
	
	if(arr[0]!=1)
		cout << 1;
	else{
		for(int i=1;i<n;i++){
			if(sum+2<=arr[i])
				break;
			sum+=arr[i];
		}
		cout <<sum+1;
	}
}