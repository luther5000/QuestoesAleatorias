    #include <iostream>
         
    using namespace std;
     
    int main(){
        int quant;
        cin >> quant;
        
        for (int i = 0; i < quant; ++i){
            int n;
            cin >> n;
            
            cout << n - 1 << endl;
        }
        
        return 0;
    }
