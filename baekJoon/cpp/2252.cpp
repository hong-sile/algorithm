#include<iostream>
#include<queue>
#include<vector>
using namespace std;

int main(){
	int N, M, first,second;
	int nodeCount[32001]={0,};
	int currentNode;
	queue<int> q;
	vector<int> ans;
	
	cin >> N >> M;
	vector<vector<int>> nodeList(N+1);
	
	for(int i=0;i<M;i++){
		cin >> first >> second;
		nodeList[first].push_back(second);
		nodeCount[second]+=1;
	}
	
	for(int i=1;i<=N;i++){
		if(nodeCount[i]==0)
			q.push(i);
	}
	
	
	while(!q.empty()){
		currentNode=q.front();
		q.pop();
		cout << currentNode <<" ";
		
		for(int i=0;i<nodeList[currentNode].size();i++){
			nodeCount[nodeList[currentNode][i]]-=1;
			if(nodeCount[nodeList[currentNode][i]]==0)
				q.push(nodeList[currentNode][i]);
		}
		
	}
	
}