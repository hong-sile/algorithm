#include<iostream>
#include<string>
#include<deque>
using namespace std;

void parsing(string input, deque<int> &dq){
	string temp="";
	int stringLength=input.length();
	
	for(int i=1;i<stringLength-1;i++){
		if(input[i]!=',')
			temp+=input[i];
		else{
			dq.push_back(stoi(temp));
			temp="";
		}
	}
	dq.push_back(stoi(temp));
}

int main(){
	int T,temp;
	bool isFront;
	string command;
	string input;
	int count;
	int commandSize;
	bool isErr;
	
	cin >> T;
	
	while(T--){
		deque<int> dq;
		isFront=true;
		isErr=false;
		cin >> command >> count >> input;
		
		if(input.length()>2)
			parsing(input,dq);
		
		commandSize=command.length();
		
		for(int i=0;i<commandSize;i++){
			if(command[i]=='R'){
				isFront=!isFront;
			}
			else{
				if(dq.empty()){
					cout << "error\n";
					isErr=true;
					break;
				}
				if(isFront)
					dq.pop_front();
				else
					dq.pop_back();
			}
		}
		
		if(!isErr){
			cout << "[";
			if(dq.size()==0){}
			else if(isFront){
				while(!dq.empty()){
					cout << dq.front();
					dq.pop_front();
					if(!dq.empty()) cout <<",";
				}
			}
			else {
				while(!dq.empty()){
					cout <<dq.back();
					dq.pop_back();
					if(!dq.empty()) cout <<",";
				}
			}
			cout <<"]\n";
		}
	}
}