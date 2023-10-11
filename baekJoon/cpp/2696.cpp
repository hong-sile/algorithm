#include<iostream>
#include<queue>
using namespace std;

int main(){
	int T;
	cin >> T;
	while(T--){
		priority_queue<int, vector<int>, greater<int>> maxHeap;
		priority_queue<int> minHeap;
		int M, input, outputSize;
		
		cin >> M;
		outputSize=(M%2==0) ? M/2 : M/2+1;
		printf("%d\n",outputSize);
		
		cin >> input;
		minHeap.push(input);
		cout << input << " ";
		
		for(int i=1;i<M;i++){
			cin >> input;
			if(i%2==0)
				minHeap.push(input);
			else
				maxHeap.push(input);
			
			if(minHeap.top()>maxHeap.top()){
				minHeap.push(maxHeap.top());
				maxHeap.push(minHeap.top());
				maxHeap.pop();
				minHeap.pop();
			}
			
			if(i%2==0)
				cout << minHeap.top() << " ";
		}
	}
}