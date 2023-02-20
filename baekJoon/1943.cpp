#include <iostream>
using namespace std;

int gcd(int a, int b) {
	int r = a % b;
	if (r == 0) {
		return b;
	}
	else {
		return gcd(b, r);
	}
}

int main() {
	int T;
	int A, B;
	int lcd;

	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> A >> B;
		lcd = (A * B) / (gcd(A, B));
		cout << lcd << "\n";
	}

	return 0;
}