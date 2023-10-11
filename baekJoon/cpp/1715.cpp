#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

priority_queue<int,vector<int>,greater<int>> card;


int main() {
	int N;
	int temp;
	int ans=0;
	
	cin >> N;
	
	for(int i=0;i<N;i++){
		cin >> temp;
		card.push(temp);
	}
	
	while(card.size()!=1){
		temp=0;
		temp+=card.top();
		card.pop();
		temp+=card.top();
		card.pop();
		card.push(temp);
		ans+=temp;
	}

	cout << ans;
}