#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main(){
	int N, L, temp, point, ans=0,startPoint;
	bool newStartFlag=true;
	cin >> N >> L;
	vector<int> floodingPoint;
	
	for(int i=0;i<N;i++){
		cin >> temp;
		floodingPoint.push_back(temp);
	}
	
	sort(floodingPoint.begin(),floodingPoint.end());
	
	startPoint=floodingPoint[0];
	
	for(auto point : floodingPoint){
		if(newStartFlag){
			startPoint=point;
			newStartFlag=false;
		}
		
		if(point-startPoint+1>L){
			ans+=1;
			startPoint=point;
		}
		else if(point-startPoint+1==L){
			ans+=1;
			newStartFlag=true;
		}
	}
	
	if(floodingPoint[N-1]-startPoint+1<L) ans+=1;
	cout << ans;
}


/*
gold 1 1 -> +8
gold 2 3 -> +7
gold 3 5 -> +6
gold 4 0 -> +5
gold 5 13 -> +4
sivler 1 18 -> +3
sivler 2 13 -> +2
sivler 3 27 -> +1
sivler 4 20 -> +0

*/
