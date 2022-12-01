#include<bits/stdc++.h>
using namespace std;

void gen(string s,string &key){
    int x=s.size();
    for(int i=0;;i++){
        if(i==x)i=0;
        if(s.size()==key.size())break;
        key.push_back(key[i]);
    }
}

string enc(string s,string key){
    string ans;
    for(int i=0;i<s.size();i++){
        char x=(s[i]+key[i])%26;
        x+='A';
        ans.push_back(x);
    }
    return ans;
}

string dec(string enc,string key){
    string ans;
    for(int i=0;i<enc.size();i++){
        char x=(enc[i]-key[i]+26)%26;
        x+='A';
        ans.push_back(x);
    }
    return ans;
}

int main(){
    string plaintext,key;
    cout<<"Enter plain text as "<<endl;
    cin>>plaintext;
    cout<<"Enter key text as "<<endl;
    cin>>key;
    gen(plaintext,key);

    string cip=enc(plaintext,key);
    string pla=dec(cip,key);

    cout<<"The encrypted is      "<<cip<<endl;
    cout<<"The decrypted text is "<<pla<<endl;
    
}