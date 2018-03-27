# Encryption-Rest-API
Public Rest API for my [Encryption Library](https://github.com/antoniok9130/Encryption-Library)

All encrypting, decrypting, and hashing is done using the ByteEncryption algorithm found in my [Encryption Library](https://github.com/antoniok9130/Encryption-Library)

## Documentation
### Generate Private Key

```
https://encryption-rest-api-jhk.appspot.com/generate/key
https://encryption-rest-api-jhk.appspot.com/generate/key?length=<integer>
```

Params: length (Integer)

Request Method:   [GET](https://encryption-rest-api-jhk.appspot.com/generate/key)

This generates a hex private key of twice the specified length (default 64) that can be used in other API requests.
 
Returns: **JSON**

E.g.

`{"key":"E23D8925935EAA5A02D90ED22B4890297A6FE11552D0D498E707182E749BB05DFB886E8EA9B782955A9C0CBC4439A23402764CD8D46B0C9538711EAFB1C25EAE","message":"Generated Private Key"}`

### Generate KeyStore

```
https://encryption-rest-api-jhk.appspot.com/generate/keystore
https://encryption-rest-api-jhk.appspot.com/generate/keystore?scrambler=<string>
```

Params: scrambler (String)

Request Method:   [GET](https://encryption-rest-api-jhk.appspot.com/generate/keystore)

This generates a keystore that can be used in the ByteEncryption algorithm.
 
Returns: **JSON**


### Encrypt a string

```
https://encryption-rest-api-jhk.appspot.com/encrypt?string=<text>
https://encryption-rest-api-jhk.appspot.com/encrypt?string=<text>&key=<private-key>
```

Params: **string** (String), **key** (String)

Request Method:   [GET](https://encryption-rest-api-jhk.appspot.com/encrypt?string=<text>&key=<private-key>)

This encrypts the *string* parameter using the *key* parameter. If a key is not provided, the default key will be used.

Returns: **JSON**

E.g. 

`{"text":"example","encrypted":"F05285358D32726358A1072AC667B789976384D3EEA91F77A94EF4652CFC74AB"}`



### Decrypt a string

```
https://encryption-rest-api-jhk.appspot.com/decrypt?string=<text>
https://encryption-rest-api-jhk.appspot.com/decrypt?string=<text>&key=<private-key>
```

Params: **string** (String), **key** (String)

Request Method:   [GET](https://encryption-rest-api-jhk.appspot.com/decrypt?string=<text>&key=<private-key>)

This decrypts the *string* parameter using the *key* parameter. If a key is not provided, the default key will be used.

Returns: **JSON**

E.g.

`{"text":"F05285358D32726358A1072AC667B789976384D3EEA91F77A94EF4652CFC74AB","decrypted":"example"}`

### Hash a string

```
https://encryption-rest-api-jhk.appspot.com/hash?string=<text>
https://encryption-rest-api-jhk.appspot.com/hash?string=<text>&key=<private-key>
```

Params: **string** (String), **key** (String)

Returns: **JSON**

Request Method:   [GET](https://encryption-rest-api-jhk.appspot.com/hash?string=<text>&key=<private-key>)

This hashes the *string* parameter using the *key* parameter. If a key is not provided, the default key will be used.

Returns: **JSON**

E.g.

`{"text":"example","hash":"BC1F3DC1F9D98985F5B47C1C97DB8F697CF8303F8E2D840AD0DDF25B46F343AAD0DDF25B46F343AAD0DDF25B46F343AAD0DDF25B46F343AAD0DDF25B46F343AA"}`
 
