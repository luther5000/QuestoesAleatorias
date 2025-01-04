#include <iostream>
#include <string>
     
using namespace std;

int main(){
    int quant;
    cin >> quant;
    
    for (int i = 0; i < quant; ++i){
		int m, a, b, c;
		cin >> m;
		cin >> a;
		cin >> b;
		cin >> c;

		int capacidade1 = 0;
		int capacidade2 = 0;
		
		if (a <= m)
			capacidade1 += a;
		else 
			capacidade1 += m;
		
		
		if (capacidade1 < m){
			if (capacidade1 + c <= m){
				capacidade1 += c;
				c = 0;
			} else {
				c -= m - capacidade1;
				capacidade1 = m;
			}
		}

		if (b <= m)
			capacidade2 += b;
		else 
			capacidade2 += m;

		if (c != 0 && capacidade2 < m){
			if (capacidade2 + c <= m){
				capacidade2 += c;
				c = 0;
			} else {
				c -= m - capacidade2;
				capacidade2 = m;
			}
		}

		cout << capacidade1 + capacidade2 << endl;
    }
    
    return 0;
}
