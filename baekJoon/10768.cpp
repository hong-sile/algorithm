#include<iostream>
using namespace std;

int main(){
    int month;
    int day;

    cin >> month >> day;
	
	if(month>2)
		cout << "After";
	else if (month<2)
		cout << "Before";
	else {
		if(day==18 && month==2)
			cout << "Special";
		else if(day>18)
			cout << "After";
		else
			cout << "Before";
	}
}