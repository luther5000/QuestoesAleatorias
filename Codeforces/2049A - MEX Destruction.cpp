#include <iostream>

using namespace std;

int main() {
	int n;
	cin >> n;
	
	for (int i = 0; i < n; ++i){
		int k = 0;
		int entrada, quant;
		
		cin >> quant;
		bool subArray = false;
		
		for (int j = 0; j < quant; ++j){
			cin >> entrada;
			
			if (entrada != 0 && !subArray){
				subArray = true;
				++k;
			}
			
			if (entrada == 0 && subArray){
				subArray = false;
			}
		}

		if (k <= 2)
			cout << k << endl;
		else 
			cout << 2 << endl;
	}
	return 0;
}
