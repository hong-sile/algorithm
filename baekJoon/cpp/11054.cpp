#include<iostream>
#include<utility>
#include<cmath>
using namespace std;

int arr[1001][2];
int input[1001];
int N;

int main(){
	cin >> N;
	int temp;
	int ans=-1;
	
	for(int i=0;i<N;i++){
		cin >> input[i];
	}
	
	arr[0][0]=1;
	arr[0][1]=1;

	
	for(int i=1;i<N;i++){
		arr[i][0]=1;
		arr[i][1]=1;
		
		for(int j=0;j<i;j++){
			if(input[i] > input[j])
				arr[i][0]=max(arr[i][0],arr[j][0]+1);
			else if(input[i] < input[j]){
				arr[i][1]=max(arr[i][1],arr[j][1]+1);
				arr[i][1]=max(arr[i][1],arr[j][0]+1);
			}
		}
	}
	
	for(int i=0;i<N;i++){
		ans=max(arr[i][0],ans);
		ans=max(arr[i][1],ans);
	}
	cout << ans;
}