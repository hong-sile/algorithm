#include<iostream>
#include<vector>
using namespace std;

int N,M;
int knowTruthNum;

int main(){
	int participatePartyNum;
	int temp;
	cin >> N >> M;
	cin >> knowTruthNum;
	
	vector<int> knowTruthMember(knowTruthNum);
	vector<vector<int>> participateParty(M);
	
	for(int i=0;i<knowTruthNum;i++)
		cin >> knowTruthNum[i];
	
	for(int i=0;i<M;i++){
		cin >> participatePartyNum;
		for(int j=0;j<participatePartyNum;j++){
			cin >> temp;
			participateParty[i].push_back(temp);
		}
	}
	
	
}