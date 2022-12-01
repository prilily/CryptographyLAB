# importing AES
from Crypto.Cipher import AES

# encryption key
key = b'C&F)H@McQfTjWnZr'

# create new instance of cipher
cipher = AES.new(key, AES.MODE_EAX)

# data to be encrypted
data = "What is the temprature".encode()

# nonce is a random value generated each time we instantiate the cipher using new()
nonce = cipher.nonce

# encrypt the data
ciphertext = cipher.encrypt(data)

# print the encrypted data
print("Cipher text:", ciphertext)

# generate new instance with the key and nonce same as encryption cipher
cipher = AES.new(key, AES.MODE_EAX, nonce=nonce)

# decrypt the data
plaintext = cipher.decrypt(ciphertext)
print("Plain text:", plaintext)
