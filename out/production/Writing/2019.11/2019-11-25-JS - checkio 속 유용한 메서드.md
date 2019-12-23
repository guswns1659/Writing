## str
replace(arg1, arg2), chatAt(index), endsWith(), startsWith() includes(), indexOf(), toLowerCase(), toUpperCase()

## array
* endsWith(), startsWith(), includes(),  indexOf()
* splice() 배열 원소 삭제할 때!

## isNaN()

## sort() 이용해서 객체나 정수 배열 내림, 오름차순 만들기
```javascript
// 배열에 담긴 상품(객체)의 가격 중 큰 것을 limit만큼 출력

function  biggerPrice(limit, data) {

const  answer  = [];

data.sort(function(a, b){

return  b.price  -  a.price;

})

for(let  i  =0; i<limit; i++){

answer.push(data[i]);

}

return  answer;

}
```
