#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main(){
	priority_queue<int> positiveN;
	vector<int> negativeN;
	bool isExistZero=false;
	int N;
	int ans=0;
	int temp;
	int num1=0, num2=0;
	cin >> N;
	
	for(int i=0;i<N;i++){
		cin >> temp;
		if(temp>0)
			positiveN.push(temp);
		else if(temp<0)
			negativeN.push_back(temp);
		else
			isExistZero=true;
	}
	
	while(!positiveN.empty()){
		if(num1==0){
			num1=positiveN.top();
			positiveN.pop();
		}
		else{
			num2=positiveN.top();
			positiveN.pop();
			if(num1!=1 && num2!=1){
				ans+=num1*num2;
			}
			else{
				ans=ans+num1+num2;
			}
			num1=0;
			num2=0;
		}
	}
	if(num1!=0){
		ans+=num1;
		num1=0;
	}
	
	sort(negativeN.rbegin(),negativeN.rend());
	
	if(negativeN.size()%2==0){
		for(auto negNum : negativeN){
			if(num1==0)
				num1=negNum;
			else{
				ans+=num1*negNum;
				num1=0;
			}
		}
	}
	else{
		int negativeNSize=negativeN.size();
		if(!isExistZero)
			ans+=negativeN[0];
		for(int i=1;i<negativeNSize;i++){
			if(num1==0)
				num1=negativeN[i];
			else{
				ans+=num1*negativeN[i];
				num1=0;
			}
		}
	}
	if(num1!=0){
		ans+=num1;
		num1=0;
	}
	
	cout << ans;
}