#include <iostream>
#include <vector>
     
using namespace std;

int main(){
    int quant;
    cin >> quant;
    
    for (int i = 0; i < quant; ++i){
		int a, b, c, menor;
		
		cin >> a;
		cin >> b;
		
		c = a;
		menor = 100000;
		while (c <= b){
			if ((c - a) + (b - c) < menor){
				menor = (c - a) + (b - c);
			}

			++c;
		}

		cout << menor << endl;

    }
    
    return 0;
}
