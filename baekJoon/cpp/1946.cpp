#include <iostream>
#include <utility>
#include <limits.h>
#include <algorithm>
using namespace std;

int T;

bool compare(const pair<int,int> & p1, const pair<int,int> &p2){
	return p1.first < p2.first;
}

int main(){
	int N;
	
	cin >> T;
	
	while(T--){
		cin >> N;
		pair<int,int> appliciant[100000];
		int minScore=INT_MAX;
		int ans=0;
		
		for(int i=0;i<N;i++)
			cin >> appliciant[i].first >> appliciant[i].second;
		
		sort(appliciant,appliciant+N, compare);
		
		for(int i=0;i<N;i++){
			if(minScore < appliciant[i].second){
				continue;
			}
			else{
				ans+=1;
				minScore=appliciant[i].second;
			}
		}
		cout << ans << endl;
	}
}