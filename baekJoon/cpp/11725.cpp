#include<iostream>
#include<queue>
#include<vector>
using namespace std;

int main(){
	int N;
	int first, second;
	int ans[100001]={0,};
	cin >> N;
	vector<vector<int>> Tree(N+1);
	int currentNode;
	queue<int> q;
	
	for(int i=0;i<N-1;i++){
		cin >> first >> second;
		Tree[first].push_back(second);
		Tree[second].push_back(first);
	}
	
	for(int i=0;i<Tree[1].size();i++){
		q.push(Tree[1][i]);
		ans[Tree[1][i]]=1;
	}
	
	while(!q.empty()){
		currentNode=q.front();
		q.pop();
		for(int i=0;i<Tree[currentNode].size();i++){
			if(ans[Tree[currentNode][i]]!=0) continue;
			q.push(Tree[currentNode][i]);
			ans[Tree[currentNode][i]]=currentNode;
		}
	}
	
	for(int i=2;i<=N;i++)
		cout << ans[i]<<'\n';
}