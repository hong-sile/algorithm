#include<iostream>
#include<algorithm>
#include<cstdlib>
using namespace std;

int main(){
	int arr[4];
	int ans=0;
	
	cin >> arr[0] >> arr[1] >> arr[2] >> arr[3];
	sort(arr, arr+4);
	
	cout << abs((arr[3]+arr[0])-(arr[2]+arr[1]));
}