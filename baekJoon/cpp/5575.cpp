#include<iostream>
using namespace std;

typedef struct Time{
	int hour=0;
	int min=0;
	int sec=0;
}Time;

Time timeCalculator(Time startTime, Time endTime) {
	Time ans;
	ans.sec+=endTime.sec-startTime.sec;
	
	if(ans.sec<0){
		ans.sec+=60;
		ans.min-=1;
	}
	
	ans.min+=endTime.min-startTime.min;
	
	if(ans.min<0){
		ans.min+=60;
		ans.hour-=1;
	}
	
	ans.hour+=endTime.hour-startTime.hour;
	
	return ans;
}

int main(){
	Time startTime[3];
	Time endTime[3];
	
	for(int i = 0; i < 3; i++) {
		cin >> startTime[i].hour >> startTime[i].min >> startTime[i].sec;
		cin >> endTime[i].hour >> endTime[i].min >> endTime[i].sec;
	}
	
	for(int i = 0; i < 3; i++) {
		Time workTime =  timeCalculator(startTime[i],endTime[i]);
		cout << workTime.hour << " " <<workTime.min  <<" "<< workTime.sec<<endl;
	}
}