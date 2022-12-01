#include<bits/stdc++.h>
using namespace std;

string encrypt(string s,int key){
    string ans;
    for(int i=0;i<s.size();i++){
        if(s[i]==' ')ans+=" ";
        else if(isupper(s[i])){
            ans+=char(int(s[i]+key-65)%26+65);
        }
        else if(islower(s[i])){
            ans+=char(int(s[i]+key-97)%26+97);
        }
    }
    return ans;
}

int main(){
    string plaintext;
    cout<<"Enter plain text as ";
    getline(cin,plaintext);
    int key;
    cout<<"Enter key as ";
    cin>>key;
    string enc=encrypt(plaintext,key);
    string dec=encrypt(enc,26-key);
    cout<<"The encrypted is      "<<enc<<endl;
    cout<<"The decrypted text is "<<dec<<endl;
}