function solution(X, Y) {
    x = X.split("").sort((a,b) => b-a)
    y = Y.split("").sort((a,b) => b-a)
    console.log(x, y)
    
    let i=0
    let j=0
    let result = []
    while(true){
        if(x[i] === y[j]){
            result.push(x[i])
            i++
            j++
        } else if(x[i] < y[j]){
            j++
        } else {
            i++
        }
        
        if(i>x.length-1 || j>y.length-1){
            break
        }
    }
    
    if(result.length === 0){
        result = "-1"
    } else if(parseInt(result.join("")) === 0){
        result = "0"
    } else {
        result = result.join("")
    }
    
    return result
}