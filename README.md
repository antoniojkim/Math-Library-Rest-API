# Math Libary Rest API
Public Rest API for my [Math Evaluation Library](https://github.com/antoniok9130/Math-Evaluation-Library)

All math is being evaluated using the [Math Evaluation Library](https://github.com/antoniok9130/Math-Evaluation-Library)

## Documentation
### Input to Expression
#### Request Mapping
```
http://math-rest-api-jhk.appspot.com/expression
```
#### GET Request Parameter

<details>
  <summary>Request URL</summary>
    
```
http://math-rest-api-jhk.appspot.com/expression?input=<Math Input>
```
</details>

#### POST Request Body (Ajax)
<details>
  <summary>JQuery Ajax Request Code</summary>
    
```
$.ajax({
    url:"http://math-rest-api-jhk.appspot.com/expression",
    type:"POST",
    
    contentType: "application/json; charset=utf-8"
    async: false, 
    cache: false,
    processData:false,
    
    data: JSON.stringify({"input":<Math Input>}),
    
    success: function(data){ ... },
    error: function(request, status, error){ ... }
});
```
</details>

#### Sample Output

<details>
  <summary>JSON Response</summary>
    
```
{
    "input":"sin(π/6)",
    "output":{
        "valid":true,
        "numbers":[
            3.141592653589793,
            6.0
        ],
        "integer":false,
        "numberExpression":false,
        "postfix":"π 6 / sin",
        "tex":"\\sin\\left(\\dfrac{\\pi}{6}\\right)",
        "infix":"sin(π/6)",
        "rational":false,
        "value":0.5
    }
}
```
</details>

### Evaluate Expression
#### Request Mapping
```
http://math-rest-api-jhk.appspot.com/expression/evaluate
```
#### GET Request Parameter

<details>
  <summary>Request URL</summary>
    
```
http://math-rest-api-jhk.appspot.com/expression/evaluate?input=<Math Input>
```
</details>

#### POST Request Body (Ajax)
<details>
  <summary>JQuery Ajax Request Code</summary>
    
```
$.ajax({
    url:"http://math-rest-api-jhk.appspot.com/expression/evaluate",
    type:"POST",
    
    contentType: "application/json; charset=utf-8"
    async: false, 
    cache: false,
    processData:false,
    
    data: JSON.stringify({"input":<Math Input>}),
    
    success: function(data){ ... },
    error: function(request, status, error){ ... }
});
```
</details>

#### Sample Output

<details>
  <summary>JSON Response</summary>
    
```
{
    "input":"sin(π/6)",
    "output":{
        "valid":true,
        "numbers":[0.5],
        "integer":false,
        "numberExpression":true,
        "postfix":"0.5",
        "tex":"0.5",
        "infix":"0.5",
        "rational":false,
        "value":0.5
    }
}
```
</details>


### Simplify Expression
#### Request Mapping
```
http://math-rest-api-jhk.appspot.com/expression/simplify
```
#### GET Request Parameter

<details>
  <summary>Request URL</summary>
    
```
http://math-rest-api-jhk.appspot.com/expression/simplify?input=<Math Input>
```
</details>

#### POST Request Body (Ajax)
<details>
  <summary>JQuery Ajax Request Code</summary>
    
```
$.ajax({
    url:"http://math-rest-api-jhk.appspot.com/expression/simplify",
    type:"POST",
    
    contentType: "application/json; charset=utf-8"
    async: false, 
    cache: false,
    processData:false,
    
    data: JSON.stringify({"input":<Math Input>}),
    
    success: function(data){ ... },
    error: function(request, status, error){ ... }
});
```
</details>

#### Sample Output

<details>
  <summary>JSON Response</summary>
    
```
{
    "input":"sinx/cosx",
    "output":{
        "valid":true,
        "numbers":[],
        "integer":false,
        "numberExpression":false,
        "postfix":"x tan",
        "tex":"\\tan\\left(x\\right)",
        "infix":"tan(x)",
        "rational":false,
        "value":"NaN"
    }
}
```
</details>



### Fraction Expression
#### Request Mapping
```
http://math-rest-api-jhk.appspot.com/expression/fraction
```
#### GET Request Parameter

<details>
  <summary>Request URL</summary>
    
```
http://math-rest-api-jhk.appspot.com/expression/fraction?input=<Math Input>
```
</details>

#### POST Request Body (Ajax)
<details>
  <summary>JQuery Ajax Request Code</summary>
    
```
$.ajax({
    url:"http://math-rest-api-jhk.appspot.com/expression/fraction",
    type:"POST",
    
    contentType: "application/json; charset=utf-8"
    async: false, 
    cache: false,
    processData:false,
    
    data: JSON.stringify({"input":<Math Input>}),
    
    success: function(data){ ... },
    error: function(request, status, error){ ... }
});
```
</details>

#### Sample Output

<details>
  <summary>JSON Response</summary>
    
```
{
    "input":"sin(π/6)",
    "output":{
        "valid":true,
        "rational":true,
        "numbers":[
            1.0,
            2.0
        ],
        "integer":false,
        "numberExpression":false,
        "postfix":"1 2 /",
        "tex":"\\dfrac{1}{2}",
        "infix":"1/2",
        "value":0.5
    }
}
```
</details>


### Value of Expression
#### Request Mapping
```
http://math-rest-api-jhk.appspot.com/expression/valueOf
```
#### GET Request Parameter

<details>
  <summary>Request URL</summary>
    
```
http://math-rest-api-jhk.appspot.com/expression/valueOf?input=<Math Input>
```
</details>

#### POST Request Body (Ajax)
<details>
  <summary>JQuery Ajax Request Code</summary>
    
```
$.ajax({
    url:"http://math-rest-api-jhk.appspot.com/expression/valueOf",
    type:"POST",
    
    contentType: "application/json; charset=utf-8"
    async: false, 
    cache: false,
    processData:false,
    
    data: JSON.stringify({"input":<Math Input>}),
    
    success: function(data){ ... },
    error: function(request, status, error){ ... }
});
```
</details>

#### Sample Output

<details>
  <summary>JSON Response</summary>
    
```
{
    "input":"sin(π/6)",
    "output":{
        "value":0.5
    }
}
```
</details>
