#include <iostream>
#include <vector>
     
using namespace std;

int main(){
    int quant;
    cin >> quant;
    
    for (int i = 0; i < quant; ++i){
		int x, y, k;
		int num_x = 0;
		int num_y = 0;

		cin >> x;
		cin >> y;
		cin >> k;


		if (x % k == 0)
			num_x = x / k;
		else 
			num_x = (x / k) + 1;


		if (y % k == 0)
			num_y = y / k;
		else 
			num_y = (y / k) + 1;



		if (num_x <= num_y)
			cout << num_y * 2 << endl;
		else 
			cout << num_x * 2 - 1 << endl;

    }
    
    return 0;
}
