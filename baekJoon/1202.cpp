#include<iostream>
#include<vector>
#include<utility>
#include<algorithm>
#include<queue>
using namespace std;

priority_queue<int>heap;

int main(){
	int N, K,res=0;
	int temp1,temp2;
	int index=0;
	long long ans=0;
	cin >> N >> K;
	vector<pair<int,int>> jewel(N);
	vector<int> bagCapacity(K);
	
	for(int i=0;i<N;i++){
		scanf("%d %d", &temp1,&temp2);
		jewel[i]=make_pair(temp1,temp2);
	}
	
	for(int i=0;i<K;i++){
		scanf("%d", &bagCapacity[i]);
	}
	
	sort(jewel.begin(),jewel.end());
	sort(bagCapacity.begin(),bagCapacity.end());
	
	for(auto bag: bagCapacity){
		while(index<N && jewel[index].first <= bag)
			heap.push(jewel[index++].second);
		if(!heap.empty()){
			ans+=heap.top();
			heap.pop();
		}
	}
	
	cout << ans;
	
}