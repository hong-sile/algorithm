#include<iostream>
#include<string>
using namespace std;

int main(){
	string input;
	
	cin >> input;
	
	
	if(input.length()==4) cout << "20";
	else if(input.find('0')!=string::npos){
		if(input.find('0')==1)
			cout << 10+input[2]-'0';
		else
			cout << 10+input[0]-'0';
	}
	else cout << input[0]+input[1]-'0'-'0';
}