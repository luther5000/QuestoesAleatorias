#include <iostream>
#include <vector>
         
using namespace std;
     
int main(){
  int quant;
  cin >> quant;
        
  for (int i = 0; i < quant; ++i){
    int a1, a2, b1, b2;
    cin >> a1;
    cin >> a2;
    cin >> b1;
    cin >> b2;
     
    int cont = 0;
     
    if (a1 > b1 && a2 > b2)
      cont += 2;
     
    if (a1 > b2 && a2 > b1)
      cont += 2;
     
    if (a1 > b1 && a2 == b2)
      cont += 2;
     
    if (a2 > b2 && a1 == b1)
    	cont += 2;
     
    if (a1 > b2 && a2 == b1)
    	cont += 2;	
     
    if (a2 > b1 && a1 == b2)
    	cont += 2;	
    		
    		
    cout << cont << endl;
     
    }
        
  return 0;
}
