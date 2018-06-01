#include <cstdio>
#include <cstring>
#include <algorithm>
#include <iostream>

using namespace std;

int main() {
   string a = "\"\nbda\\\"\ndbd\\c\"\\\"c\\c\"";
   string b = "\\ab\nac\"\"add\n\"\nac\ndb\"";
   string c = "\nabbdbdd\\\\\"d\"c\\adc\"c";
   cout << c + b + b + c + c + a + c + b + c + b;
   cout << c + c + a + a + a + c + c + b + b + b;
   cout << b + a + c + b + c + c + b + b + a + c;
   cout << b + a + c + a + a + a + b + b + b + c;
   cout << b + a + b + a + c + c + c + b + c + a;
   cout << a + a + c + c + a + c + b + c + c + a;
   cout << b + b + b + b + c + a + c + b + a + a;
   cout << a + a + c + b + a + b + c + c + b + b;
   cout << c + b + a + a + c + b + a + a + c + b;
   cout << a + c + b + b + b + c + c + c + b + c;
   return 0;
}
