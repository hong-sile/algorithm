#include<iostream>
#include<queue>
using namespace std;

int main(){
	int N, input;
	cin >> N;
	priority_queue<int, vector<int>, greater<int>> maxHeap; //오름차순정렬
	priority_queue<int> minHeap; //내림차순 정렬
	
	scanf("%d", &input);
	minHeap.push(input);
	printf("%d\n",input);
	
	for(int i=1;i<N;i++){
		scanf("%d", &input);
		
		if(minHeap.size()==maxHeap.size())
			minHeap.push(input);
		else
			maxHeap.push(input);
		
		if(minHeap.top()>maxHeap.top()){
			maxHeap.push(minHeap.top());
			minHeap.push(maxHeap.top());
			maxHeap.pop();
			minHeap.pop();
		}
		
		printf("%d\n", minHeap.top());
	}
}