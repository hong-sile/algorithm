#include<iostream>
#include<map>
#include<string>
using namespace std;

int main(){
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int N,M;
	string site, passwd;
	map<string,string> dict;
	cin >> N >> M;
	
	for(int i=0;i<N;i++){
		cin >> site >> passwd;
		dict.insert(make_pair(site,passwd));
	}
	
	for(int i=0;i<M;i++){
		cin >> site;
		cout << dict.find(site)->second << "\n";
	}
}