function solution(absolutes, signs) {
    var result = 0
    for(i=0 ; i<absolutes.length ; i++){
        if(signs[i] == true){
            result += absolutes[i]
        } else {
            result -= absolutes[i]
        }
    }
    console.log(result)
    return result
}