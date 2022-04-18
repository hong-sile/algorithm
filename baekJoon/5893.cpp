#include<iostream>
#include<string>
using namespace std;

int main(){
	string input;
	string temp;
	
	cin >> input;
	temp=input+"0000";

	cout << stoull(temp)+stoull(input);
}