#include<iostream>
#include<vector>
using namespace std;

int inputArr[1000002];
int lengthOfSequence[1000002];
int maxLength=1;

void updateSL(int num){
	int left=0;
	int right=maxLength;
	int middle=(right+left)/2;
	
	if(lengthOfSequence[maxLength]<num){
		lengthOfSequence[maxLength+1]=num;
		maxLength+=1;
		return;
	}
	
	while(left<right){
		if(num<lengthOfSequence[middle]){
			right=middle-1;
		}
		else if(num > lengthOfSequence[middle]){
			left=middle+1;
		}
		else{
			return;
		}
		middle=(right+left)/2;	
	}
	
	if(lengthOfSequence[left]>num)
		lengthOfSequence[left]=num;
}

int main(){
	int arraySize, max=0;
	scanf("%d", &arraySize);
	for(int i=1;i<=arraySize;i++)
		scanf("%d",&inputArr[i]);
	
	lengthOfSequence[0]=inputArr[1];
	
	for(int i=2;i<=arraySize;i++){
		updateSL(inputArr[i]);
	}
	
	for(int i=0;i<=maxLength;i++)
		cout << lengthOfSequence[i] << " ";
	
	//cout << maxLength;
}