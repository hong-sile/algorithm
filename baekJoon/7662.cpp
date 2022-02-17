#include<iostream>
#include<set>
using namespace std;

int main(){
	int T, K,input;
	cin >> T;
	char order;
	multiset<int>::iterator iter;
	
	while(T--){
		multiset<int>q;
		cin >> K;
		while(K--){
			cin >> order >> input;
			if(order=='I'){
				q.insert(input);
			}
			else{
				if(q.empty()) continue;
				if(input==-1)
					q.erase(q.begin());
				else{
					iter=q.end();
					iter--;
					q.erase(iter);
				}
			}
		}
		if(q.empty()) cout << "EMPTY"<<endl;
		else{
			iter=q.end();
			iter--;
			cout << *iter << " " << *q.begin() << endl;
		}
	}
}