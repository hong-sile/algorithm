#include<iostream>
using namespace std;

int main() {
	int score[6];
	int ans=0;
	int min;
	
	for (int i = 0; i < 6; i++){
		cin >> score[i];
		ans+=score[i];
	}
	
	min=score[0];
	
	ans-=(score[4]<score[5]) ? score[4] : score[5];
	
	for(int i=1;i<4;i++)
		min=(min < score[i]) ? min : score[i];
	
	ans-=min;
	
	cout << ans;
}