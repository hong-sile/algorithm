#include<iostream>
#include<queue>
#include<cstdlib>
using namespace std;

struct compare{
	bool operator()(int a, int b){
		if(abs(a)!=abs(b)){
			return abs(a)>abs(b);
		}
		else{
			return a>b;
		}
	}
};

int main(){
	priority_queue<int,vector<int>,compare> q;
	int n, input;
	cin >> n;
	
	while(n--){
		cin >> input;
		if(input!=0)
			q.push(input);
		else{
			if(q.empty())
				cout << "0\n";
			else{
				cout << q.top() << "\n";
				q.pop();
			}
		}
	}
}