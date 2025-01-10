#include <iostream>
#include <vector>
     
using namespace std;

int main(){
    int quant;
    cin >> quant;
    
    for (int i = 0; i < quant; ++i){
		int n, s, m;
		cin >> n;
		cin >> s;
		cin >> m;

		int k = 0;
		int j = 0;
		bool tomou = false;

		while (k < n){
			int l;
			cin >> l;

			if (!tomou && l - j >= s){
				tomou = true;
				cout << "YES" << endl;
			}

			cin >> j;
			++k;
		}

		if (!tomou && m - j >= s){
			tomou = true;
			cout << "YES" << endl;
		}

		if (!tomou){
			cout << "NO" << endl;
		}
		
    }
    
    return 0;
}
