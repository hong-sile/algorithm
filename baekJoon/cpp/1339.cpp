#include <iostream>
#include <map>
#include <utility>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

map<char,int> alphaValue;
int N;
string input[10];
map<char,int> alpha[8];

bool cmp(pair<char, int>& a, pair<char,int>& b){
	return a.second > b.second;
}

void sortMap(const map<char,int>& data){
	vector<pair<char,int>> vec;
	
	for(auto& it : data){
		vec.push_back(it);
	}
	
	sort(vec.begin(), vec.end(),cmp);
}

int main(){
	int lengthInput;
	cin >> N;
	int count=9;
	int temp;
	int ans=0;
	int expo=1;
	
	for(int i=0;i<N;i++){
		cin >> input[i];
		lengthInput=input[i].length();
		for(int j=0;j<lengthInput;j++){
			auto it = alpha[j].find(input[i].at(lengthInput-j-1));
			if(it==alpha[j].end()){
				alpha[j].insert(make_pair(input[i].at(lengthInput-j-1),1));
			}
			else{
				it->second+=1;
			}
		}
	}
	
	
	for(int i=0;i<8;i++){ //error occured?
		if(alpha[i].size()==0){
			continue;
		}
		sortMap(alpha[i]);
	}
	
	for(int i=7;i>=0;i--){
		if(alpha[i].size()==0) continue;
		for(auto it=alpha[i].begin();it!=alpha[i].end();it++){
			if(alphaValue.count(it->first)) continue;
			alphaValue.insert(make_pair(it->first,count--));
		}
	}
	
	for(int i=0;i<N;i++){
		temp = 0;
		expo = 1;
		lengthInput=input[i].length();
		for(int j=lengthInput-1;j>=0;j--){
			temp += alphaValue.find(input[i][j])->second * expo;
			expo=expo*10;
		}
		ans+=temp;
	}
	
	cout << ans;
}



//somebody help please.....
//how can i 


/*
#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

char arr[10][10];
int len[10];
int alpha[26];

bool desc(int a, int b){ return a > b; }

int main(void){
    int n;
    int cal;
    int result = 0;

    scanf("%d", &n);
    for(int i=0; i<n; i++){
        scanf("%s", arr[i]);
        len[i] = strlen(arr[i]);
    }
    
    for(int i=0; i<n; i++){
        cal = 1;
        for(int j=len[i]-1; j>=0; j--){
            alpha[arr[i][j]-'A'] += cal;
            cal *= 10;
        }
    }
    
    sort(alpha, alpha+26, desc);
    
    for(int i=0; i<10; i++){
        result += alpha[i] * (9-i);
    }
    
    printf("%d\n", result);
}
*/